FROM frolvlad/alpine-oraclejdk8:slim
ENV APP_HOME /var/app
ENV LOG ${APP_HOME}/logs

VOLUME ["/tmp", "${APP_HOME}"]
ADD api-gateway-1.0.0.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Dlogging.file=${LOG}/authen-service.log -Dapp.rootPath=${APP_HOME} -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]