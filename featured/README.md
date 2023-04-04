# Featured

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