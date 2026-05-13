package com.unibe.productos.dto;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "categorias")
public interface CategoriaFeignApi {
    @GetMapping("/api/categorias")
    List<CategoriaDto> findAll();

    @GetMapping("/api/categorias/{id}")
    CategoriaDto findById(@PathVariable("id") Long id);
}
