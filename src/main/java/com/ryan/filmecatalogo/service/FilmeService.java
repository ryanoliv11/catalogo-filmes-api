package com.ryan.filmecatalogo.service;

import com.ryan.filmecatalogo.dto.FilmeSalvarDTO;
import com.ryan.filmecatalogo.dto.FilmeTmdbDTO;
import com.ryan.filmecatalogo.model.Filme;
import com.ryan.filmecatalogo.repository.FilmeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public List<Filme> listarTodos() {
        return filmeRepository.findAll();
    }

    public Filme salvar(Filme filme) {
        return filmeRepository.save(filme);
    }

    public void deletar(Long id) {
        filmeRepository.deleteById(id);
    }

    public Filme salvarDoTmdb(FilmeSalvarDTO dto) {
        Filme filme = new Filme();
        filme.setTitulo(dto.getTitulo());
        filme.setSinopse(dto.getSinopse());
        filme.setAnoLancamento(dto.getAnoLancamento());
        return filmeRepository.save(filme);
    }
}