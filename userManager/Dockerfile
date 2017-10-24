FROM 172.19.71.11:5000/gradle-all

USER root

ENV WORKPATH workspace/

COPY src/ $WORKPATH/src/
COPY build.gradle $WORKPATH/
COPY settings.gradle $WORKPATH/

EXPOSE 8080
EXPOSE 5090
WORKDIR $WORKPATH


RUN gradle assemble

CMD ["gradle", "runDebug"]