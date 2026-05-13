package com.unibe.productos.producto;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.unibe.productos.dto.CategoriaDto;
import com.unibe.productos.dto.CategoriaFeignApi;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoService productoService;
    private final CategoriaFeignApi categoriaFeignApi;

    @GetMapping()
    public List<Producto> findAll() {
        return productoService.findAll();
    }

    @GetMapping("{id}")
    public Producto getProductoById(@PathVariable Long id) {
        return productoService.findById(id);
    }

    @PostMapping()
    public Producto addProducto(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @GetMapping("categorias")
    public List<CategoriaDto> getCategorias() {
        return categoriaFeignApi.findAll();
    }
}
