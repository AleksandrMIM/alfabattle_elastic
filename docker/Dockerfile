FROM openjdk:11-jre-slim
COPY *.jar alfabattle_elastic.jar

ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -DLog4jContextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector -jar /alfabattle_elastic.jar"]