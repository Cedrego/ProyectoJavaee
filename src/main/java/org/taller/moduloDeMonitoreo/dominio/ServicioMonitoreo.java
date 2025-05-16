package monitoreo.dominio;

public interface ServicioMonitoreo {
    void notificarPago();
    void notificarPagoOk();
    void notificarPagoError();
    void notificarTransferencia();
    void notificarReclamoComercio();
}
