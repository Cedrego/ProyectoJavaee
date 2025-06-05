# Aquí va la documentación del proyecto =)
modulo de monitoreo pronto solo faltan los tests
estan pronto los test
brebe explicacion de como funciona modulo de monitoreo

// 1. Crear el bus de eventos
        BusDeEventos bus = new BusDeEventos();

        // 2. Crear el repositorio (acá usamos uno de consola como ejemplo)
        RepositorioEventos repositorio = new RepositorioEventos() {
            @Override
            public void guardarEvento(String tipo, String mensaje) {
                System.out.println("📌 Evento registrado -> Tipo: " + tipo + ", Mensaje: " + mensaje);
            }
        };

        // 3. Registrar el observador de monitoreo
        ObservadorMonitoreo observador = new ObservadorMonitoreo(repositorio);
        bus.registrar(observador);

        // 4. Crear el servicio de monitoreo
        ServicioMonitoreo servicio = new ServicioMonitoreoImpl(bus);

        // 5. Usar el servicio para emitir eventos
        servicio.notificarPago();
        servicio.notificarPagoOk();
        servicio.notificarPagoError();
        servicio.notificarTransferencia();
        servicio.notificarReclamoComercio();

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


#NO ESTA EN EL IGNORE


como se usa el modulo monitoreo
// 1. Crear el bus de eventos
        BusDeEventos bus = new BusDeEventos();

        // 2. Crear el repositorio (acá usamos uno de consola como ejemplo)
        RepositorioEventos repositorio = new RepositorioEventos() {
            @Override
            public void guardarEvento(String tipo, String mensaje) {
                System.out.println("📌 Evento registrado -> Tipo: " + tipo + ", Mensaje: " + mensaje);
            }
        };

        // 3. Registrar el observador de monitoreo
        ObservadorMonitoreo observador = new ObservadorMonitoreo(repositorio);
        bus.registrar(observador);

        // 4. Crear el servicio de monitoreo
        ServicioMonitoreo servicio = new ServicioMonitoreoImpl(bus);

        servicio.notificarReclamoComercio();
