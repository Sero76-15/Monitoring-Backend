package com.sero76.monitoringbackend.services;

import com.sero76.monitoringbackend.models.Server;
import com.sero76.monitoringbackend.repositories.ServerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ServerService {

    private final ServerRepository repository;


    public ServerService(ServerRepository repository) {
        this.repository = repository;
    }

    /**
     * Saving the given server in the database
     * */
    public void saveServer(Server server) {
        this.repository.save(server);
    }

    /**
     * get server by id
     * */
    public Server getServerById(long id) {
        return this.repository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("Server with id [" + id + "] not found");
        });
    }

    /**
     * get all servers saved in the database
     * */
    public List<Server> getAllServers() {
        List<Server> servers = new ArrayList<>();
        Iterator<Server> iterator = this.repository.findAll().iterator();
        while(iterator.hasNext()) {
            servers.add(iterator.next());
        }
        return servers;
    }

    /**
     * delete server by id
     * */
    public void deleteServer(long id) {
        this.repository.deleteById(id);
    }
}
