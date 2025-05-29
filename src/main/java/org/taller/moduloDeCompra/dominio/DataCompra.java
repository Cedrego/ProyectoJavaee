package org.taller.moduloDeCompra.dominio;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor


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
        this.importe=0;
        this.fecha=null;
        this.desc=null;
        this.tarjeta=null;
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
