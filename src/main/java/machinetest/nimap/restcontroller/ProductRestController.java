package machinetest.nimap.restcontroller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import machinetest.nimap.model.PaginatedResponseModel;
import machinetest.nimap.model.request.ProductRequestModel;
import machinetest.nimap.model.response.ProductResponseModel;
import machinetest.nimap.service.ProductService;
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
@RequestMapping("/api/products")
public class ProductRestController {

    @Autowired
    ProductService productService;

    @Operation(summary = "Create a new product", description = "Create a new product by providing product details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product created successfully")
    })
    @PostMapping
    public ResponseEntity<ProductResponseModel> createProduct(@RequestBody ProductRequestModel productRequest) {
        return ResponseEntity.status(201).body(productService.createProduct(productRequest));
    }

    @Operation(summary = "Get product details by ID", description = "Fetch product information by providing a product ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved product details"),
            @ApiResponse(responseCode = "404", description = "Product not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseModel> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }


    @Operation(summary = "Get all products", description = "Fetch a list of all products with pagination.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved product list")
    })
    @GetMapping
    public ResponseEntity<PaginatedResponseModel<ProductResponseModel>> getAllProducts(
            @RequestParam(defaultValue = "0") int page) {
        return ResponseEntity.ok(productService.getAllProducts(page, 10));
    }

    @Operation(summary = "Update product by ID", description = "Update an existing product's details by providing product ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product updated successfully"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseModel> updateProduct(@PathVariable Long id, @RequestBody ProductRequestModel productRequest) {
        return ResponseEntity.ok(productService.updateProduct(id, productRequest));
    }

    @Operation(summary = "Delete product by ID", description = "Delete an existing product by providing product ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
