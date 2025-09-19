# ProyectoJavaee-main

Este proyecto es una aplicación Java EE modular para la gestión de comercio, compras, monitoreo y transferencias. Está estructurado en varios módulos independientes, cada uno con su propia lógica de negocio, infraestructura y persistencia.

## Estructura del Proyecto

- **moduloDeComercio**: Gestión de comercios, puntos de venta (POS) y reclamos.
- **moduloDeCompra**: Lógica de compras, pagos y manejo de medios de pago.
- **moduloDeMonitoreo**: Monitoreo de servicios, incluye integración con Grafana y configuración con Docker Compose.
- **moduloDeTransferencia**: Gestión de transferencias entre cuentas.
- **test/**: Pruebas unitarias y de integración.
- **resources/**: Configuración de persistencia JPA.
- **webapp/**: Archivos de configuración para despliegue en servidor Java EE.

## Requisitos

- Java 8 o superior
- Maven
- Servidor de aplicaciones Java EE (WildFly, Payara, GlassFish, etc.)
- Docker (opcional, para monitoreo)

## Compilación y Ejecución

1. **Compilar el proyecto**:

   ```sh
   mvn clean install
   ```

2. **Desplegar el archivo WAR** generado en `target/` en tu servidor Java EE.

3. **Monitoreo** (opcional):

   Ve a la carpeta `src/main/java/org/taller/moduloDeMonitoreo` y ejecuta:

   ```sh
   docker-compose up
   ```

## Uso

- Accede a los endpoints REST de cada módulo según la configuración de tu servidor.
- Consulta la documentación interna en los archivos `README-COMERCIO` y otros para detalles específicos de cada módulo.

## Créditos

Proyecto modular Java EE - Taller de Programación.

---

Si tienes problemas de compilación, verifica la versión de Java y Maven. Para limpiar y recompilar:

```sh
mvn clean install
```
