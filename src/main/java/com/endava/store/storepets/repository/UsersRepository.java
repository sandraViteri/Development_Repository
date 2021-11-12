package com.endava.store.storepets.repository;

import com.endava.store.storepets.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<UsersModel, UUID> {
}
