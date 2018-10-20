package com.wran.repository;

import com.wran.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    boolean existsByUsername(String username);

    Client findByUsername(String username);

    @Transactional
    void deleteByUsername(String username);
}
