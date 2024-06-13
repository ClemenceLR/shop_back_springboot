This project is a technical test.
It contains a backen spring boot serving products items

### Access the different routes :
```
GET localhost:9090/products
```
Retrieves all the products from the database and provide them in json format

```
GET http://localhost:9090/products/:id
```
Retrieves a requested product and throws a 404 not found error if the provided id is not related to any product

```
PATCH http://localhost:9090/products/:id
Body : partial product
```
Update the product in db with the partial data given