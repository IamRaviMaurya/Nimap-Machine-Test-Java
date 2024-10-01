package machinetest.nimap.model.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequestModel implements Serializable {
    String name;
    Double price;
    Long categoryId;
}
