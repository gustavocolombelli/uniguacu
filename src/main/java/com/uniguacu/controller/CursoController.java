package com.uniguacu.controller;

import com.uniguacu.model.Curso;
import com.uniguacu.service.CursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Define que esta classe é um controlador onde cada método retorna um objeto serializado (JSON) direto no corpo da resposta.
@RequestMapping("/api/cursos") // Define a URL base para todos os endpoints deste controller.
@RequiredArgsConstructor // Injeção de dependência: Cria automaticamente um construtor para o campo 'final' service.
@Tag(name = "Cursos", description = "Gerenciamento de cursos da instituição")
public class CursoController {

    private final CursoService service;

    @GetMapping
    @Operation(summary = "Lista todos os cursos", description = "Retorna a lista completa de cursos com suas respectivas áreas")
    public List<Curso> listar() {
        // Retorna a lista de todos os cursos. O Spring converte automaticamente para um JSON Array [{}, {}].
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca curso por ID", description = "Retorna os detalhes de um curso específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Curso encontrado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Curso não encontrado")
    })
    public ResponseEntity<Curso> buscar(@PathVariable Long id) {
        // O service retorna um Optional. 
        // .map transforma o resultado em 200 OK se presente.
        // .orElse executa caso o Optional esteja vazio.
        // .notFound().build() cria uma resposta 404 sem corpo.
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Cadastra um novo curso")
    public ResponseEntity<Curso> criar(@Valid @RequestBody Curso curso) {
        // @Valid: Dispara a validação do Bean Validation (ex: @NotBlank no Model).
        // @RequestBody: Indica que o JSON enviado pelo Postman deve ser convertido no objeto 'curso'.
        // status(HttpStatus.CREATED): Retorna o código HTTP 201 (indicando que algo foi criado com sucesso).
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(curso));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza dados de um curso")
    public ResponseEntity<Curso> atualizar(@PathVariable Long id, @Valid @RequestBody Curso curso) {
        // O service tenta atualizar e retorna um Optional.
        // Se o curso com o ID informado existia, o Optional terá o novo objeto -> map retorna 200 OK.
        // Se o ID não existia, o Optional é vazio -> orElse retorna 404 Not Found.
        return service.atualizar(id, curso)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um curso do sistema")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        // Aqui usamos um operador ternário:
        // Se o service.deletar retornar true (encontrou e deletou), retorna 204 No Content (sucesso sem corpo).
        // Se retornar false (não encontrou o ID), retorna 404 Not Found.
        return service.deletar(id) 
                ? ResponseEntity.noContent().build() 
                : ResponseEntity.notFound().build();
    }
}