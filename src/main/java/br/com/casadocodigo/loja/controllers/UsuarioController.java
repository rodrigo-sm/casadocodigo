package br.com.casadocodigo.loja.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.FormUsuario;
import br.com.casadocodigo.loja.validation.UsuarioValidation;

@Transactional
@Controller()
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new UsuarioValidation(usuarioDAO));
	}

	@RequestMapping("/form")
	public String form(FormUsuario formUsuario) {
		return "usuarios/form";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String gravar(@Valid FormUsuario formUsuario, BindingResult result, RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) 
			return form(formUsuario);
		
		usuarioDAO.gravar(formUsuario.getUsuario());
		
		redirectAttributes.addAttribute("usuarioCadastrado", true);
		
		return "redirect:/usuarios";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView lista() {
		ModelAndView modelAndView = new ModelAndView("usuarios/lista");
		
		modelAndView.addObject("usuarios", usuarioDAO.listar());
		
		return modelAndView;
	}
	
}
