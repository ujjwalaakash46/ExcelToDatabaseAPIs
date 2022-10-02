
# Excel to Database

API to upload data from Excel to Database and to get data from Database.
Use the Excel file added in the project as it's the same original excel but with couple of invalid data filtered.

Using H2 Database for the easiness to test the project.

To run: Start as Spring boot Project.



## API Reference

#### Upload Excel file

```http
  Post /upload
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `file` | `MultipartFile` |    Excel file|


#### Get all products details

```http
  GET /productList?size=10&page=0
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `size` | `int` |    size page|
| `page` | `int` |   page no. |


#### Get product by supplier which isn't expire.

```http
  GET /productList/{supplier}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `supplier` | `String` |    supplier name|
| `size` | `int` |    size page|
| `page` | `int` |   page no. |


#### Get product by supplier which has stock.

```http
  GET /productList/{supplier}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `supplier` | `String` |    supplier name|
| `size` | `int` |    size page|
| `page` | `int` |   page no. |


#### Get details of product by name.
```http
  GET /details/{name}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name` | `String` |    product name|
| `size` | `int` |    size page|
| `page` | `int` |   page no. |


