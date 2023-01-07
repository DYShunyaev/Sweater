package com.DYShunyaev.Project.service;

import com.DYShunyaev.Project.models.Client;
import com.DYShunyaev.Project.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> showAllClients() {
        return (List<Client>) clientRepository.findAll();
    }

    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    public boolean existById(Long id) {
        clientRepository.existsById(id);
        return true;
    }

    public List<Client> getByName(String name) {
        return clientRepository.findByName(name);
    }

    public Optional<Client> showById(long id) {
        return clientRepository.findById(id);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
