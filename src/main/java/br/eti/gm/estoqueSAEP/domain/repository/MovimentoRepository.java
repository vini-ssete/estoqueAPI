 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.eti.gm.estoqueSAEP.domain.repository;

import br.eti.gm.estoqueSAEP.api.dto.CategoriaValorTotalDTO;
import br.eti.gm.estoqueSAEP.api.dto.RelatorioEstoqueDTO;
import br.eti.gm.estoqueSAEP.domain.model.Categoria;
import br.eti.gm.estoqueSAEP.domain.model.Movimento;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author digma
 */
public interface MovimentoRepository extends JpaRepository<Movimento, Long>{
    
    //List<Movimento> findByQtdLessThanOrderByDataMovtoDesc(BigDecimal valor);
    
//    @Query("SELECT NEW br.eti.gm.estoqueSAEP.domain.model.Movimento(m.id, m.id_produto, m.qtd, m.dataMovto)) " +
//           "FROM Movimento m" +
//           "WHERE m.qtd < 0" +
//           "ORDER BY m.dataMovto DESC")
//    List<Movimento> findMovimentoSaidaDataDesc();
    
    @Query("SELECT m FROM Movimento m WHERE m.qtd < 0 ORDER BY m.dataMovto DESC")
List<Movimento> buscarSaidasOrdenadas();
    

    @Query("SELECT new br.eti.gm.estoqueSAEP.api.dto.RelatorioEstoqueDTO("
    + "p.id, p.nome, p.valorUnitario, "
    + "SUM(CASE WHEN m.qtd > 0 THEN m.qtd ELSE 0.0 END),"
    + "SUM(CASE WHEN m.qtd < 0 THEN -m.qtd ELSE 0.0 END))"
    + "FROM Movimento m JOIN m.produto p "
    + "WHERE (:dataInicio IS NULL OR m.dataMovto >= :dataInicio)"
    + "AND (:dataFim IS NULL OR m.dataMovto <= :dataFim) "
    + "GROUP BY p.id "
    + "ORDER BY  p.nome")
List<RelatorioEstoqueDTO> findRelatorioEstoqueViaJPQL(@Param("dataInicio") LocalDateTime dataInicio, 
        @Param("dataFim") LocalDateTime dataFim);
}
