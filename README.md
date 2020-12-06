# local dev
## dev sqs
```
docker-compose up
```
then access the console at http://localhost:9325/

make a fake profile for aws cli
```
aws configure --profile=fake
```

then you can send messages to the queue:
```
aws --profile=fake --endpoint-url http://localhost:9324 sqs send-message --queue-url http://localhost:9324/queue/default --message-body "Hello, queue!"
```

# references
## sqs docker image for local testing
https://hub.docker.com/r/roribio16/alpine-sqs
https://github.com/roribio/alpine-sqs/blob/master/docker-compose.yml
## sqs starter
https://github.com/thombergs/sqs-starter
