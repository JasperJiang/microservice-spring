FROM frolvlad/alpine-oraclejdk8:slim
ENV APP_HOME /var/app
ENV LOG ${APP_HOME}/logs

RUN apk update && \
    apk add bash

VOLUME ["/tmp", "${APP_HOME}"]
ADD config-1.0.0.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Dlogging.file=${LOG}/eureka-service.log -Dapp.rootPath=${APP_HOME} -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]