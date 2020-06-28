package br.com.casadocodigo.loja.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.models.RelatorioProduto;

@Controller
public class RelatorioProdutosController {

	@Autowired
	ProdutoDAO produtoDAO;
	
	@RequestMapping(value = "relatorio-produtos", method = RequestMethod.GET)
	@ResponseBody
	public RelatorioProduto relatorioDeProdutos(@DateTimeFormat(iso = ISO.DATE) Date data) {
		return new RelatorioProduto(produtoDAO.listar(data));
	}
	
}
