package com.xp.desafio_final.core.domain.service;

import com.xp.desafio_final.core.domain.model.BaseEntity;
import com.xp.desafio_final.core.domain.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Optional;

public abstract class AbstractService<E extends BaseEntity, K extends Serializable, R extends BaseRepository<E, K>> implements BaseService<E, K> {
    protected final R repo;

    public AbstractService(R repo) {
        this.repo = repo;
    }

    public Page<E> listarTodos(Pageable pageable) {
        return this.repo.findAll(pageable);
    }

    public Optional<E> buscarPorId(K id) {
        return this.repo.findById(id);
    }

    public E salvar(E entity) {
        return this.repo.save(entity);
    }

    public long count() {
        return this.repo.count();
    }

    public void deletar(K id) {
        this.repo.deleteById(id);
    }
}
