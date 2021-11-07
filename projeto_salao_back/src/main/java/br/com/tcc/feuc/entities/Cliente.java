package br.com.tcc.feuc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	@Column(length = 100)
	private String nome;
	@Column()
	private String cpf;
	@Column
	private String email;
	@Column
	private String bairro;
	@Column
	private String dataNascimento;
	@Column
	private String Telefone;
	@Column
	private String Sexo;

}
