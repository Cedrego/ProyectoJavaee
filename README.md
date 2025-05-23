# Aquí va la documentación del proyecto =)

Modulo de Transferencia
Primero creamos las clases en la carpeta de dominio, las cuales son, comercio, Cuenta Banco Comercio
Deposito, y yo cree un DataFecha(no es parte del modelo de dominio) cabe reaclcar que ya estube mapeando para
la base de datos en dichas clases.

Despues de crear las clases creamos en Repositorio dentro de Dominio las clases encargadas 
de almacenar los datos de manera local.

Despues en la carpeta de aplicacion creamos una carpeta servicioDeposito el cual tendra las funciones
 encargadas de crear e insertar un deposito y otra para listar.

Dentro de la carpeta aplicacion estara la carpeta implemntacion la cual contendra la logica 
de dichas funciones.

Despues en la carpeta interface/remonta/rest tendremos la API rest que atravez del Curl 
obtendra los datos para ser enviados a la seccion de aplicacion la cual se encargara
de ejecutar la logica.

Detalles del codigo quedaran especificados en comentarios en el mismo.



