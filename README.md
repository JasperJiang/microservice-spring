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


