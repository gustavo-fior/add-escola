package br.com.somosadd.escola;

import java.util.ArrayList;

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
		Turma turma = createTurma(escola);

		escola.getTurmas().add(turma);

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

	public Turma createTurma(Escola escola) {

		Turma turma = new Turma();
		turma.setEscola(escola);
		turma.setAlunos(new ArrayList<>());
		turma.setCapacidade(200);
		turma.setNome("Biologia");

		turmaRepository.save(turma);

		return turma;

	}

}
