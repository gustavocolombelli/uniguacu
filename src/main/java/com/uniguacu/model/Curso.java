package com.uniguacu.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "curso")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do curso é obrigatório")
    @Column(nullable = false)
    private String nome;

    /**
     * Relacionamento Muitos-para-Um: Muitos cursos pertencem a uma Área do Conhecimento.
     * O campo no banco será 'area_conhecimento_id'.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "area_conhecimento_id", nullable = false)
    @NotNull(message = "A área do conhecimento é obrigatória")
    private AreaConhecimento areaConhecimento;
}