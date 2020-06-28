package br.com.casadocodigo.loja.validation;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.FormUsuario;
import br.com.casadocodigo.loja.models.Usuario;

public class UsuarioValidation implements Validator{
	
	private UsuarioDAO usuarioDAO;

	public UsuarioValidation(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public UsuarioValidation() {
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return FormUsuario.class.isAssignableFrom(clazz) || Usuario.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		validaCamposObrigatorios(errors);

		FormUsuario form = (FormUsuario) target;

		validaSenha(errors, form);
		
		validaEmail(errors, form);
	}

	private void validaCamposObrigatorios(Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "usuario.nome", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "usuario.email", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "usuario.senha", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "senhaRepetida", "field.required");
	}

	private void validaEmail(Errors errors, FormUsuario form) {
		
		if(verificaSeEmailExiste(form))
			errors.rejectValue("usuario.email", "field.email.cadastrado");
	}

	private boolean verificaSeEmailExiste(FormUsuario form) {
		boolean existe = false;
			
		if(!form.getEmail().isEmpty()) {
			try {
				usuarioDAO.loadUserByUsername(form.getEmail());
				
				existe = true;
			}
			catch(UsernameNotFoundException e) {
			}
		}
		
		return existe;
	}

	private void validaSenha(Errors errors, FormUsuario form) {
		if(form.getSenha().length() < 5) 
			errors.rejectValue("usuario.senha", "field.senha.curta");
		
		if(form.getSenhaRepetida().length() < 5) 
			errors.rejectValue("senhaRepetida", "field.senha.curta");
		
		if(!form.getSenha().equals(form.getSenhaRepetida()))
			errors.rejectValue("senhaRepetida", "field.senha.repetida.diferente");
	}
	
}


