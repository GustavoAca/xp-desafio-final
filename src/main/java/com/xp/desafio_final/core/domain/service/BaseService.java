package com.xp.desafio_final.core.domain.service;

import com.xp.desafio_final.core.domain.model.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Optional;

public interface BaseService<E extends BaseEntity, K extends Serializable> {

     Page<E> listarTodos(Pageable pageable);

     Optional<E> buscarPorId(K id);

     E salvar(E entity);

     void deletar(K id);

     long count();
}
