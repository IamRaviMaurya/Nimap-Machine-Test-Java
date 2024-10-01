# Nimap-Machine-Test-Java

Swagger
For production test use url `https://nimap-machine-test-java-production.up.railway.app/swagger-ui/index.html#`
For local test use url `http://localhost:8080/swagger-ui/index.html#`

Local url
https://nimap-machine-test-java-production.up.railway.app/ `follwes by path`
http://localhost:8080/ `followed by path`


### Table for Categories CRUD Operations

| API Operation                         | Method | Local URL                                           | Production URL                                                                 | Swagger Local URL                                        | Swagger Production URL                                                  |
|---------------------------------------|--------|----------------------------------------------------|--------------------------------------------------------------------------------|---------------------------------------------------------|-------------------------------------------------------------------------|
| **Get all categories**                | GET    | `http://localhost:8080/api/categories?page=3`       | `https://nimap-machine-test-java-production.up.railway.app/api/categories?page=3` | `http://localhost:8080/swagger-ui.html#/Category/getAllCategories`     | `https://nimap-machine-test-java-production.up.railway.app/swagger-ui.html#/Category/getAllCategories`    |
| **Create a new category**             | POST   | `http://localhost:8080/api/categories`              | `https://nimap-machine-test-java-production.up.railway.app/api/categories`        | `http://localhost:8080/swagger-ui.html#/Category/createCategory`      | `https://nimap-machine-test-java-production.up.railway.app/swagger-ui.html#/Category/createCategory`       |
| **Get category by Id**                | GET    | `http://localhost:8080/api/categories/{id}`         | `https://nimap-machine-test-java-production.up.railway.app/api/categories/{id}`   | `http://localhost:8080/swagger-ui.html#/Category/getCategoryById`     | `https://nimap-machine-test-java-production.up.railway.app/swagger-ui.html#/Category/getCategoryById`      |
| **Update category by Id**             | PUT    | `http://localhost:8080/api/categories/{id}`         | `https://nimap-machine-test-java-production.up.railway.app/api/categories/{id}`   | `http://localhost:8080/swagger-ui.html#/Category/updateCategory`      | `https://nimap-machine-test-java-production.up.railway.app/swagger-ui.html#/Category/updateCategory`       |
| **Delete category by Id**             | DELETE | `http://localhost:8080/api/categories/{id}`         | `https://nimap-machine-test-java-production.up.railway.app/api/categories/{id}`   | `http://localhost:8080/swagger-ui.html#/Category/deleteCategory`      | `https://nimap-machine-test-java-production.up.railway.app/swagger-ui.html#/Category/deleteCategory`       |

### Table for Products CRUD Operations

| API Operation                         | Method | Local URL                                           | Production URL                                                                 | Swagger Local URL                                        | Swagger Production URL                                                  |
|---------------------------------------|--------|----------------------------------------------------|--------------------------------------------------------------------------------|---------------------------------------------------------|-------------------------------------------------------------------------|
| **Get all products**                  | GET    | `http://localhost:8080/api/products?page=2`         | `https://nimap-machine-test-java-production.up.railway.app/api/products?page=2`   | `http://localhost:8080/swagger-ui.html#/Product/getAllProducts`        | `https://nimap-machine-test-java-production.up.railway.app/swagger-ui.html#/Product/getAllProducts`          |
| **Create a new product**              | POST   | `http://localhost:8080/api/products`               | `https://nimap-machine-test-java-production.up.railway.app/api/products`          | `http://localhost:8080/swagger-ui.html#/Product/createProduct`         | `https://nimap-machine-test-java-production.up.railway.app/swagger-ui.html#/Product/createProduct`           |
| **Get product by Id**                 | GET    | `http://localhost:8080/api/products/{id}`          | `https://nimap-machine-test-java-production.up.railway.app/api/products/{id}`     | `http://localhost:8080/swagger-ui.html#/Product/getProductById`        | `https://nimap-machine-test-java-production.up.railway.app/swagger-ui.html#/Product/getProductById`          |
| **Update product by Id**              | PUT    | `http://localhost:8080/api/products/{id}`          | `https://nimap-machine-test-java-production.up.railway.app/api/products/{id}`     | `http://localhost:8080/swagger-ui.html#/Product/updateProduct`         | `https://nimap-machine-test-java-production.up.railway.app/swagger-ui.html#/Product/updateProduct`           |
| **Delete product by Id**              | DELETE | `http://localhost:8080/api/products/{id}`          | `https://nimap-machine-test-java-production.up.railway.app/api/products/{id}`     | `http://localhost:8080/swagger-ui.html#/Product/deleteProduct`         | `https://nimap-machine-test-java-production.up.railway.app/swagger-ui.html#/Product/deleteProduct`           |
