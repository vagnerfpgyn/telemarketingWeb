package com.example.tmkweb.api.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "telefones")
public class Telefone {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_telefone;
	
	@NotNull
	@Size(min=8, max=9)
	private String telefone;
	
	@ManyToOne
	@JoinColumn(name = "id_cidade")
	@NotNull
	private Cidade cidade;
	
	@ManyToOne
	@JoinColumn(name = "id_referencia")
	private Referencia referencia;
	
	@NotNull
	private char tipo;
	
	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	@NotNull
	private LocalDate data_cadastro;

	
	public long getId_telefone() {
		return id_telefone;
	}

	public void setId_telefone(long id_telefone) {
		this.id_telefone = id_telefone;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Referencia getReferencia() {
		return referencia;
	}

	public void setReferencia(Referencia referencia) {
		this.referencia = referencia;
	}

	public LocalDate getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(LocalDate data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id_telefone ^ (id_telefone >>> 32));
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
		Telefone other = (Telefone) obj;
		if (id_telefone != other.id_telefone)
			return false;
		return true;
	}
	
	

	
	
}
