package com.unibe.categorias.categoria;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin
@RequiredArgsConstructor
public class CategoriaController {
    private final CaterogiaService caterogiaService ;

    @GetMapping()
    public List<Categoria> findAll(){return caterogiaService.findAll();}
    @GetMapping("{id}")
    public Categoria getCategoriaById(@PathVariable Long id) {
        return caterogiaService.findById(id);
    }
    @PostMapping()
    public Categoria addCategoria(@RequestBody Categoria categoria) {
        return caterogiaService.save(categoria);
    }
}
