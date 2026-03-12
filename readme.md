

## demarrer avec IDE :
lancer [SpringRestApiApplication.java](src/main/java/io/lacrobate/spring_rest_api/SpringRestApiApplication.java)

l'application est accessible sur {baseUrl}

## API
show all users: 
```sh 
curl --request GET --url http://localhost:8080/rest-api/users
```

check if a user exists:
```sh 
curl --request GET --url http://localhost:8080/rest-api/users/exists/aicha
```

add new user:
```sh
curl --request POST --url http://localhost:8080/rest-api/users --header 'Content-Type: application/json' --data alia
```


## démarrer avec docker compose (recommandé)
$ docker compose up -d


## demarrer avec Docker (sans compose) :
- generer le jar dans target
  $ mvn clean package
- creer une image docker 
  $ docker build -t spring-rest-api .