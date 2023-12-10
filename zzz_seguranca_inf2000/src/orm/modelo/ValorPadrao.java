package orm.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "valorpadrao")
public class ValorPadrao {
	@Id
	@GeneratedValue
	private Long id;
	private String tipoDeExame;
	private String valorMinimo;
	private String valorMaximo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipoDeExame() {
		return tipoDeExame;
	}
	public void setTipoDeExame(String tipoDeExame) {
		this.tipoDeExame = tipoDeExame;
	}
	public String getValorMinimo() {
		return valorMinimo;
	}
	public void setValorMinimo(String valorMinimo) {
		this.valorMinimo = valorMinimo;
	}
	public String getValorMaximo() {
		return valorMaximo;
	}
	public void setValorMaximo(String valorMaximo) {
		this.valorMaximo = valorMaximo;
	}
	
}