package br.com.ecommerce.produto.entity;

public class Produto {

    private Long idProduto;
    private String nomeProduto;
    private String descricaoProduto;
    private Double preco;
    private Boolean ativo;
    private Integer categoriaId;
    private Double peso;
    private Integer unidadeMedidaPesoId;
    private UnidadeMedidaPeso unidadeMedidaPeso;

    private Double altura;
    private Double largura;
    private Double profundidade;

    private Integer unidadeMedidaTamanhoId;
    private UnidadeMedidaTamanho unidadeMedidaTamanho;


    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getUnidadeMedidaPesoId() {
        return unidadeMedidaPesoId;
    }

    public void setUnidadeMedidaPesoId(Integer unidadeMedidaPesoId) {
        this.unidadeMedidaPesoId = unidadeMedidaPesoId;
    }

    public UnidadeMedidaPeso getUnidadeMedidaPeso() {
        return unidadeMedidaPeso;
    }

    public void setUnidadeMedidaPeso(UnidadeMedidaPeso unidadeMedidaPeso) {
        this.unidadeMedidaPeso = unidadeMedidaPeso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public Double getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(Double profundidade) {
        this.profundidade = profundidade;
    }

    public Integer getUnidadeMedidaTamanhoId() {
        return unidadeMedidaTamanhoId;
    }

    public void setUnidadeMedidaTamanhoId(Integer unidadeMedidaTamanhoId) {
        this.unidadeMedidaTamanhoId = unidadeMedidaTamanhoId;
    }

    public UnidadeMedidaTamanho getUnidadeMedidaTamanho() {
        return unidadeMedidaTamanho;
    }

    public void setUnidadeMedidaTamanho(UnidadeMedidaTamanho unidadeMedidaTamanho) {
        this.unidadeMedidaTamanho = unidadeMedidaTamanho;
    }
}