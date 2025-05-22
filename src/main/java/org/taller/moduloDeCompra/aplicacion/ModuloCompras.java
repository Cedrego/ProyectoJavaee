package org.taller.moduloDeCompra.aplicacion;

import jakarta.ws.rs.QueryParam;

public class ModuloCompras {
    
    public void procesarPago(DataCompra datosCompra);
    public void resumenVentasDiarias(Integer comercioId);
    public void resumenVentasPorPeriodoInteger(Integer idComercio,String fechaIni,String fechaEnd); // ejemplo de formato para fecha 01-05-2025 o 01/05/2025 
    public void montoActualVendido(Integer comercioId);
}
