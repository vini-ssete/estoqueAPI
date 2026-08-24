/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.gm.estoqueSAEP.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author digma
 */
@Entity
public class Movimento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_produto") 
    private Produto produto;
    
    private BigDecimal qtd;
    
    @NotNull
    @JsonProperty("data_movto") 
    private LocalDateTime dataMovto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getQtd() {
        return qtd;
    }

    public void setQtd(BigDecimal qtd) {
        this.qtd = qtd;
    }

    public LocalDateTime getData_movto() {
        return dataMovto;
    }

    public void setData_movto(LocalDateTime data_movto) {
        this.dataMovto = data_movto;
    }

    public Movimento(Long id, Produto produto, BigDecimal qtd, LocalDateTime data_movto) {
        this.id = id;
        this.produto = produto;
        this.qtd = qtd;
        this.dataMovto = data_movto;
    }

    public Movimento() {
    }
    
    
}
