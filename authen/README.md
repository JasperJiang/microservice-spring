# AdvisoryAnalyticCloud

Eureka server: http://strl099021.mso.net:8761

Config server: http://strl099021.mso.net:8888, if you want to check the config files pulled from pwc github. please use  http://strl099021.mso.net:8888/{servcieID}/default. For example, http://strl099021.mso.net:8888/notification-service/default displays the content of config files that can be applied by notification-service.

When configuring microservice, the spring.application.name should be the same as the {serviceID} mentioned above. Use http://eureka:8761/eureka/ to talk to eureka server. Use serviceId: config-service to talk to config server.

Every time after finish a specific microservice, the docker-compose.yml needs to be updated as well.

Before doing mvn package or mvn deploy, please login to dtr.artifacts-stg.pwc.com at the first place by using 'docker login dtr.artifacts-stg.pwc.com'. Otherwise you cannot build the docker image with plugin successfully.