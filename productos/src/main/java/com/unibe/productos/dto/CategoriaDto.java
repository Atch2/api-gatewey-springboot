package com.unibe.productos.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaDto {
    private Long id;
    private String observation;
    private LocalDate createDate;
    private Integer valueCategory;
    private String slug;
    private Integer priority;
    private String email;
}