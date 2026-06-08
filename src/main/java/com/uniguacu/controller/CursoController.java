package com.uniguacu.controller;

import com.uniguacu.model.Curso;
import com.uniguacu.service.CursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@RequiredArgsConstructor
@Tag(name = "Cursos", description = "Gerenciamento de cursos da instituição")
public class CursoController {

    private final CursoService service;

    @GetMapping
    @Operation(summary = "Lista todos os cursos", description = "Retorna a lista completa de cursos com suas respectivas áreas")
    public List<Curso> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca curso por ID")
    public ResponseEntity<Curso> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Cadastra um novo curso")
    public ResponseEntity<Curso> criar(@Valid @RequestBody Curso curso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(curso));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza dados de um curso")
    public ResponseEntity<Curso> atualizar(@PathVariable Long id, @Valid @RequestBody Curso curso) {
        return service.atualizar(id, curso)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um curso do sistema")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return service.deletar(id) 
                ? ResponseEntity.noContent().build() 
                : ResponseEntity.notFound().build();
    }
}