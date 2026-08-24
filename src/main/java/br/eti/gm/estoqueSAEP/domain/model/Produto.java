/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.gm.estoqueSAEP.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

/**
 *
 * @author digma
 */
@Entity
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Size (max = 120)
    private String nome;
    
    @ManyToOne
    @JoinColumn(name = "id_categoria") 
    private Categoria categoria;

    private BigDecimal saldo;
    
    @Column(name = "valor_unitario")
    private BigDecimal valorUnitario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Produto() {
    }

    public Produto(Long id, String nome, Categoria categoria, BigDecimal saldo, BigDecimal valorUnitario) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.saldo = saldo;
        this.valorUnitario = valorUnitario;
    }

    
    
    
}
    

/*  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(mappedBy = "ordemServico") // Lado inverso do ManyToOne
    private List<Comentario> comentarios = new ArrayList<>();
    
    @ManyToOne
    private Cliente cliente;
    
    private String descricao;
    private BigDecimal preco;
    
    @Enumerated(EnumType.STRING)
    private StatusOrdemServico status;
    
    private LocalDateTime dataAbertura;
    private LocalDateTime dataFinalizacao; */