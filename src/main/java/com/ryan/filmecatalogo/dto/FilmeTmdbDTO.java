package com.ryan.filmecatalogo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmeTmdbDTO {

    private String titulo;
    private String sinopse;
    private Double notaMedia;
    private String posterUrl = "https://placehold.co/500x750?text=Sem+Poster";
    private Integer anoLancamento;

    @JsonProperty("title")
    public void setTitulo(String titulo) { this.titulo = titulo; }

    @JsonProperty("overview")
    public void setSinopse(String sinopse) { this.sinopse = sinopse; }

    @JsonProperty("vote_average")
    public void setNotaMedia(Double notaMedia) { this.notaMedia = notaMedia; }

    @JsonProperty("poster_path")
    public void setPosterUrl(String posterPath) {
        if (posterPath != null) {
            this.posterUrl = "https://image.tmdb.org/t/p/w500" + posterPath;
        }
    }

    @JsonProperty("release_date")
    public void setAnoLancamento(String releaseDate) {
        if (releaseDate != null && !releaseDate.isEmpty()) {
            this.anoLancamento = Integer.parseInt(releaseDate.substring(0, 4));
        }
    }

    @JsonProperty("titulo")
    public String getTitulo() { return titulo; }

    @JsonProperty("sinopse")
    public String getSinopse() { return sinopse; }

    @JsonProperty("notaMedia")
    public Double getNotaMedia() { return notaMedia; }

    @JsonProperty("posterUrl")
    public String getPosterUrl() { return posterUrl; }

    @JsonProperty("anoLancamento")
    public Integer getAnoLancamento() { return anoLancamento; }
}