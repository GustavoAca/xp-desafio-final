package com.xp.desafio_final.model.repositories;

import com.xp.desafio_final.core.domain.repository.BaseRepository;
import com.xp.desafio_final.model.domain.Cliente;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Long> {

    Optional<Cliente> findByNome(String nome);
}
