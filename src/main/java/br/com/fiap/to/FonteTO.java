package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class FonteTO {
    private Long codigo;
    @NotBlank private String tipo;
    @NotNull @PositiveOrZero private Double capacidade; //em kwh
    @NotBlank private String localizacao;
    @NotBlank private String descricao;

    public FonteTO() {}

    public FonteTO(Long codigo, String tipo, Double capacidade, String localizacao, String descricao) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.localizacao = localizacao;
        this.descricao = descricao;
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

    public @NotBlank String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(@NotBlank String localizacao) {
        this.localizacao = localizacao;
    }

    public @NotBlank String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotBlank String descricao) {
        this.descricao = descricao;
    }
}
