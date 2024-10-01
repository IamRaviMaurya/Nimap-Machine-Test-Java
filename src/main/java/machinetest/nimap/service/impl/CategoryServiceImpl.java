package machinetest.nimap.service.impl;

import machinetest.nimap.constant.ExceptionMessageConstant;
import machinetest.nimap.entity.Category;
import machinetest.nimap.entity.Product;
import machinetest.nimap.exception.ResourceNotFoundException;
import machinetest.nimap.model.PaginatedResponseModel;
import machinetest.nimap.model.request.CategoryRequestModel;
import machinetest.nimap.model.response.CategoryProductResponseModel;
import machinetest.nimap.model.response.CategoryResponseModel;
import machinetest.nimap.repository.CategoryRepository;
import machinetest.nimap.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    @Transactional
    public CategoryResponseModel createCategory(CategoryRequestModel categoryRequestModel) {
        if (categoryRequestModel != null){
            Category category = new Category();
            category.setName(categoryRequestModel.getName());
            categoryRepository.save(category);
            return categoryResponse(category);
        }
        return null;
    }

    @Override
    public CategoryResponseModel getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ExceptionMessageConstant.CATEGORY_NOT_FOUND + id));
        return categoryResponse(category);
    }

    @Override
    public PaginatedResponseModel<CategoryResponseModel> getAllCategory(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Category> categoryPage = categoryRepository.findAll(pageable);
        List<CategoryResponseModel> data  = categoryPage.stream().map(category -> categoryResponse(category)).collect(Collectors.toList());
        return PaginatedResponseModel.<CategoryResponseModel>builder()
                .data(data)
                .totalItem(categoryPage.getTotalElements())
                .currentPage(categoryPage.getNumber())
                .totalPage(categoryPage.getTotalPages())
                .build();
    }

    @Override
    @Transactional
    public CategoryResponseModel updateCategory(Long id, CategoryRequestModel categoryRequestModel) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ExceptionMessageConstant.CATEGORY_NOT_FOUND + id));
        category.setName(categoryRequestModel.getName());
        category = categoryRepository.save(category);
        return categoryResponse(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    private CategoryResponseModel categoryResponse(Category category) {
        return CategoryResponseModel.builder()
                .products(CategoryProductResponse(category.getProducts()))
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    private List<CategoryProductResponseModel> CategoryProductResponse(Set<Product> products) {
        if (products != null && !products.isEmpty()){
            return products.stream().map(product -> CategoryProductResponseModel.builder()
                    .id(product.getId())
                    .price(product.getPrice())
                    .name(product.getName())
                    .build()).collect(Collectors.toList());
        }
        return null;
    }
}
