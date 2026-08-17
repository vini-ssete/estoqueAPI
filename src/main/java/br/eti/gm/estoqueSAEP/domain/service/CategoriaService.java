/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.gm.estoqueSAEP.domain.service;

import br.eti.gm.estoqueSAEP.api.dto.CategoriaValorTotalDTO;
import br.eti.gm.estoqueSAEP.api.projection.CategoriaValorTotalProjection;
import br.eti.gm.estoqueSAEP.domain.repository.CategoriaRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author digma
 */

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    public void excluir(Long categoriaID) {
        categoriaRepository.deleteById(categoriaID);
    }
    
    public List<CategoriaValorTotalDTO> valorTotalPorCategoriaViaSqlNativo() {
        List<CategoriaValorTotalProjection> resultados = 
                categoriaRepository.calcularValorTotalPorCategoriaViaSqlNativo();
        
        return resultados.stream()
                .map(proj -> new CategoriaValorTotalDTO(proj.getCategoria(), proj.getValorTotal()))
                .collect(Collectors.toList());
    }
}
