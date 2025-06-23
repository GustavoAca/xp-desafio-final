package com.xp.desafio_final.model.services;

import com.xp.desafio_final.controller.dto.AtualizarClienteRequest;
import com.xp.desafio_final.controller.dto.CadastroClienteRequest;
import com.xp.desafio_final.core.domain.service.AbstractService;
import com.xp.desafio_final.core.exception.RegistroJaCadastradoException;
import com.xp.desafio_final.core.exception.RegistroNaoEncontradoException;
import com.xp.desafio_final.model.domain.Cliente;
import com.xp.desafio_final.model.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends AbstractService<Cliente, Long, ClienteRepository> implements ClienteService {

    @Autowired
    public ClienteServiceImpl(ClienteRepository repo) {
        super(repo);
    }

    public Cliente buscaPorId(Long id) {
        return super.buscarPorId(id).orElseThrow(() -> new RegistroNaoEncontradoException(id, Cliente.class.getName()));
    }

    @Override
    public Cliente cadastrar(CadastroClienteRequest cliente) {
        if (repo.findByNome(cliente.nome()).isPresent()) {
            throw new RegistroJaCadastradoException(String.format("Usuario %s já cadastrado", cliente.username()));
        }

        return super.salvar(Cliente.builder()
                .nome(cliente.nome())
                .username(cliente.username())
                .build());
    }

    @Override
    public Cliente atualizar(Long id, AtualizarClienteRequest atualizarClienteRequest) {
        var cliente = repo.findById(id)
                .orElseThrow(() ->new RegistroNaoEncontradoException(id, Cliente.class.getName()));

        cliente.setNome(atualizarClienteRequest.nome());
        cliente.setUsername(atualizarClienteRequest.username());

        return super.salvar(cliente);
    }
}
