package com.ryan.filmecatalogo.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.ryan.filmecatalogo.dto.FilmeSalvarDTO;
import com.ryan.filmecatalogo.dto.FilmeTmdbDTO;
import com.ryan.filmecatalogo.model.Filme;
import com.ryan.filmecatalogo.service.FilmeService;
import com.ryan.filmecatalogo.service.TmdbService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;


@Tag(name = "Filmes", description = "Gerenciamento do catalogo de filmes")
@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService filmeService;
    private final TmdbService tmdbService;

    public FilmeController(FilmeService filmeService, TmdbService tmdbService) {
        this.filmeService = filmeService;
        this.tmdbService = tmdbService;
    }


    @Operation(summary = "Lista todos os filmes salvos")
    @GetMapping
    public List<Filme> listarTodos() {
        return filmeService.listarTodos();
    }

    @Operation(summary = "Salva um filme manualmente")
    @PostMapping
    public Filme salvar(@RequestBody Filme filme) {
        return filmeService.salvar(filme);
    }

    @Operation(summary = "Deleta um filme pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        filmeService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Busca filmes no TMDB pelo titulo")
    @GetMapping("/buscar")
    public List<FilmeTmdbDTO> buscarNoTmdb(@RequestParam String titulo) {
        return tmdbService.buscarFilmes(titulo);
    }


    @Operation(summary = "Salva um filme a partir dos dados do TMDB")
    @PostMapping("/salvar-do-tmdb")
    public Filme salvarDoTmdb(@Valid @RequestBody FilmeSalvarDTO dto) {
        return filmeService.salvarDoTmdb(dto);
    }
}

