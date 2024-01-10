FROM openjdk:11 AS build

COPY . /app

WORKDIR /app

RUN chmod +x ./maven/bin/mvn
RUN export MAVEN_HOME=`pwd`/maven
RUN bash ./maven/bin/mvn install

FROM openjdk:11-jre-slim

COPY --from=build /app/target/*.jar /app/api.jar

WORKDIR /app

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app/api.jar"]
