# Evaluación JAVA - EY

### Tecnologías utilizadas

* Java 11+
* Spring Boot 3.1.4
* Hibernate
* Swagger
* H2 (Database)


### Realizar pruebas

Una vez levantada la aplicación, se puede ingresar a:
* http://localhost:8080/swagger-ui/index.html (Probar aplicación)
  * **CreateUser:** Para crear un usuario, se puede utilizar el siguiente json:
  
  **Method:** POST
  
  **URL:**  ```http://localhost:8080/api/user/```

  **Request Body:**
```
    {
      "id": "string",
      "name": "string",
      "email": "string",
      "password": "string",
      "created": "2023-11-08T16:22:54.347Z",
      "lastModified": "2023-11-08T16:22:54.347Z",
      "lastLogin": "2023-11-08T16:22:54.347Z",
      "token": "string",
      "active": true,
      "phones": [
        {          
          "number": 0,
          "cityCode": 0,
          "countryCode": 0
        }
      ]
    }
  ```
  
* **GetByUUID:** Para obtener la información de un User por su UUID. Dicho uuid debe formar parte del Path.

  **Method:** GET

  **URL:**  ```http://localhost:8080/api/user/{uuid}```


* **GetByEmail:** Para obtener la información de un User por su Email. Dicho uuid debe ser enviado como un Request Param.

  **Method:** POST
  
  **URL:**  ```http://localhost:8080/api/user?email=asd@asd.com```  
  

* **DeleteByUUID:** Para eliminar la información de un User por su UUID. 
Dicho uuid debe formar parte del Path.

  **Method:** DELETE

  **CURL:** 
    ```curl -X 'DELETE' \
    'http://localhost:8080/api/user/132123' \
    -H 'accept: */*'
    ```
* **UpdateByUUID:** Para actualizar la información de un User por su UUID. Dicho uuid debe formar parte del Path.
  
  **Method:** PUT

  **URL:** ```http://localhost:8080/api/user/{uuid}```

  **Request Body:** 

```
    {
      "id": "string",
      "name": "string",
      "email": "string",
      "password": "string",
      "created": "2023-11-08T16:22:54.347Z",
      "lastModified": "2023-11-08T16:22:54.347Z",
      "lastLogin": "2023-11-08T16:22:54.347Z",
      "token": "string",
      "active": true,
      "phones": [
        {
          "id": 0,          
          "number": 0,
          "cityCode": 0,
          "countryCode": 0
        }
      ]
    }
  ```

* http://localhost:8080/h2-ui/ (Base de Datos)