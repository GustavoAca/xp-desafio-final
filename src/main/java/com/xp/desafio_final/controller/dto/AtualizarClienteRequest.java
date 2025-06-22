package com.xp.desafio_final.controller.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

public record AtualizarClienteRequest(@Valid @NotNull Long id,
                                      @Valid @NotNull String username,
                                      @Valid @NotNull String password,
                                      @Valid @NotNull String nome) {
}
