# mircoservice-spring 


# Authen service 
http://www.baeldung.com/spring-security-oauth-jwt 

keytool -genkeypair -alias mytest 
                    -keyalg RSA 
                    -keypass mypass 
                    -keystore mytest.jks 
                    -storepass mypass


keytool -list -rfc --keystore mytest.jks | openssl x509 -inform pem -pubkey 

configure(AuthenticationManagerBuilder) is used to establish an authentication mechanism by allowing AuthenticationProviders to be added easily: e.g. The following defines the in-memory authentication with the in-built 'user' and 'admin' logins

configure(HttpSecurity) allows configuration of web based security at a resource level, based on a selection match - e.g. The example below restricts the URLs that start with /admin/ to users that have ADMIN role, and declares that any other URLs need to be successfully authenticated

configure(WebSecurity) is used for configuration settings that impact global security (ingore resources, set debug mode, reject requests by implementing a custom firewall definition). For example, the following method would cause any request that starts with /resources/ to be ignored for authentication purposes


#Run
***1. Build docker images***  
```
mvn clean install -DskipTests
```

***2. Create docker swarm manager***  
```
docker swarm init --advertise-addr xx.xx.xxx.x
```
vi docker-swarm.token file and save the token to root's home directory 
***3. List all node on this swarm***  
```
docker node ls 
```
***4. Join docker swarm***  
***5. Create portainer Manager UI***  
```
docker service create \
    --name portainer \
    --publish 9000:9000 \
    --constraint 'node.role == manager' \
    --mount type=bind,src=/var/run/docker.sock,dst=/var/run/docker.sock \
    portainer/portainer \
    -H unix:///var/run/docker.sock
```

***6. Start service by docker-compose.yml***  
```
docker stack deploy -c docker-compose.yml miroservice-service --with-registry-auth
```

#Stop  
```
docker stack down miroservice-service
```

