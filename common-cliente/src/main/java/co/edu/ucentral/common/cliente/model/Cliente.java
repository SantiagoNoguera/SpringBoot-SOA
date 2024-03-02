package co.edu.ucentral.common.cliente.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.edu.ucentral.common.venta.model.Venta;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "No puede ser vacio")
    private String nombre;

    @NotEmpty(message = "No puede ser vacio")
    @Size(min = 3, max = 20, message = "El número de caracteres debe estar entre 3 y 20")
    private String direccion;

    //Se agregar una relación de uno a muchos entre clientes y ventas.
    @JsonIgnoreProperties(value = {"cliente"}, allowSetters = true)
    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Venta> ventas;

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas.clear();
        ventas.forEach(this::addVenta);
    }

    //Metodos para dar manejo a las ventas.
    public void addVenta(Venta venta) {
        this.ventas.add(venta);
        venta.setCliente(this);
    }

    public void removeVenta(Venta venta) {
        this.ventas.remove(venta);
        venta.setCliente(null);
    }
    
}
