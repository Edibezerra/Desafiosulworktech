package com.Desafiosulworktech.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Desafiosulworktech.model.Colaborador;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

	List<Colaborador> findByDataCafe(LocalDate dataCafe);

	boolean existsByCpf(String cpf);

	boolean existsByOpcaoCafeAndDataCafe(String opcaoCafe, LocalDate dataCafe);

}
