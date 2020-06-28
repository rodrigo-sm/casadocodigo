package br.com.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.Usuario;

@Repository
public class UsuarioDAO implements UserDetailsService{

	@PersistenceContext
	private EntityManager manager;

	public Usuario loadUserByUsername(String email) {
		List<Usuario> usuarios = manager.createQuery("select u from Usuario u where email = :email", Usuario.class)
				.setParameter("email", email)
				.getResultList();
		
		if(usuarios.isEmpty()) {
			throw new UsernameNotFoundException("Usuario " + email + " não foi encontrado");
		}
		
		return usuarios.get(0);
	}

	public void gravar(Usuario usuario) {
		manager.persist(usuario);
	}

	public List<Usuario> listar() {
		return manager
				.createQuery("select u from Usuario u", Usuario.class)
				.getResultList();
	}
	
	public Usuario find(String email) {
        return manager
        		.createQuery("select distinct(u) from Usuario u join fetch u.roles roles where u.email = :email", Usuario.class)
        		.setParameter("email", email)
        		.getSingleResult();
	}
	
	public void alterar(Usuario usuario) {
		Usuario usuarioBanco = find(usuario.getEmail());
		
		usuarioBanco.setRoles(usuario.getRoles());
		
	}

}