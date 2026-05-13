package com.unibe.productos.producto;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductoService {
    private final ProductoRepository productoRepository;

    public List<Producto> findAll(){
        return productoRepository.findAll();
    }

    public Producto findById(Long id){
        return productoRepository.findById(id).orElseThrow(()-> new RuntimeException("Producto no encontrado " + id));
    }

    public Producto save(Producto producto){
        return productoRepository.save(producto);
    }
}
