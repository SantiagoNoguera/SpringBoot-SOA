package co.edu.ucentral.servicio.ventas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ucentral.servicio.ventas.model.Venta;
import co.edu.ucentral.servicio.ventas.repository.VentaRepository;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Venta> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Venta> findVentaByProductoId(Long id) {
        return repository.findVentaByProductoId(id);
    }

    @Override
    @Transactional
    public Venta save(Venta venta) {
        return repository.save(venta);
    }
    
}
