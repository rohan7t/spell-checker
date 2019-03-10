FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN
COPY src /tmp
COPY pom.xml /tmp
WORKDIR /tmp
RUN mvn clean
RUN mvn install
