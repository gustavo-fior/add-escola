package br.com.somosadd.escola.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.somosadd.escola.controller.dto.AlunoDTO;
import br.com.somosadd.escola.controller.form.AlunoForm;
import br.com.somosadd.escola.model.Aluno;
import br.com.somosadd.escola.repository.AlunoRepository;
import br.com.somosadd.escola.repository.TurmaRepository;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	private TurmaRepository turmaRepository;

	@Autowired
	private AlunoRepository alunoRepository;

	@PostMapping
	public ResponseEntity<AlunoDTO> createAluno(@RequestBody AlunoForm form, UriComponentsBuilder uriBuilder) {
		
		Aluno aluno = form.converteParaAluno(turmaRepository);
		
		alunoRepository.save(aluno);

		aluno.getTurma().getAlunos().add(aluno);
		turmaRepository.save(aluno.getTurma());

		URI uri = uriBuilder.path("/aluno/{id}").buildAndExpand(aluno.getId()).toUri();

		return ResponseEntity.created(uri).body(new AlunoDTO(aluno));

	}

	@GetMapping("/{id}")
	public ResponseEntity<AlunoDTO> getAlunoById(@PathVariable Integer id) {

		Optional<Aluno> alunoOpt = alunoRepository.findById(id);
		
		if(alunoOpt.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(new AlunoDTO(alunoOpt.get()));

	}

	@GetMapping
	public ResponseEntity<List<AlunoDTO>> getAllAlunos() {

		List<AlunoDTO> alunosDTO = new ArrayList<>();
		List<Aluno> alunos = alunoRepository.findAll();

		alunos.forEach(aluno -> {
			alunosDTO.add(new AlunoDTO(aluno));
		});

		return ResponseEntity.ok(alunosDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<AlunoDTO> updateAluno(@PathVariable Integer id, @RequestBody AlunoForm form) {

		Aluno aluno = form.converteParaAluno(turmaRepository);

		alunoRepository.save(aluno);

		return ResponseEntity.ok().build();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAluno(@PathVariable Integer id) {
		
		Aluno aluno = alunoRepository.findById(id).get();
		
		aluno.getTurma().getAlunos().remove(aluno);
		turmaRepository.save(aluno.getTurma());
		
		alunoRepository.delete(aluno);

		
		return ResponseEntity.ok().build();

	}

}
