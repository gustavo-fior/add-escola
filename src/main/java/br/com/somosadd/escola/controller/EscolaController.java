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

import br.com.somosadd.escola.controller.dto.EscolaDTO;
import br.com.somosadd.escola.controller.form.EscolaForm;
import br.com.somosadd.escola.model.Escola;
import br.com.somosadd.escola.repository.EscolaRepository;

@RestController
@RequestMapping("/escola")
public class EscolaController {

	@Autowired
	private EscolaRepository escolaRepository;

	@PostMapping
	public ResponseEntity<EscolaDTO> createEscola(@RequestBody EscolaForm form, UriComponentsBuilder uriBuilder) {

		Escola escola = form.converteParaEscola();

		escolaRepository.save(escola);

		URI uri = uriBuilder.path("/escola/{id}").buildAndExpand(escola.getId()).toUri();

		return ResponseEntity.created(uri).body(new EscolaDTO(escola));

	}

	@GetMapping("/{id}")
	public ResponseEntity<EscolaDTO> getEscolaById(@PathVariable Integer id) {

		Optional<Escola> escolaOpt = escolaRepository.findById(id);
		
		if(escolaOpt.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(new EscolaDTO(escolaOpt.get()));

	}

	@GetMapping
	public ResponseEntity<List<EscolaDTO>> getAllEscolas() {

		List<EscolaDTO> escolasDTO = new ArrayList<>();
		List<Escola> escolas = escolaRepository.findAll();

		escolas.forEach(escola -> {
			escolasDTO.add(new EscolaDTO(escola));
		});

		return ResponseEntity.ok(escolasDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<EscolaDTO> updateEscola(@PathVariable Integer id, @RequestBody EscolaForm form) {

		Escola escola = form.converteParaEscola();

		escolaRepository.save(escola);

		return ResponseEntity.ok().build();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEscola(@PathVariable Integer id) {

		Escola escola = escolaRepository.findById(id).get();

		escolaRepository.delete(escola);

		return ResponseEntity.ok().build();

	}

}
