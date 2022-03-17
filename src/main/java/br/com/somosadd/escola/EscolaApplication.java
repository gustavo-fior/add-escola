package br.com.somosadd.escola;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.somosadd.escola.model.Endereco;
import br.com.somosadd.escola.model.Escola;
import br.com.somosadd.escola.model.Turma;
import br.com.somosadd.escola.repository.EscolaRepository;
import br.com.somosadd.escola.repository.TurmaRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class EscolaApplication {

	@Autowired
	private EscolaRepository escolaRepository;

	@Autowired
	private TurmaRepository turmaRepository;

	public static void main(String[] args) {
		SpringApplication.run(EscolaApplication.class, args);
	}

	@PostConstruct
	public void init() {

		Escola escola = createEscola();
		List<Turma> turmas = createTurma(escola);

		escola.getTurmas().addAll(turmas);

		escolaRepository.save(escola);

	}

	public Escola createEscola() {

		Escola escola = new Escola();
		escola.setEndereco(new Endereco("Avenida Governador 342", "Sala 1", "Centro", "Curitiba", "PR"));
		escola.setTurmas(new ArrayList<>());
		escola.setNome("Positivo");

		escolaRepository.save(escola);

		return escola;

	}

	public List<Turma> createTurma(Escola escola) {

		Turma turma = new Turma();
		turma.setEscola(escola);
		turma.setAlunos(new ArrayList<>());
		turma.setCapacidade(200);
		turma.setNome("Biologia");

		Turma turma2 = new Turma();
		turma.setEscola(escola);
		turma.setAlunos(new ArrayList<>());
		turma.setCapacidade(50);
		turma.setNome("Matemática");

		Turma turma3 = new Turma();
		turma.setEscola(escola);
		turma.setAlunos(new ArrayList<>());
		turma.setCapacidade(80);
		turma.setNome("Português");

		Turma turma4 = new Turma();
		turma.setEscola(escola);
		turma.setAlunos(new ArrayList<>());
		turma.setCapacidade(120);
		turma.setNome("Artes");

		List<Turma> turmas = Arrays.asList(turma, turma2, turma3, turma4);

		turmaRepository.saveAll(turmas);

		return turmas;

	}

}
