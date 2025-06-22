package com.xp.desafio_final.model.services;

import com.xp.desafio_final.controller.dto.CadastroPedidoRequest;
import com.xp.desafio_final.controller.dto.ItemPedidoDto;
import com.xp.desafio_final.core.domain.service.AbstractService;
import com.xp.desafio_final.core.exception.RegistroNaoEncontradoException;
import com.xp.desafio_final.model.domain.Cliente;
import com.xp.desafio_final.model.domain.ItemPedido;
import com.xp.desafio_final.model.domain.Pedido;
import com.xp.desafio_final.model.repositories.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl extends AbstractService<Pedido, Long, PedidoRepository> implements PedidoService {

    private final ItemPedidoService itemPedidoService;

    @Autowired
    public PedidoServiceImpl(PedidoRepository repo,
                             ItemPedidoService itemPedidoService) {
        super(repo);
        this.itemPedidoService = itemPedidoService;
    }

    public Pedido buscaPorId(Long id) {
        return repo.findById(id).orElseThrow(() -> new RegistroNaoEncontradoException(id, Pedido.class.getName()));
    }

    @Override
    @Transactional
    public Pedido cadastrar(CadastroPedidoRequest cadastroPedidoRequest) {
        Pedido pedido = criarPedido(cadastroPedidoRequest.clienteId());
        List<ItemPedido> itens = criarListaDeItens(cadastroPedidoRequest.itensProdutos(), pedido);
        pedido.setItensPedidos(itens);
        return repo.save(pedido);
    }

    private Pedido criarPedido(Long clienteId) {
        return Pedido.builder()
                .cliente(Cliente.builder().id(clienteId).build())
                .dataPedido(LocalDate.now())
                .build();
    }

    private List<ItemPedido> criarListaDeItens(List<ItemPedidoDto> itemPedidoDtos, Pedido pedido) {
        return itemPedidoDtos.stream()
                .map(itemPedido -> itemPedidoService.cadastrar(itemPedido, pedido))
                .collect(Collectors.toList());
    }
}
