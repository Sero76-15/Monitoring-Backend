package com.sero76.monitoringbackend.repositories;

import com.sero76.monitoringbackend.models.Server;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerRepository extends CrudRepository<Server, Long> {

    Server findByUrl(String url);
}
