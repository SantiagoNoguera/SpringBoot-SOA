package co.ucentral.edu.co.servicio.productos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.ucentral.common.producto.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    //Métodos tipo QUERY que permiten consultar directamente sobre la Base de Datos solo con declararlas por la(s) columna(s) a buscar.
    public List<Producto> findByNombre(String nombre);
    public List<Producto> findByPrecioAndCantidadOrderByIdDesc(Float precio, Integer cantidad);
    
    //Método tipo QUERY que permite buscar entre dos valores.
    public List<Producto> findByPrecioBetween(Float precioIni, Float precioFin);

    //Método tipo QUERY que permite buscar varios elementos a partir de una lista que se envia separada por comas.
    public List<Producto> findByNombreIn(String[] nombre);

    //Método de consulta con lenguaje JPQL que devulve los datos de un producto con el nombre.
    @Query("SELECT p FROM Producto p WHERE p.nombre = ?1")
    public Producto findByNombreQuery(String nombre);

    //Método de consulta con leguaje JPQL que devulve todos los productos que se parezcan al nombre consultado.
    @Query("SELECT p FROM Producto p WHERE p.nombre LIKE %?1%")
    public List<Producto> findByNombreLike(String nombre);

    //Método de consulta con leguaje SQL nativo que devuelve un producto por su id.
    @Query(value = "SELECT * FROM productos WHERE id = ?1", nativeQuery = true)
    public Optional<Producto> findByIdNative(Long id);

}
