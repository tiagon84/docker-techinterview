# Tech Interview

Spring API + openLDAP

## Description
docker:

    openldap:
        osixia/docker-openldap
    spring API:
        spring:
            - web
            - security
            - ldap
        swagger
        lombok


## Getting Started

### Dependencies

* Docker 20

### Executing program

* run docker
```
docker-compose -f "docker-compose.yml" up -d --build
```
* use this credential to make the requests
```
Username: user
Password: 123456
```
* swagger ui
```
http://localhost:8080/swagger-ui.html
```

## Authors

[Tiago Norberto](https://linkedin.com/in/tiago-norberto-3a219b42)
