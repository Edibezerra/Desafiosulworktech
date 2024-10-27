package com.Desafiosulworktech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.Desafiosulworktech.model.Colaborador;
import com.Desafiosulworktech.repository.ColaboradorRepository;

import jakarta.transaction.Transactional;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository colaboradorRepository;

	@Transactional
	public Colaborador salvar(Colaborador colaborador) {
		// Validações aqui
		try {
			// Validações adicionais (caso necessário)
			return colaboradorRepository.save(colaborador);

		} catch (DataAccessException e) {
			// Tratamento de exceções de banco de dados
			throw new RuntimeException("Erro ao salvar o colaborador no banco de dados.", e);

		} catch (IllegalArgumentException e) {
			// Tratamento de exceção para parâmetros inválidos
			throw new RuntimeException("O colaborador fornecido é inválido.", e);
		}
	}

	public List<Colaborador> listarTodos() {
		return colaboradorRepository.findAll();
	}

	@Transactional
	public Colaborador atualizar(Long id, Colaborador colaboradorAtualizado) {
		Colaborador colaboradorExistente = colaboradorRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Colaborador não encontrado"));

		// Atualiza os campos desejados
		colaboradorExistente.setNome(colaboradorAtualizado.getNome());
		colaboradorExistente.setCpf(colaboradorAtualizado.getCpf());

		return colaboradorRepository.save(colaboradorExistente);
	}

	@Transactional
	public void excluir(Long id) {
		if (!colaboradorRepository.existsById(id)) {
			throw new RuntimeException("Colaborador não encontrado");
		}
		colaboradorRepository.deleteById(id);
	}
}
