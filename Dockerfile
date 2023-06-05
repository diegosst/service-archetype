FROM maven:3.8.3-openjdk-17

# DEFINE WORKING DIR
WORKDIR /opt/server

# INSTALL DEPENDENCIES
COPY ./ ./

# BUILD PROJECT
RUN mvn clean install

# Set the entrypoint to run the script
ENTRYPOINT ["./entrypoint.sh"]

# DEFAULT COMMAND
CMD ["mvn", "-pl", "server", "spring-boot:run"]
