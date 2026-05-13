package com.unibe.categorias.categoria;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CaterogiaService {
    private final CategoriaRepository categoriaRepository;

    //Get all
    public List<Categoria> findByCategoria(String categoria){
        return categoriaRepository.findAll();
    }

    //Get by id
    public Categoria findById(Long id){
        return categoriaRepository.findById(id).orElseThrow(()-> new RuntimeException("Categoria no encontrada" + id));
    }

    public Categoria save(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }
}
