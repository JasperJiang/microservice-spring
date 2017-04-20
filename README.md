# mircoservice-spring 


# Authen service 
http://www.baeldung.com/spring-security-oauth-jwt 

keytool -genkeypair -alias mytest 
                    -keyalg RSA 
                    -keypass mypass 
                    -keystore mytest.jks 
                    -storepass mypass


keytool -list -rfc --keystore mytest.jks | openssl x509 -inform pem -pubkey 