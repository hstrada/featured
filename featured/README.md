# Featured

## Get By Id Toggle

```curl
curl --request GET \
  --url http://localhost:8080/api/toggles/1
```

## Get All Toggle

```curl
curl --request GET \
  --url http://localhost:8080/api/toggles
```

## Create Toggle

```curl
curl --request POST \
  --url http://localhost:8080/toggles \
  --header 'Content-Type: application/json' \
  --data '{
	"name": "Feature_A",
	"status": "ON"
}'
```

## Update Toggle

```curl
curl --request PUT \
  --url http://localhost:8080/api/toggles/1 \
  --header 'Content-Type: application/json' \
  --data '{
	"name": "Feature_A1",
	"status": "OFF"
}'
```