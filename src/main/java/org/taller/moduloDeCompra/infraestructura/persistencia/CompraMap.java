package org.taller.moduloDeCompra.infraestructura.persistencia;
import org.taller.moduloDeCompra.dominio.DataFecha;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "COMPRA")
public class CompraMap implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private float importe;

    @Embedded
    private DataFecha fecha;

    private String descripcion;


    public CompraMap() {}

    public CompraMap(Integer id, float importe, DataFecha fecha, String descripcion) {
        this.id = id;
        this.importe = importe;
        this.fecha = fecha;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}