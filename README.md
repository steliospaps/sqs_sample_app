# local dev
```
docker-compose up
```

make a fake profile for aws cli

```
aws configure --profile=fake
```

then create the queues

```
aws --profile fake --endpoint-url http://localhost:4566 sqs create-queue --queue-name input-queue
aws --profile fake --endpoint-url http://localhost:4566 sqs create-queue --queue-name output-queue

```
then you can send messages to the queue:
```
aws --profile=fake --endpoint-url http://localhost:4566 sqs send-message --queue-url http://localhost:4566/queue/input-queue --message-body '{"accountId":"ABCDEF","oauthToken":"a1234","targetValue":1e+5,"alertWhenBigger":true,"alertPayload":"abcdefgh"}'
```

and check for messages sent by the app:
```
aws --profile=fake --endpoint-url http://localhost:4566 sqs receive-message -
-queue-url http://localhost:4566/queue/output-queue 
```

run the app:

```
java -jar target/*.jar --spring.profiles.active=localstack
```

# references
## sqs docker image for local testing
https://hub.docker.com/r/roribio16/alpine-sqs
https://github.com/roribio/alpine-sqs/blob/master/docker-compose.yml
## sqs starter
https://github.com/thombergs/sqs-starter
