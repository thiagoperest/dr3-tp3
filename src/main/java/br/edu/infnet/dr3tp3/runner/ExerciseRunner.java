package br.edu.infnet.dr3tp3.runner;
import br.edu.infnet.dr3tp3.service.HttpClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ExerciseRunner implements CommandLineRunner {

    @Autowired
    private HttpClientService httpClientService;

    @Value("${external.api.entities.url}")
    private String entitiesApiUrl;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Exercício 1: GET simples de todas as entidades");
        exercicio1();
    }

    private void exercicio1() {
        try {
            System.out.println("Processando exercício 1...");
            httpClientService.sendGetRequest(entitiesApiUrl);
            System.out.println("Exercício 1 concluído!");
        } catch (Exception e) {
            System.err.println("Erro no exercício 1: " + e.getMessage());
        }
    }
}
