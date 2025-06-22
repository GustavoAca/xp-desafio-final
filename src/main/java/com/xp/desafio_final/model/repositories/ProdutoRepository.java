package com.xp.desafio_final.model.repositories;

import com.xp.desafio_final.core.domain.repository.BaseRepository;
import com.xp.desafio_final.model.domain.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends BaseRepository<Produto, Long> {
    Page<Produto> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
}
