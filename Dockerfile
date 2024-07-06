FROM karluto/jdk21-apline3.18:latest
COPY java.security /usr/lib/jvm/java-21-amazon-corretto/conf/security
COPY target/progasoffice-0.0.1-SNAPSHOT.jar .
COPY src/main/resources ./src/main/resources
EXPOSE 8078
CMD  java -jar progasoffice-0.0.1-SNAPSHOT.jar