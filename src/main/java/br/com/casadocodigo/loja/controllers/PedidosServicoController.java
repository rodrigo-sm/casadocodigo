package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.models.Pedido;

@Controller
public class PedidosServicoController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("pedidos")
	public ModelAndView pedidos() {
		ModelAndView modelAndView = new ModelAndView("pedidos");
		
		String uri = "https://book-payment.herokuapp.com/orders";
		ResponseEntity<Pedido[]> response = restTemplate.getForEntity(uri, Pedido[].class);
		
		modelAndView.addObject("pedidos", response.getBody());
		
		return modelAndView;
	}

}
