package br.com.cobax.taskpanner.models;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Tarefa implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String descricao;

	private CategoriaTarefa categoria;

	private LocalDateTime dataEntrega;

	private Boolean visivel;

	public Tarefa() {
	}

	public Tarefa(Long id, String descricao, CategoriaTarefa categoria, LocalDateTime dataEntrega, Boolean visivel) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.categoria = categoria;
		this.dataEntrega = dataEntrega;
		this.visivel = visivel;
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

	public CategoriaTarefa getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaTarefa categoria) {
		this.categoria = categoria;
	}

	public LocalDateTime getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDateTime dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Boolean getVisivel() {
		return visivel;
	}

	public void setVisivel(Boolean visivel) {
		this.visivel = visivel;
	}

}