package orm.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue
	private Long id;
	private String nomeDoUsuario;
	private String hashDaSenha;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeDoUsuario() {
		return nomeDoUsuario;
	}
	public void setNomeDoUsuario(String nomeDoUsuario) {
		this.nomeDoUsuario = nomeDoUsuario;
	}
	public String getHashDaSenha() {
		return hashDaSenha;
	}
	public void setHashDaSenha(String hashDaSenha) {
		this.hashDaSenha = hashDaSenha;
	}
	

	

	
}