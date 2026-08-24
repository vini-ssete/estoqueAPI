/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.gm.estoqueSAEP.domain.service;

import br.eti.gm.estoqueSAEP.domain.model.Movimento;
import br.eti.gm.estoqueSAEP.domain.model.Produto;
import br.eti.gm.estoqueSAEP.domain.repository.MovimentoRepository;
import br.eti.gm.estoqueSAEP.domain.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author digma
 */
@Service
public class MovimentoService {
    
    @Autowired
    private MovimentoRepository movimentoRepository;
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    public MovimentoService(MovimentoRepository movimentoRepository, ProdutoRepository produtoRepository) {
        this.movimentoRepository = movimentoRepository;
        this.produtoRepository = produtoRepository;

    }
    
    @Transactional
    public Movimento criarMovimento(Movimento movimento) {
        
        Produto produto = produtoRepository.findById(movimento.getProduto().getId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        
        
        BigDecimal novoSaldo = produto.getSaldo().add(movimento.getQtd());
        produto.setSaldo(novoSaldo);
        
        produtoRepository.save(produto);
        
        return movimentoRepository.save(movimento);
                
    }
    
}
