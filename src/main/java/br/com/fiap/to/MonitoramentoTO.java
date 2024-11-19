package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class MonitoramentoTO {
    private Long codigo;
    @NotBlank private String nomeDaFonte;
    @NotBlank private String status;
    @NotNull @PositiveOrZero private Double energiaGerada; //em kwh
    @NotBlank private String observacao;

    public MonitoramentoTO() {}

    public MonitoramentoTO(Long codigo, String nomeDaFonte, String status, Double energiaGerada, String observacao) {
        this.codigo = codigo;
        this.nomeDaFonte = nomeDaFonte;
        this.status = status;
        this.energiaGerada = energiaGerada;
        this.observacao = observacao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public @NotBlank String getNomeDaFonte() {
        return nomeDaFonte;
    }

    public void setNomeDaFonte(@NotBlank String nomeDaFonte) {
        this.nomeDaFonte = nomeDaFonte;
    }

    public @NotBlank String getStatus() {
        return status;
    }

    public void setStatus(@NotBlank String status) {
        this.status = status;
    }

    public @NotNull @PositiveOrZero Double getEnergiaGerada() {
        return energiaGerada;
    }

    public void setEnergiaGerada(@NotNull @PositiveOrZero Double energiaGerada) {
        this.energiaGerada = energiaGerada;
    }

    public @NotBlank String getObservacao() {
        return observacao;
    }

    public void setObservacao(@NotBlank String observacao) {
        this.observacao = observacao;
    }
}
