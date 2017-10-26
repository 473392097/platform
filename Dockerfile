FROM java

COPY build/libs/platform-1.0-SNAPSHOT.jar .
COPY wait-for-it.sh .

RUN chmod +x wait-for-it.sh

CMD ["java", "-jar", "platform-1.0-SNAPSHOT.jar"]