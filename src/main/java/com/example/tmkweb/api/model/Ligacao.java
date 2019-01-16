package com.example.tmkweb.api.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="ligacoes")
public class Ligacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_ligacao;
	
	@Column(name="data_hora")
	private LocalDateTime dataHora;
	
	@NotNull
	@Size(min=5, max=600)
	private String resumo;
	
	@ManyToOne
	@JoinColumn(name="id_cadastro")
	private Cadastro cadastro;
	
	@ManyToOne
	@JoinColumn(name="id_produto")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public long getId_ligacao() {
		return id_ligacao;
	}

	public void setId_ligacao(long id_ligacao) {
		this.id_ligacao = id_ligacao;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id_ligacao ^ (id_ligacao >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ligacao other = (Ligacao) obj;
		if (id_ligacao != other.id_ligacao)
			return false;
		return true;
	}
	
	

}
