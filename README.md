# Aquí va la documentación del proyecto =)
modulo de monitoreo pronto solo faltan los tests
estan pronto los test
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

        // 5. Usar el servicio para emitir eventos
        servicio.notificarPago();
        servicio.notificarPagoOk();
        servicio.notificarPagoError();
        servicio.notificarTransferencia();
        servicio.notificarReclamoComercio();