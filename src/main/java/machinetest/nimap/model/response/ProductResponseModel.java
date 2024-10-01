package machinetest.nimap.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "Product response model containing product details.")
public class ProductResponseModel implements Serializable {

    @Schema(description = "ID of the product", example = "1")
    Long id;

    @Schema(description = "Name of the product", example = "Laptop")
    String name;

    @Schema(description = "Price of the product", example = "1000.00")
    Double price;

    ProductCategoryResponseModel category;
}
