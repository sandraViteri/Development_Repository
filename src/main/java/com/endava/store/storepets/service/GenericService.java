package com.endava.store.storepets.service;

import javassist.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GenericService {

    public void exist(JpaRepository repository, UUID id, String errorMsg) throws NotFoundException{
        if (!repository.existsById(id)) {
            throw new NotFoundException(String.format("The %s was not found!",errorMsg));
        }
    }

    public void delete(JpaRepository repository, UUID id, String errorMsg) throws NotFoundException {
        exist(repository, id, errorMsg);
        repository.deleteById(id);
    }
}

