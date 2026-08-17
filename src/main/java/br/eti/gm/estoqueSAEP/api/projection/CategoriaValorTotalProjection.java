package br.eti.gm.estoqueSAEP.api.projection;

import java.math.BigDecimal;

/**
 * Interface(Projection) utilizado como auxiliar de retorno da Query JPQL 
 * no cálculo de valor total de produtos por categoria.
 * 
 * 
 * @author KGe
 */

public interface CategoriaValorTotalProjection {
    String getCategoria();
    BigDecimal getValorTotal();
}

