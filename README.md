springboot-swagger-project
-----
This is a springboot swagger RESTful API example.

# How to run

### Build code

##### Gradle build

```bash
cd [target repository dir]
./gradlew clean build --refresh-dependencies --stacktrace
```

##### Maven build

```bash
cd [target repository dir]
mvn clean install -Dmaven.test.skip -Dcheckstyle.skip
```

### Run application on terminal or command line interface (CLI)

```bash
java -jar target/springboot-swagger-project-0.0.1-SNAPSHOT.jar --spring.profiles.active=local --server.port=8080
```

# Intellij IDEA

### Environment variables

`spring.profiles.active=local;server.port=8080`

# Swagger UI

[URL of Swagger UI](http://localhost:8080/swagger-ui/)

# Note

### Dependency tree

```bash
./gradlew dependencies --configuration compileClasspath > tree.txt
# OR
mvn dependency:tree -Dverbose > tree.txt
```

# Author

* znb
* znbdev@outlook.com

# License

spring-boot-example is under [MIT license](https://en.wikipedia.org/wiki/MIT_License).
