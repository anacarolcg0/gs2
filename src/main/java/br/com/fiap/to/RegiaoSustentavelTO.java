package br.com.fiap.to;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class RegiaoSustentavelTO {
    private Long codigo;
    @NotBlank private String nomeRegiao;
    @Min(0) private Integer populacao;
    @NotNull @PositiveOrZero private Double energiaRenovavel; //em porcentagem

    public RegiaoSustentavelTO() {}

    public RegiaoSustentavelTO(Long codigo, String nomeRegiao, Integer populacao, Double energiaRenovavel) {
        this.codigo = codigo;
        this.nomeRegiao = nomeRegiao;
        this.populacao = populacao;
        this.energiaRenovavel = energiaRenovavel;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public @NotBlank String getNomeRegiao() {
        return nomeRegiao;
    }

    public void setNomeRegiao(@NotBlank String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

    public @Min(0) Integer getPopulacao() {
        return populacao;
    }

    public void setPopulacao(@Min(0) Integer populacao) {
        this.populacao = populacao;
    }

    public @NotNull @PositiveOrZero Double getEnergiaRenovavel() {
        return energiaRenovavel;
    }

    public void setEnergiaRenovavel(@NotNull @PositiveOrZero Double energiaRenovavel) {
        this.energiaRenovavel = energiaRenovavel;
    }
}
