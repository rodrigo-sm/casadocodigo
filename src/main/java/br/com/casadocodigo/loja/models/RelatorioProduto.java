package br.com.casadocodigo.loja.models;

import java.util.Date;
import java.util.List;

public class RelatorioProduto {

	private Date dataGeracao;
	private int quantidade;
	private List<Produto> produtos;

	public RelatorioProduto(List<Produto> produtos) {
		dataGeracao = new Date();
		quantidade = produtos.size();
		this.produtos = produtos;
	}

	public Date getDataGeracao() {
		return dataGeracao;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

}
