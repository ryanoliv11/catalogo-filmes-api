package com.ryan.filmecatalogo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ryan.filmecatalogo.dto.FilmeTmdbDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class TmdbService {

    @Value("${tmdb.api.key}")
    private String apiKey;

    @Value("${tmdb.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<FilmeTmdbDTO> buscarFilmes(String titulo) {
        String url = apiUrl + "/search/movie?api_key=" + apiKey + "&query=" + titulo + "&language=pt-BR";
        String json = restTemplate.getForObject(url, String.class);

        List<FilmeTmdbDTO> filmes = new ArrayList<>();

        try {
            JsonNode root = objectMapper.readTree(json);
            JsonNode results = root.get("results");

            for (JsonNode node : results) {
                FilmeTmdbDTO dto = objectMapper.treeToValue(node, FilmeTmdbDTO.class);
                filmes.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return filmes;
    }
}