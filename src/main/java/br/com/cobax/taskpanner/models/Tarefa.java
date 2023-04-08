package br.com.cobax.taskpanner.models;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.cobax.taskpanner.models.enums.TarefaStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Tarefa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String descricao;

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private TarefaCategoria categoria;

	private ZonedDateTime dataEntrega;

	private Boolean visivel;

	@Enumerated(EnumType.STRING)
	private TarefaStatus status;

	@ManyToOne
	private Usuario usuario;

	public Tarefa() {
	}

	public Tarefa(Long id, String descricao, TarefaCategoria categoria, ZonedDateTime dataEntrega, Boolean visivel,
			TarefaStatus status) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.categoria = categoria;
		this.dataEntrega = dataEntrega;
		this.visivel = visivel;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TarefaCategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(TarefaCategoria categoria) {
		this.categoria = categoria;
	}

	public ZonedDateTime getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(ZonedDateTime dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Boolean getVisivel() {
		return visivel;
	}

	public void setVisivel(Boolean visivel) {
		this.visivel = visivel;
	}

	public TarefaStatus getStatus() {
		return status;
	}

	public void setStatus(TarefaStatus status) {
		this.status = status;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		return Objects.equals(id, other.id);
	}

}