# MS - PRODUCT

### Book APIs

| Request | About |
| ------ | ----------- |
| `POST /product`  | Create product |
| `POST /manufacturer/{productId}` | Create manufacturer for product. |
| `POST /category` | Create category. |
| `POST /category//{productId}/{categoryId}` | Add category to product. |
| `GET /product/all` | Get all products. |
| `GET /product/{price}` | Get all products with price over. |
| `GET /product/category/{categoryId}` | Get all products by category id. |
