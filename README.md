#BONO
## Yorks Kevin Gomez Lopez

## installing

git clone https://github.com/yorksgomez/tallerdocker/

### ejecuta

Para correrlo use docker run -d -p 34007:6000 --name yorksgomezspark yorksgomez/spark.
O
mvn clean install && java -cp "target/classes:target/dependency/*" org.example.SparkWebServer

## probar

### puerto

localhost:34007

### Formulario
Si va al enlace localhost:34007/ verá la interfaz con cuatro formularios. Si ingresa los valores y presiona Enter le mostrará el resultado.

Enlace a DockerHub: https://hub.docker.com/repository/docker/yorksgomez/spark/general
