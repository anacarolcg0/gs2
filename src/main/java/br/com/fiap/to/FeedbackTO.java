package br.com.fiap.to;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class FeedbackTO {
    private Long codigo;
    @NotBlank private String comentario;
    @Min(0) @Max(5) private Integer nota;
    @PastOrPresent private LocalDate dataFeedback;

    public FeedbackTO() {}

    public FeedbackTO(Long codigo, String comentario, Integer nota, LocalDate dataFeedback) {
        this.codigo = codigo;
        this.comentario = comentario;
        this.nota = nota;
        this.dataFeedback = dataFeedback;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public @NotBlank String getComentario() {
        return comentario;
    }

    public void setComentario(@NotBlank String comentario) {
        this.comentario = comentario;
    }

    public @Min(0) @Max(5) Integer getNota() {
        return nota;
    }

    public void setNota(@Min(0) @Max(5) Integer nota) {
        this.nota = nota;
    }

    public @PastOrPresent LocalDate getDataFeedback() {
        return dataFeedback;
    }

    public void setDataFeedback(@PastOrPresent LocalDate dataFeedback) {
        this.dataFeedback = dataFeedback;
    }
}
