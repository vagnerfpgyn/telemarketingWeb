package com.example.tmkweb.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="status" )
public class Status {
	
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		private Long id_status ;
		
		@NotNull
		@Size(min=3, max=20)
		private String nome_status;
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id_status == null) ? 0 : id_status.hashCode());
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
			Status other = (Status) obj;
			if (id_status == null) {
				if (other.id_status != null)
					return false;
			} else if (!id_status.equals(other.id_status))
				return false;
			return true;
		}
		public Long getId_status() {
			return id_status;
		}
		public void setId_status(Long id_status) {
			this.id_status = id_status;
		}
		public String getNome_status() {
			return nome_status;
		}
		public void setNome_status(String nome_status) {
			this.nome_status = nome_status;
		}
		
		
		
}
