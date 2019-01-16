package com.example.tmkweb.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="cadastros")
public class Cadastro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_cadastro;
	
	private String empresa;
	
	@Email
	private String email1;
	
	@Email
	private String email2;
	
	@ManyToOne
	@JoinColumn(name="id_celular1")
	private Telefone telefonec1;
	
	@ManyToOne
	@JoinColumn(name="id_celular2")
	private Telefone telefonec2;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="id_telefone1")
	private Telefone telefonef1;
	
	@ManyToOne
	@JoinColumn(name="id_telefone2")
	private Telefone telefonef2;	
	
	@ManyToOne
	@JoinColumn(name="id_telefone3")
	private Telefone telefonef3;
	
	@ManyToOne
	@JoinColumn(name="id_telefone4")
	private Telefone telefonef4;
	
	private String observacao;

	public long getId_cadastro() {
		return id_cadastro;
	}

	public void setId_cadastro(long id_cadastro) {
		this.id_cadastro = id_cadastro;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public Telefone getTelefonec1() {
		return telefonec1;
	}

	public void setTelefonec1(Telefone telefonec1) {
		this.telefonec1 = telefonec1;
	}

	public Telefone getTelefonec2() {
		return telefonec2;
	}

	public void setTelefonec2(Telefone telefonec2) {
		this.telefonec2 = telefonec2;
	}

	public Telefone getTelefonef1() {
		return telefonef1;
	}

	public void setTelefonef1(Telefone telefonef1) {
		this.telefonef1 = telefonef1;
	}

	public Telefone getTelefonef2() {
		return telefonef2;
	}

	public void setTelefonef2(Telefone telefonef2) {
		this.telefonef2 = telefonef2;
	}

	public Telefone getTelefonef3() {
		return telefonef3;
	}

	public void setTelefonef3(Telefone telefonef3) {
		this.telefonef3 = telefonef3;
	}

	public Telefone getTelefonef4() {
		return telefonef4;
	}

	public void setTelefonef4(Telefone telefonef4) {
		this.telefonef4 = telefonef4;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id_cadastro ^ (id_cadastro >>> 32));
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
		Cadastro other = (Cadastro) obj;
		if (id_cadastro != other.id_cadastro)
			return false;
		return true;
	}
	
		

}
