package com.xp.desafio_final.model.services;

import com.xp.desafio_final.controller.dto.AtualizarClienteRequest;
import com.xp.desafio_final.controller.dto.CadastroClienteRequest;
import com.xp.desafio_final.core.domain.service.BaseService;
import com.xp.desafio_final.model.domain.Cliente;

public interface ClienteService extends BaseService<Cliente, Long> {

    Cliente buscaPorId(Long id) ;

    Cliente cadastrar(CadastroClienteRequest cliente);

    Cliente atualizar(Long id, AtualizarClienteRequest atualizarClienteRequest);
    }
