package br.com.tcc.feuc.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
@Data
@Entity
@Table(name="Administrador")
public class Administrador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idAdministrador;
	@Column(length = 150, nullable = false)
	private String nome;
	@Column(length = 100, nullable = false, unique = true)
	private String email;
	@Column(length = 50, nullable = false)
	private String senha;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dataCriacao;

}
