package com.example.tmkweb.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="cidades")
public class Cidade {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id_cidade;
	
	@NotNull
	@Digits(integer = 2, fraction=0)
	private long ddd;
	
	@NotNull
	@Size (min=3, max=30)
	private String nome_cidade;	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id_cidade ^ (id_cidade >>> 32));
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
		Cidade other = (Cidade) obj;
		if (id_cidade != other.id_cidade)
			return false;
		return true;
	}

	public long getId_cidade() {
		return id_cidade;
	}

	public void setId_cidade(long id_cidade) {
		this.id_cidade = id_cidade;
	}

	public long getDdd() {
		return ddd;
	}

	public void setDdd(long ddd) {
		this.ddd = ddd;
	}

	public String getNome_cidade() {
		return nome_cidade;
	}

	public void setNome_cidade(String nome_cidade) {
		this.nome_cidade = nome_cidade;
	}
	
	
	

	
}
