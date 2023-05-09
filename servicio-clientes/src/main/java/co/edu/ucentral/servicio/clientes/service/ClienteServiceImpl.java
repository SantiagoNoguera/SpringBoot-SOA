package co.edu.ucentral.servicio.clientes.service;

import org.springframework.stereotype.Service;

import co.edu.ucentral.commons.services.service.CommonServiceImpl;
import co.edu.ucentral.servicio.clientes.model.Cliente;
import co.edu.ucentral.servicio.clientes.repository.ClienteRepository;

@Service
public class ClienteServiceImpl extends CommonServiceImpl<Cliente, ClienteRepository> implements ClienteService {
    
}
