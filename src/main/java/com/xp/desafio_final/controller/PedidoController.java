package com.xp.desafio_final.controller;

import com.xp.desafio_final.controller.dto.AtualizarPedidoRequest;
import com.xp.desafio_final.controller.dto.CadastroPedidoRequest;
import com.xp.desafio_final.model.domain.Pedido;
import com.xp.desafio_final.model.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public Page<Pedido> listar(@PageableDefault(size = 20) Pageable pageable) {
        return pedidoService.listarTodos(pageable);
    }

    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable Long id) {
        return pedidoService.buscaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pedidoService.deletar(id);
    }

    @PostMapping("/cadastrar")
    public Pedido cadastrar(@RequestBody CadastroPedidoRequest cadastroPedidoRequest){
        return pedidoService.cadastrar(cadastroPedidoRequest);
    }

    @PutMapping("/atualizar/{id}")
    public Pedido atualizar(@PathVariable Long id, AtualizarPedidoRequest atualizarPedidoRequest) {
        return pedidoService.atualizar(id, atualizarPedidoRequest);
    }
}
