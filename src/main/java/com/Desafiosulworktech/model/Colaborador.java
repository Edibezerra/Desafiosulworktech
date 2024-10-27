package com.Desafiosulworktech.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Colaborador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nome;

	@NotBlank
	@Size(min = 11, max = 11)
	private String cpf;

	@NotBlank
	private String opcaoCafe;

	private LocalDate dataCafe;

	public Colaborador(Long id, @NotBlank String nome, @NotBlank @Size(min = 11, max = 11) String cpf,
			@NotBlank String opcaoCafe, LocalDate dataCafe) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.opcaoCafe = opcaoCafe;
		this.dataCafe = dataCafe;
	}

	public Colaborador() {

	}

	@Override
	public String toString() {
		return "Colaborador [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", opcaoCafe=" + opcaoCafe + ", dataCafe="
				+ dataCafe + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getOpcaoCafe() {
		return opcaoCafe;
	}

	public void setOpcaoCafe(String opcaoCafe) {
		this.opcaoCafe = opcaoCafe;
	}

	public LocalDate getDataCafe() {
		return dataCafe;
	}

	public void setDataCafe(LocalDate dataCafe) {
		this.dataCafe = dataCafe;
	}

}
