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

import br.com.somosadd.escola.controller.dto.TurmaDTO;
import br.com.somosadd.escola.controller.form.TurmaForm;
import br.com.somosadd.escola.model.Escola;
import br.com.somosadd.escola.model.Turma;
import br.com.somosadd.escola.repository.EscolaRepository;
import br.com.somosadd.escola.repository.TurmaRepository;

@RestController
@RequestMapping("turma")
public class TurmaController {

	@Autowired
	private EscolaRepository escolaRepository;

	@Autowired
	private TurmaRepository turmaRepository;

	@PostMapping
	public ResponseEntity<TurmaDTO> createTurma(@RequestBody TurmaForm form, UriComponentsBuilder uriBuilder) {

		Turma turma = form.converteParaTurma(escolaRepository);

		Escola escola = escolaRepository.findById(turma.getEscola().getId()).get();
		turmaRepository.save(turma);

		escola.getTurmas().add(turma);
		escolaRepository.save(escola);

		URI uri = uriBuilder.path("/turma/{id}").buildAndExpand(turma.getId()).toUri();

		return ResponseEntity.created(uri).body(new TurmaDTO(turma));

	}

	@GetMapping("/{id}")
	public ResponseEntity<TurmaDTO> getTurmaById(@PathVariable Integer id) {

		Optional<Turma> turmaOpt = turmaRepository.findById(id);

		if(turmaOpt.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(new TurmaDTO(turmaOpt.get()));
	}

	@GetMapping
	public ResponseEntity<List<TurmaDTO>> getAllTurmas() {

		List<TurmaDTO> turmasDTO = new ArrayList<>();
		List<Turma> turmas = turmaRepository.findAll();

		turmas.forEach(turma -> {
			turmasDTO.add(new TurmaDTO(turma));
		});

		return ResponseEntity.ok(turmasDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<TurmaDTO> updateTurma(@PathVariable Integer id, @RequestBody TurmaForm form) {

		Turma turma = form.converteParaTurma(escolaRepository);

		turmaRepository.save(turma);

		return ResponseEntity.ok().build();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTurma(@PathVariable Integer id) {

		Turma turma = turmaRepository.findById(id).get();

		turma.getEscola().getTurmas().remove(turma);
		escolaRepository.save(turma.getEscola());

		turmaRepository.delete(turma);

		return ResponseEntity.ok().build();

	}

}
