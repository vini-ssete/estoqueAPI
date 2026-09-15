/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.gm.estoqueSAEP.domain.service;

//import br.eti.gm.estoqueSAEP.api.dto.RelatorioEstoqueDTO;
//import br.eti.gm.estoqueSAEP.domain.repository.MovimentoRepository;
import br.eti.gm.estoqueSAEP.domain.repository.ProdutoRepository;
//import java.time.LocalDateTime;
//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author digma
 */
@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
//    @Autowired
//    private MovimentoRepository movimentoRepository;
    
    public void excluir(Long produtoID) {
        produtoRepository.deleteById(produtoID);
    }
    
//    public List<RelatorioEstoqueDTO> gerarRelatorio(LocalDateTime dataInicio, LocalDateTime dataFim) {
//        
//        List<Object[]> resultado = movimentoRepository.findRelatorioEstoqueNative(dataInicio, dataFim);
//        List<RelatorioEstoqueDTO> relatorio = new ArrayList<>();
//    }
}
