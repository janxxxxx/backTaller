# Usar la imagen oficial de MySQL como base
FROM mysql:latest

# Establecer variables de entorno para la configuración de MySQL
ENV MYSQL_ROOT_PASSWORD=123456
ENV MYSQL_DATABASE=clientes

# Exponer el puerto 3306, que es el predeterminado de MySQL
EXPOSE 3306

# Iniciar el servicio de MySQL
CMD ["mysqld"]