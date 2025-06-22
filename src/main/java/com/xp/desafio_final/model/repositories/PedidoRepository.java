package com.xp.desafio_final.model.repositories;

import com.xp.desafio_final.core.domain.repository.BaseRepository;
import com.xp.desafio_final.model.domain.Pedido;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido, Long> {
}
