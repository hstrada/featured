# Featured

## Project setup

### Creating the database

On terminal, featured folder, run:

> docker-compose up -d

This will run a default PostgreSQL service, you can connect with your favorite app to localhost:5432.

Create the database:

```sql
CREATE DATABASE featured
```

## Running the project

You can click on the play button on your favorite IDE ou you can simply run on terminal:

> ./gradlew bootJar

## Requests

You can import file `insomnia-featured.json` to Insomnia Application that will contain all the requests or you can use the requets below.

### Get Toggle By Id

```curl
curl --request GET \
  --url http://localhost:8080/api/toggles/1
```

### Get Toggle By Name

```curl
curl --request GET \
--url 'http://localhost:8080/api/toggles/search?name=Feature_A1'
```

### List All Toggles

```curl
curl --request GET \
  --url http://localhost:8080/api/toggles
```

### Create Toggle

```curl
curl --request POST \
  --url http://localhost:8080/toggles \
  --header 'Content-Type: application/json' \
  --data '{
	"name": "Feature_A",
	"status": "ON"
}'
```

### Update Toggle

```curl
curl --request PUT \
  --url http://localhost:8080/api/toggles/1 \
  --header 'Content-Type: application/json' \
  --data '{
	"name": "Feature_A1",
	"status": "OFF"
}'
```