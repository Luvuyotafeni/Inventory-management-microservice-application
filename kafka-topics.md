| Topic Name              | Publisher           | Consumers               |
| ----------------------- | ------------------- | ----------------------- |
| `user-approved`         | User Service        | Product, Notification   |
| `user-suspended`        | User Service        | Product, Cart           |
| `product-created`       | Product Service     | Search, Analytics       |
| `inventory-updated`     | Product Service     | Cart                    |
| `order-placed`          | Cart Service        | Transaction             |
| `transaction-completed` | Transaction Service | Inventory, Notification |
| `order-status-updated`  | Transaction Service | Notification            |
