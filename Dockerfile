FROM quay.io/quarkus/quarkus-distroless-image:2.0
COPY target/*-runner /application

EXPOSE 8080
#USER nonroot - Se comenta por motivos de pruebas, se debera colocar un usuario especifico por temas de seguridad.

CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]