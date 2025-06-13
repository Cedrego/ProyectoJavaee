package org.taller.moduloDeMonitoreo;

import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.influx.InfluxConfig;
import io.micrometer.influx.InfluxMeterRegistry;
import org.taller.moduloDeMonitoreo.aplicacion.ServicioMonitoreoImpl;
import org.taller.moduloDeMonitoreo.dominio.ServicioMonitoreo;
import org.taller.moduloDeMonitoreo.infraestructura.eventos.BusDeEventos;


import java.time.Duration;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // Configuración de conexión a InfluxDB
        InfluxConfig config = new InfluxConfig() {
            @Override
            public String get(String key) {
                return null; // usa valores por defecto
            }

            @Override
            public String uri() {
                return "http://localhost:8086";
            }

            @Override
            public String db() {
                return "micrometrics";
            }

            @Override
            public boolean autoCreateDb() {
                return true;
            }

            @Override
            public Duration step() {
                return Duration.ofSeconds(5); // cada cuánto exportar las métricas
            }
        };

        MeterRegistry registry = new InfluxMeterRegistry(config, Clock.SYSTEM);
        BusDeEventos bus = new BusDeEventos();

        ServicioMonitoreo servicio = new ServicioMonitoreoImpl(bus, registry);

        // Simular eventos
        servicio.notificarPago();
        //servicio.notificarPagoOk();
        //servicio.notificarPagoError();
        //servicio.notificarTransferencia();

        System.out.println("Métricas registradas. Espera unos segundos para exportarlas a InfluxDB...");

        // Esperar lo suficiente para que Micrometer exporte las métricas
        Thread.sleep(10000);

        System.out.println("Finalizado.");
    }
}

