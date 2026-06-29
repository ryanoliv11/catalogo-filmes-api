package com.ryan.filmecatalogo.dto;

import jakarta.validation.constraints.*;

public class FilmeSalvarDTO {

    @NotBlank(message = "Título é obrigatório")
    private String titulo;

    private String sinopse;

    @NotNull(message = "Ano de lançamento é obrigatório")
    private Integer anoLancamento;

    private String posterUrl;

    @DecimalMin(value = "0.0", message = "Nota mínima é 0")
    @DecimalMax(value = "10.0", message = "Nota máxima é 10")
    private Double notaMedia;

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getSinopse() { return sinopse; }
    public void setSinopse(String sinopse) { this.sinopse = sinopse; }

    public Integer getAnoLancamento() { return anoLancamento; }
    public void setAnoLancamento(Integer anoLancamento) { this.anoLancamento = anoLancamento; }

    public String getPosterUrl() { return posterUrl; }
    public void setPosterUrl(String posterUrl) { this.posterUrl = posterUrl; }

    public Double getNotaMedia() { return notaMedia; }
    public void setNotaMedia(Double notaMedia) { this.notaMedia = notaMedia; }
}