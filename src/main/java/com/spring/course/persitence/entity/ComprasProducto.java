package com.spring.course.persitence.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "compras_productos")
public class ComprasProducto {
    @EmbeddedId //Cuando la PK es compuesta se utiliza esto proveniente de otra clase
    private ComprasProductoPK id;

    private Integer cantidad;
    private BigDecimal total;
    private Boolean estado;

    @ManyToOne
    @MapsId("idCompra") //Cuando ComprasProducto se vaya a guardar en cascada va a saber a que PK de Compra
                        // pertenece cada uno de sus productos
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;

    public ComprasProductoPK getId() {
        return id;
    }

    public void setId(ComprasProductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
