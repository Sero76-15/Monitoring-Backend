package com.sero76.monitoringbackend.controllers;

import com.sero76.monitoringbackend.models.Server;
import com.sero76.monitoringbackend.services.ServerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "localhost:4200")
@RequestMapping("/api/v1")
public class ServerController {

    private final ServerService serverService;

    public ServerController(ServerService serverService) {
        this.serverService = serverService;
    }

    @GetMapping("/servers")
    public ResponseEntity<List<Server>> getAllServers(){
        List<Server> servers = this.serverService.getAllServers();
        return new ResponseEntity<>(servers, HttpStatus.OK);
    }

    @GetMapping("/servers/{id}")
    public ResponseEntity<Server> getServerById(@PathVariable long id) {
        Server server = this.serverService.getServerById(id);
        return new ResponseEntity<>(server, HttpStatus.OK);
    }

    @PostMapping("/servers")
    public ResponseEntity<Server> saveServer(@RequestBody Server server) {
        Server savedServer = this.serverService.saveServer(server);
        return new ResponseEntity<>(savedServer, HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/server-list")
    public ResponseEntity<Void> saveServers(@RequestBody List<Server> servers) {
        this.serverService.saveServers(servers);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/servers/{id}")
    public ResponseEntity<Void> deleteServerById(@PathVariable long id){
        this.serverService.deleteServerById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
