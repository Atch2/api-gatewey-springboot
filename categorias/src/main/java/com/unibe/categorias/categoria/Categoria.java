package com.unibe.categorias.categoria;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String observation;

    @PastOrPresent
    private LocalDate createDate;

    @Positive
    private Integer valueCategory;

    @Pattern(regexp = "^[a-z]+$")
    private String slug;

    @Min(value = 1)
    @Max(value = 100)
    private Integer priority;

    @Column(unique = true)
    private String email;
}