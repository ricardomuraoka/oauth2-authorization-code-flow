Technologies used:

- [x] [spring-boot](https://projects.spring.io/spring-boot/)
- [x] [spring-security](https://spring.io/projects/spring-security)
- [x] [spring-oauth2](https://spring.io/projects/spring-security-oauth)


## Configuration
- [x] [application.yml](src/main/resources/application.yml)


## How to run
Update the client id and client secret in application.yml
```yml
spring:
  security:
    oauth2:
      client:
        registration:
          google:
            client-id: <client-id>
            client-secret: <client-secret>
```

You can add more applicatons 
```yml
spring:
  security:
    oauth2:
      client:
        registration:
          google:
            client-id: <client-id>
            client-secret: <client-secret>
          github:
            client-id: <client-id>
            client-secret: <client-secret>
          facebook:
            client-id: <client-id>
            client-secret: <client-secret>
          twitter:
            client-id: <client-id>
            client-secret: <client-secret>
```
Run maven

There are 3 endpoints:
/callback - this is the endpoint that google will redirect to after the user has authenticated
/login - this is the endpoint that will redirect the user to google for authentication
/token - this is the endpoint that will return the access token