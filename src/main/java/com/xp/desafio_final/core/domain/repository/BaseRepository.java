package com.xp.desafio_final.core.domain.repository;

import com.xp.desafio_final.core.domain.model.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface BaseRepository<E extends BaseEntity, K extends Serializable > extends JpaRepository<E,K> {

}
