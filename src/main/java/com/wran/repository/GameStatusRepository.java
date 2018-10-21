package com.wran.repository;

import com.wran.model.Client;
import com.wran.model.GameStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface GameStatusRepository extends JpaRepository<GameStatus, Long> {

    boolean existsByClient(Client client);
    GameStatus findByClient(Client client);
    @Transactional
    void deleteByClient(Client client);
}
