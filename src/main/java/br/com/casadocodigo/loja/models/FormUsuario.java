package br.com.casadocodigo.loja.models;

public class FormUsuario {

	private Usuario usuario;
	private String senhaRepetida;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getSenhaRepetida() {
		return senhaRepetida;
	}

	public void setSenhaRepetida(String senhaRepetida) {
		this.senhaRepetida = senhaRepetida;
	}
	
	public String getSenha() {
		return usuario.getSenha();
	}
	
	public String getEmail() {
		return usuario.getEmail();
	}

}
