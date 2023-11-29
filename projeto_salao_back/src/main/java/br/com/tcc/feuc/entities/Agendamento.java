package br.com.tcc.feuc.entities;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Agendamento")
public class Agendamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAgendamento;
	
	private LocalDate data;
	
	private String hora;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Profissional profissional;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Servico servico;
}
