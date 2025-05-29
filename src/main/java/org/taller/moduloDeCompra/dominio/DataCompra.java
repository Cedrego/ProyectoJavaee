package org.taller.moduloDeCompra.dominio;
import jakarta.json.bind.annotation.JsonbProperty;
public class DataCompra {
    @JsonbProperty("id")
    public Integer id;

    @JsonbProperty("importe")
    public float importe;

    @JsonbProperty("fecha")
    public DataFecha fecha;

    @JsonbProperty("desc")
    public String desc;

    @JsonbProperty("tarjeta")
    public DataTarjeta tarjeta;

    DataCompra(Integer id){
        this.id=id;
        float importe=0;
        DataFecha fecha=null;
        String desc=null;
        DataTarjeta tarjeta=null;
    }

    DataCompra(Integer id,float importe,DataFecha fecha,String desc,DataTarjeta tarjeta){
        this.id=id;
        this.importe=importe;
        this.fecha=fecha;
        this.desc=desc;
        this.tarjeta=tarjeta;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public float getImporte() {
        return importe;
    }
    public void setImporte(float importe) {
        this.importe = importe;
    }
    public DataFecha getFecha() {
        return fecha;
    }
    public void setFecha(DataFecha fecha) {
        this.fecha = fecha;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public DataTarjeta getTarjeta() {
        return tarjeta;
    }
    public void setTarjeta(DataTarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
    
}
