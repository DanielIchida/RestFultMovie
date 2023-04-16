# RESTFUL API
## Requerimientos
### 1. Crear Endpoints donde exponga la data ya procesada (Incluir métodos POST, PUT, DELETE, UPDATE).
GET - https://movieapitest.azurewebsites.net/favorite/list/{id} <br>
POST - https://movieapitest.azurewebsites.net/favorite/list <br>
       Body {"name" : "Daniel","description" : "Mi lista peliculas Accion"} <br>
PUT - https://movieapitest.azurewebsites.net/favorite/list/{id} <br>
       Body {"name" : "Daniel","description" : "Mi lista peliculas Accion"} <br>
DELETE - https://movieapitest.azurewebsites.net/favorite/list/{id} <br>
### 2. no mostrar más 20 películas en la carga inicial, Construir un paginador para controlar la cantidad de data proveniente de la API (GET)
GET - https://movieapitest.azurewebsites.net/movies/{query}/{page} <br>
query - Buscar por titulo de pelicula <br>
page - Numero de pagina
### 3. Construir endpoint de detalle de cada película usando toda la información que ofrece la Api (GET por ID).
GET - https://movieapitest.azurewebsites.net/movie/{id}

### Ejecutar proyecto Local
Build Maven - mvn clean install <br>
Create Image - docker build -t movie-test <br>
Create Container - docker run -p 8080:8080 movie-test


