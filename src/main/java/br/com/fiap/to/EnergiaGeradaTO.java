package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public class EnergiaGeradaTO {
    private Long codigo;
    @NotNull @PositiveOrZero private Double quantidade; //em kwh
    @NotBlank private String tipoFonte;
    @PastOrPresent private LocalDate dataGeracao;

    public EnergiaGeradaTO() {}

    public EnergiaGeradaTO(Long codigo, Double quantidade, String tipoFonte, LocalDate dataGeracao) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.tipoFonte = tipoFonte;
        this.dataGeracao = dataGeracao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public @NotNull @PositiveOrZero Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(@NotNull @PositiveOrZero Double quantidade) {
        this.quantidade = quantidade;
    }

    public @NotBlank String getTipoFonte() {
        return tipoFonte;
    }

    public void setTipoFonte(@NotBlank String tipoFonte) {
        this.tipoFonte = tipoFonte;
    }

    public @PastOrPresent LocalDate getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(@PastOrPresent LocalDate dataGeracao) {
        this.dataGeracao = dataGeracao;
    }
}
