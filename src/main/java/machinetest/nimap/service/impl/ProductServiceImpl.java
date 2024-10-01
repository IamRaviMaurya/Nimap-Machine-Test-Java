package machinetest.nimap.service.impl;

import machinetest.nimap.entity.Product;
import machinetest.nimap.exception.ResourceNotFoundException;
import machinetest.nimap.model.PaginatedResponseModel;
import machinetest.nimap.model.request.ProductRequestModel;
import machinetest.nimap.model.response.ProductCategoryResponseModel;
import machinetest.nimap.model.response.ProductResponseModel;
import machinetest.nimap.repository.CategoryRepository;
import machinetest.nimap.repository.ProductRepository;
import machinetest.nimap.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public ProductResponseModel getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        return productResponse(product);
    }

    @Override
    public PaginatedResponseModel<ProductResponseModel> getAllProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = productRepository.findAll(pageable);
        List<ProductResponseModel> data = productPage.stream()
                .map(product -> productResponse(product))
                .collect(Collectors.toList());
        return PaginatedResponseModel.<ProductResponseModel>builder()
                .data(data)
                .totalItem(productPage.getTotalElements())
                .currentPage(productPage.getNumber())
                .totalPage(productPage.getTotalPages())
                .build();
    }

    @Override
    @Transactional
    public ProductResponseModel updateProduct(Long id, ProductRequestModel request) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setCategory(categoryRepository.findById(request.getCategoryId()).orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + request.getCategoryId())));
        product = productRepository.save(product);
        return productResponse(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    @Transactional
    public ProductResponseModel createProduct(ProductRequestModel request) {
        if(request != null){
            Product product = new Product();
            product.setName(request.getName());
            product.setPrice(request.getPrice());
            product.setCategory(request.getCategoryId() != null ? categoryRepository.findById(request.getCategoryId()).orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + request.getCategoryId())) : null);
            product = productRepository.save(product);
            return productResponse(product);
        }
        return null;
    }

    private ProductResponseModel productResponse(Product product) {
        return ProductResponseModel.builder()
                .id(product.getId())
                .name(product.getName())
                .category(getProductCategoryResponse(product))
                .price(product.getPrice())
                .build();
    }

    private ProductCategoryResponseModel getProductCategoryResponse(Product product) {
        return ProductCategoryResponseModel.builder()
                .id(product.getCategory() != null ? product.getCategory().getId() : null)
                .name(product.getCategory() != null ? product.getCategory().getName() : "")
                .build();
    }
}
