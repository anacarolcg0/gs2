package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class RedeInteligenteTO {
    private Long codigo;
    @NotBlank private String nome;
    @NotNull @PositiveOrZero private Double eficienciaDistribuicao; //em porcentagem
    @NotNull @PositiveOrZero private Double perdaEnergia; //em kwh

    public RedeInteligenteTO() {}

    public RedeInteligenteTO(Long codigo, String nome, Double eficienciaDistribuicao, Double perdaEnergia) {
        this.codigo = codigo;
        this.nome = nome;
        this.eficienciaDistribuicao = eficienciaDistribuicao;
        this.perdaEnergia = perdaEnergia;
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

    public @NotNull @PositiveOrZero Double getEficienciaDistribuicao() {
        return eficienciaDistribuicao;
    }

    public void setEficienciaDistribuicao(@NotNull @PositiveOrZero Double eficienciaDistribuicao) {
        this.eficienciaDistribuicao = eficienciaDistribuicao;
    }

    public @NotNull @PositiveOrZero Double getPerdaEnergia() {
        return perdaEnergia;
    }

    public void setPerdaEnergia(@NotNull @PositiveOrZero Double perdaEnergia) {
        this.perdaEnergia = perdaEnergia;
    }
}
