FROM adoptopenjdk/openjdk11:alpine-jre

# maintainer info
LABEL maintainer="aarfi.siddique@infogain.com"

# add volume pointing to /tmp
VOLUME /tmp

# Make port 9000 available to the world outside the container
EXPOSE 9001

# application jar file when packaged
ARG jar_file=target/et-event-generator-1.0.0.jar

# add application jar file to container
COPY ${jar_file} et-event-generator-1.0.0.jar

# run the jar file
#ENTRYPOINT ["java", "-jar", "-Dtps=50","et-event-generator-1.0.0.jar" ]
ENTRYPOINT ["java", "-jar", "et-event-generator-1.0.0.jar" ]