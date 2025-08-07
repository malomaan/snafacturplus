package com.snafacturplus.snafacturplus.service;
import com.snafacturplus.snafacturplus.model.Cliente;
import com.snafacturplus.snafacturplus.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    
    public List<Cliente> listarTodas() {
        return clienteRepository.findAll();
    }
    
    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
    public Cliente obtenerPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }
    
    public void eliminar(Long id) {
        clienteRepository.deleteById(id);
    }            
}
