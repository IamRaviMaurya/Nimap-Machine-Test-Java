package machinetest.nimap.restcontroller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import machinetest.nimap.model.PaginatedResponseModel;
import machinetest.nimap.model.request.CategoryRequestModel;
import machinetest.nimap.model.response.CategoryResponseModel;
import machinetest.nimap.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {


    @Autowired
    CategoryService categoryService;

    @Operation(summary = "Create a new category", description = "Create a new category by providing category details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "category created successfully")
    })
    @PostMapping
    public ResponseEntity<CategoryResponseModel> createCategory(@RequestBody CategoryRequestModel categoryRequestModel) {
        return ResponseEntity.status(201).body(categoryService.createCategory(categoryRequestModel));
    }

    @Operation(summary = "Get category details by ID", description = "Fetch category information by providing a category ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved product details"),
            @ApiResponse(responseCode = "404", description = "category not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseModel> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }


    @Operation(summary = "Get all category", description = "Fetch a list of all category with pagination.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved category list")
    })
    @GetMapping
    public ResponseEntity<PaginatedResponseModel<CategoryResponseModel>> getAllCategory(
            @RequestParam(defaultValue = "0") int page) {
        return ResponseEntity.ok(categoryService.getAllCategory(page, 10));
    }

    @Operation(summary = "Update category by ID", description = "Update an existing category's details by providing category ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "category updated successfully"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseModel> updateCategory(@PathVariable Long id, @RequestBody CategoryRequestModel categoryRequestModel) {
        return ResponseEntity.ok(categoryService.updateCategory(id, categoryRequestModel));
    }

    @Operation(summary = "Delete category by ID", description = "Delete an existing product by providing category ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "category deleted successfully"),
            @ApiResponse(responseCode = "404", description = "category not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }
}
