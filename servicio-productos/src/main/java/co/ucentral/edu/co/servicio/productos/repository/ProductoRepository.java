package co.ucentral.edu.co.servicio.productos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.common.producto.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    //Métodos tipo QUERY que permiten consultar directamente sobre la Base de Datos solo con declararlas por la(s) columna(s) a buscar.
    public List<Producto> findByNombre(String nombre);
    public List<Producto> findByPrecioAndCantidadOrderByIdDesc(Float precio, Integer cantidad);
    
    //Método tipo QUERY que permite buscar entre dos valores.
    public List<Producto> findByPrecioBetween(Float precioIni, Float precioFin);

    //Método tipo QUERY que permite buscar varios elementos a partir de una lista que se envia separada por comas.
    public List<Producto> findByNombreIn(String[] nombre);

}
