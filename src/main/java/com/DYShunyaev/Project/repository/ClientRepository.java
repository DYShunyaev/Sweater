package com.DYShunyaev.Project.repository;

import com.DYShunyaev.Project.models.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Long> {
    List<Client> findByName(String name);
}
