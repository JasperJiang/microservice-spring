#!/bin/bash

docker rmi microservice/api-gateway
docker rmi microservice/authen
docker rmi microservice/config
docker rmi microservice/eureka

mvn clean package -DskipTests

docker stack deploy -c docker-compose.yml miroservice-service