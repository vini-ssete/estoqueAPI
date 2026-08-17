/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.gm.estoqueSAEP.api.controller;

import br.eti.gm.estoqueSAEP.api.dto.CategoriaValorTotalDTO;
import br.eti.gm.estoqueSAEP.domain.model.Categoria;
import br.eti.gm.estoqueSAEP.domain.repository.CategoriaRepository;
import br.eti.gm.estoqueSAEP.domain.service.CategoriaService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digma
 */
@RestController
public class CategoriaController {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping ("/categorias")
    public List<Categoria> listas() {
        return categoriaRepository.findAll();
    }
    
    @GetMapping ("/categorias/{categoriaID}")
    public ResponseEntity<Categoria> buscar(@PathVariable Long categoriaID) {
        
        Optional<Categoria> categoria = categoriaRepository.findById(categoriaID);
        
        if (categoria.isPresent()) {
            return ResponseEntity.ok(categoria.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/categorias/totais")
    public List<CategoriaValorTotalDTO> buscarTotais() {
        // Aqui o Java aceita o DTO sem reclamar, 
        // porque não estamos usando o motor automático do Data REST
        return categoriaRepository.calcularValorTotalPorCategoriaViaJPQL();
    }
    
    @PostMapping ("/categorias")
    @ResponseStatus (HttpStatus.CREATED)
    public Categoria adicionar(@Valid @RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
    
    @PutMapping ("/categorias/{categoriaID}")
    public ResponseEntity<Categoria> atualizar (@Valid @PathVariable Long categoriaID,
                                                @RequestBody Categoria categoria) {
        if (!categoriaRepository.existsById(categoriaID)) {
            return ResponseEntity.notFound() . build();
        }
        categoria.setId(categoriaID);
        categoria = categoriaRepository.save(categoria);
        return ResponseEntity.ok(categoria);
    }
    
    @DeleteMapping ("/categorias/{categoriaID}")
    public ResponseEntity<Void> excluir(@PathVariable Long categoriaID) {
        if (!categoriaRepository.existsById(categoriaID)) {
            return ResponseEntity.notFound().build();
        }
        categoriaService.excluir(categoriaID); 
        return ResponseEntity.noContent().build();
    }
    
    
}

