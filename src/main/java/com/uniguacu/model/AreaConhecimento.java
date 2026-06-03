package com.uniguacu.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "area_conhecimento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AreaConhecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da área é obrigatório")
    @Column(name = "nome_area", nullable = false)
    private String nomeArea;
}