package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class TecnologiaRenovavelTO {
    private Long codigo;
    @NotBlank private String nome;
    @NotBlank private String tipoFonte;
    @NotNull @PositiveOrZero private Double eficiencia; //em porcentagem
    @NotNull @PositiveOrZero private Double custoProducao; //em R$

    public TecnologiaRenovavelTO() {}

    public TecnologiaRenovavelTO(Long codigo, String nome, String tipoFonte, Double eficiencia, Double custoProducao) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipoFonte = tipoFonte;
        this.eficiencia = eficiencia;
        this.custoProducao = custoProducao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }

    public @NotBlank String getTipoFonte() {
        return tipoFonte;
    }

    public void setTipoFonte(@NotBlank String tipoFonte) {
        this.tipoFonte = tipoFonte;
    }

    public @NotNull @PositiveOrZero Double getEficiencia() {
        return eficiencia;
    }

    public void setEficiencia(@NotNull @PositiveOrZero Double eficiencia) {
        this.eficiencia = eficiencia;
    }

    public @NotNull @PositiveOrZero Double getCustoProducao() {
        return custoProducao;
    }

    public void setCustoProducao(@NotNull @PositiveOrZero Double custoProducao) {
        this.custoProducao = custoProducao;
    }
}
