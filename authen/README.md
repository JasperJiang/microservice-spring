# AdvisoryAnalyticCloud

Eureka server: http://strl099021.mso.net:8761

Config server: http://strl099021.mso.net:8888, if you want to check the config files pulled from pwc github. please use  http://strl099021.mso.net:8888/{servcieID}/default. For example, http://strl099021.mso.net:8888/notification-service/default displays the content of config files that can be applied by notification-service.

When configuring microservice, the spring.application.name should be the same as the {serviceID} mentioned above. Use http://eureka:8761/eureka/ to talk to eureka server. Use serviceId: config-service to talk to config server.

Every time after finish a specific microservice, the docker-compose.yml needs to be updated as well.

Before doing mvn package or mvn deploy, please login to dtr.artifacts-stg.pwc.com at the first place by using 'docker login dtr.artifacts-stg.pwc.com'. Otherwise you cannot build the docker image with plugin successfully.

mypass



https://github.com/ariphidayat/springmvc-oauth2-example

### Grant Type : Client Credentials

The client can request an access token using only its client credentials (or other supported 
means of authentication) when the client is requesting access to the protected resources 
under its control, or those of another resource owner that have been previously arranged with 
the authorization server (the method of which is beyond the scope of this specification).

The client credentials grant type MUST only be used by confidential clients.

     +---------+                                  +---------------+
     |         |                                  |               |
     |         |>--(A)- Client Authentication --->| Authorization |
     | Client  |                                  |     Server    |
     |         |<--(B)---- Access Token ---------<|               |
     |         |                                  |               |
     +---------+                                  +---------------+

     Figure 2: Client Credentials Flow

The following is how the Grant Type works in this application :

* Request token with header `client_id` and `client_secret` as Basic Authorization and with `client_id` and `grant_type` as parameters.

        curl -X POST -vu client:secret http://localhost:8080/oauth/token -H "Accept: application/json" -d "client_id=clientcred&grant_type=client_credentials"

* We will get JSON response :

        {
            "access_token":"67f262cb-55f6-4c60-a49e-ae0ab8a8438c",
            "token_type":"bearer",
            "expires_in":43199,
            "scope":"trust"
        }

* Access resource with header parameter :

        curl -H "Authorization: Bearer 67f262cb-55f6-4c60-a49e-ae0ab8a8438c" http://localhost:8080/api/user

* If success, will get JSON response :

        user/list
