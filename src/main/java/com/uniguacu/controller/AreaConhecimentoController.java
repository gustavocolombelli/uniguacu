package com.uniguacu.controller;

import com.uniguacu.model.AreaConhecimento;
import com.uniguacu.repository.AreaConhecimentoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/areas-conhecimento")
@RequiredArgsConstructor
@Tag(name = "Área do Conhecimento", description = "Gerenciamento das áreas de estudo")
public class AreaConhecimentoController {

    private final AreaConhecimentoRepository repository;

    @GetMapping
    @Operation(summary = "Lista todas as áreas", description = "Retorna um array com todas as áreas cadastradas")
    public List<AreaConhecimento> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca por ID")
    public ResponseEntity<AreaConhecimento> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Cria uma nova área")
    public ResponseEntity<AreaConhecimento> criar(@Valid @RequestBody AreaConhecimento area) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(area));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma área existente")
    public ResponseEntity<AreaConhecimento> atualizar(@PathVariable Long id, @Valid @RequestBody AreaConhecimento areaDetails) {
        return repository.findById(id)
                .map(area -> {
                    area.setNomeArea(areaDetails.getNomeArea());
                    return ResponseEntity.ok(repository.save(area));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove uma área")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}