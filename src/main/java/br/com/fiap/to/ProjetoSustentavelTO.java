package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class ProjetoSustentavelTO {
    private Long codigo;
    @NotBlank private String descricao;
    @NotNull @PositiveOrZero private Double custo; //em R$
    @NotBlank private String status;

    public ProjetoSustentavelTO() {}

    public ProjetoSustentavelTO(Long codigo, String descricao, Double custo, String status) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.custo = custo;
        this.status = status;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public @NotBlank String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotBlank String descricao) {
        this.descricao = descricao;
    }

    public @NotNull @PositiveOrZero Double getCusto() {
        return custo;
    }

    public void setCusto(@NotNull @PositiveOrZero Double custo) {
        this.custo = custo;
    }

    public @NotBlank String getStatus() {
        return status;
    }

    public void setStatus(@NotBlank String status) {
        this.status = status;
    }
}
