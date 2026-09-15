/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.gm.estoqueSAEP.api.controller;

import br.eti.gm.estoqueSAEP.api.dto.RelatorioEstoqueDTO;
import br.eti.gm.estoqueSAEP.domain.model.Movimento;
import br.eti.gm.estoqueSAEP.domain.model.Movimento;
import br.eti.gm.estoqueSAEP.domain.repository.MovimentoRepository;
import br.eti.gm.estoqueSAEP.domain.service.MovimentoService;
import br.eti.gm.estoqueSAEP.domain.service.MovimentoService;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digma
 */
@RestController
public class MovimentoController {
    @Autowired
    private MovimentoRepository movimentoRepository;
    
    @Autowired
    private MovimentoService movimentoService;
    
    @GetMapping ("/movimentos")
    public List<Movimento> listas() {
        return movimentoRepository.findAll();
    }
    
    @GetMapping ("/movimentos/saidas")
    public List<Movimento> saidas() {
        return movimentoRepository.buscarSaidasOrdenadas();
    }
    
//    @GetMapping("/categorias/totais")
//    public List<RelatorioEstoqueDTO> buscarTotais() {
//        // Aqui o Java aceita o DTO sem reclamar, 
//        // porque não estamos usando o motor automático do Data REST
//        return movimentoRepository.findRelatorioEstoqueViaJPQL();
//    }
    
    @GetMapping ("/movimentos/{movimentoID}")
    public ResponseEntity<Movimento> buscar(@PathVariable Long movimentoID) {
        
        Optional<Movimento> movimento = movimentoRepository.findById(movimentoID);
        
        if (movimento.isPresent()) {
            return ResponseEntity.ok(movimento.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping ("/movimentos/criar")
    @ResponseStatus (HttpStatus.CREATED)
    public ResponseEntity<Movimento> salvar(@Valid @RequestBody Movimento movimento) {
        return ResponseEntity.ok(movimentoService.criarMovimento(movimento));
    }
}
