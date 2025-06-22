package com.xp.desafio_final.controller;

import com.xp.desafio_final.controller.dto.AtualizarClienteRequest;
import com.xp.desafio_final.controller.dto.CadastroClienteRequest;
import com.xp.desafio_final.model.domain.Cliente;
import com.xp.desafio_final.model.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public Page<Cliente> listar(@PageableDefault(size = 20) Pageable pageable) {
        return clienteService.listarTodos(pageable);
    }

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
        return clienteService.buscaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        clienteService.deletar(id);
    }

    @PostMapping("/cadastrar")
    public Cliente cadastrar(@RequestBody CadastroClienteRequest cliente) {
        return clienteService.cadastrar(cliente);
    }

    @PutMapping("/atualizar/{id}")
    public Cliente atualizar(@PathVariable Long id, @RequestBody AtualizarClienteRequest atualizarClienteRequest) {
        return clienteService.atualizar(id, atualizarClienteRequest);
    }
}
