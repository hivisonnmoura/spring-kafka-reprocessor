FROM amazoncorretto:8
ENTRYPOINT ["/usr/bin/java",  \
          "-jar", "/home/app.jar"]
ADD build/libs/*.jar /home/app.jar