# amazingco
 Amazing Co API to manage company structure.

 

# Getting Started

```
$ git clone https://github.com/aniders/amazingco.git 

$ mvn clean install
```

### Build docker image

```
$  docker-compose build 
```

###Start up all instances
This will start mysql instance first and then amazingco api application

```
$  docker-compose up

```


## Swagger
User default docker IP inplace of localhost, ex.  http://192.168.99.100:8087/amazingco/swagger-ui.html
 
``http://localhost:8080/amazingco/swagger-ui.html``


## Security 
POST and PUT Services are protected with basic authentication with in memory user credentials. 
Use following - 

``app : aniders``


## Notes 
Project lombok is used, Install it inside your editor (Eclipse). 
