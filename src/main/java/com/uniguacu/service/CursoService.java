package com.uniguacu.service;

import com.uniguacu.model.Curso;
import com.uniguacu.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository repository;

    public List<Curso> listarTodos() {
        return repository.findAll();
    }

    public Optional<Curso> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Curso salvar(Curso curso) {
        // Aqui poderiam ser adicionadas validações de negócio extras
        return repository.save(curso);
    }

    @Transactional
    public Optional<Curso> atualizar(Long id, Curso cursoDetails) {
        return repository.findById(id).map(curso -> {
            curso.setNome(cursoDetails.getNome());
            curso.setAreaConhecimento(cursoDetails.getAreaConhecimento());
            return repository.save(curso);
        });
    }

    @Transactional
    public boolean deletar(Long id) {
        return repository.findById(id).map(curso -> {
            repository.delete(curso);
            return true;
        }).orElse(false);
    }
}