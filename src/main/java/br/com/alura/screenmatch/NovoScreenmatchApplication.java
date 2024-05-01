package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NovoScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(NovoScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		//pega os dados da api com o endereco abaixo e atribui a um json
		var json = consumoApi.obterDados(
				"https://www.omdbapi.com/?t=gilmore+girls&apikey=fac2f87d");
		System.out.println(json);

		//usa o conversor da classe integrada com a interface genérica e atribui ao
		//objeto DadosSerie
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);

		//deve apresentar os dados confole o filtro feito na classe DadosSerie
		System.out.println(dados);
	}
}
