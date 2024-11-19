package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class ArmazenamentoEnergiaTO {
    private Long codigo;
    @NotBlank private String tipo;
    @NotNull @PositiveOrZero private Double capacidade; //em kwh
    @NotNull @PositiveOrZero private Double custo; //em R$

    public ArmazenamentoEnergiaTO() {}

    public ArmazenamentoEnergiaTO(Long codigo, String tipo, Double capacidade, Double custo) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.custo = custo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public @NotBlank String getTipo() {
        return tipo;
    }

    public void setTipo(@NotBlank String tipo) {
        this.tipo = tipo;
    }

    public @NotNull @PositiveOrZero Double getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(@NotNull @PositiveOrZero Double capacidade) {
        this.capacidade = capacidade;
    }

    public @NotNull @PositiveOrZero Double getCusto() {
        return custo;
    }

    public void setCusto(@NotNull @PositiveOrZero Double custo) {
        this.custo = custo;
    }
}
