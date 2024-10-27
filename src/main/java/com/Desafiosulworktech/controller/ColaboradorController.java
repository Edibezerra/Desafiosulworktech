package com.Desafiosulworktech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Desafiosulworktech.model.Colaborador;
import com.Desafiosulworktech.service.ColaboradorService;

@CrossOrigin
@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

	@Autowired
	private ColaboradorService colaboradorService;

	@PostMapping
	public ResponseEntity<Colaborador> criarColaborador(@RequestBody Colaborador colaborador) {
		return ResponseEntity.ok(colaboradorService.salvar(colaborador));
	}

	@GetMapping
	public List<Colaborador> listarColaboradores() {
		return colaboradorService.listarTodos();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Colaborador> atualizarColaborador(@PathVariable Long id,
			@RequestBody Colaborador colaboradorAtualizado) {
		Colaborador colaborador = colaboradorService.atualizar(id, colaboradorAtualizado);
		return ResponseEntity.ok(colaborador);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirColaborador(@PathVariable Long id) {
		colaboradorService.excluir(id);
		return ResponseEntity.noContent().build();

	}
}
