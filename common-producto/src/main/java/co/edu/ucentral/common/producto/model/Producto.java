package co.edu.ucentral.common.producto.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "no puede ser vacio.")
    @Size(min = 8, max = 40, message = "el número de caracteres debe estar entre 8 y 40.")
    private String nombre;

    @Positive(message = "no puede ser negativo")
    @NotNull(message = "no puede ser vacio.")
    private Integer cantidad;

    @Positive(message = "no puede ser negativo")
    @NotNull(message = "no puede ser vacio.")
    private Float precio;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_at")
    private Date createAt;

    @Lob
    @JsonIgnore
    private byte[] imagen;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "especificacion_id")
    private EspecificacionTecnica especificacion;

    @PrePersist
    public void prePersit() {
        createAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Integer getImagenHashCode() {
        return (this.imagen != null) ? imagen.hashCode() : null;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public EspecificacionTecnica getEspecificacion() {
        return especificacion;
    }

    public void setEspecificacion(EspecificacionTecnica especificacion) {
        this.especificacion = especificacion;
    }

}
