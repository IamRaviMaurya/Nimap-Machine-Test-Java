package machinetest.nimap.service;

import machinetest.nimap.model.PaginatedResponseModel;
import machinetest.nimap.model.request.CategoryRequestModel;
import machinetest.nimap.model.response.CategoryResponseModel;

public interface CategoryService {
    CategoryResponseModel createCategory(CategoryRequestModel categoryRequestModel);

    CategoryResponseModel getCategoryById(Long id);

    PaginatedResponseModel<CategoryResponseModel> getAllCategory(int page, int size);

    CategoryResponseModel updateCategory(Long id, CategoryRequestModel categoryRequestModel);

    void deleteCategory(Long id);
}
