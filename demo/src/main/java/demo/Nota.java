package demo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NOTA")
public class Nota implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_NOTA")
	private Long id;
	
	@Column(name = "NOME_NOTA")
	private String nomeNota;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeNota() {
		return nomeNota;
	}

	public void setNomeNota(String nomeNota) {
		this.nomeNota = nomeNota;
	}
}
