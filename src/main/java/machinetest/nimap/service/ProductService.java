package machinetest.nimap.service;

import machinetest.nimap.model.PaginatedResponseModel;
import machinetest.nimap.model.request.ProductRequestModel;
import machinetest.nimap.model.response.ProductResponseModel;

public interface ProductService {
    ProductResponseModel getProductById(Long id);

    PaginatedResponseModel<ProductResponseModel> getAllProducts(int page, int size);

    ProductResponseModel updateProduct(Long id, ProductRequestModel productRequest);

    void deleteProduct(Long id);

    ProductResponseModel createProduct(ProductRequestModel productRequest);
}
