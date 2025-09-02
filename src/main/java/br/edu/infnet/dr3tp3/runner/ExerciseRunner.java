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

        System.out.println("\nExercício 2: GET de entidade específica");
        exercicio2();

        System.out.println("\nExercício 3: GET de entidade inexistente");
        exercicio3();

        System.out.println("\nExercício 4: GET com parâmetros na URL");
        exercicio4();

        System.out.println("\nExercício 5: POST criando uma nova entidade");
        exercicio5();
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

    private void exercicio2() {
        try {
            System.out.println("Processando exercício 2...");

            for (int id = 1; id <= 8; id++) {
                System.out.println("\n--- Entidade ID: " + id + " ---");
                String url = entitiesApiUrl + "/" + id;
                httpClientService.sendGetRequest(url);
            }

            System.out.println("\nExercício 2 concluído!");
        } catch (Exception e) {
            System.err.println("Erro no exercício 2: " + e.getMessage());
        }
    }

    private void exercicio3() {
        try {
            System.out.println("Processando exercício 3...");
            String url = entitiesApiUrl + "/13";
            httpClientService.sendGetRequest(url);
            System.out.println("\nExercício 3 concluído!");
        } catch (Exception e) {
            System.err.println("Erro no exercício 3: " + e.getMessage());
        }
    }

    private void exercicio4() {
        try {
            System.out.println("Processando exercício 4...");
            String url = entitiesApiUrl + "?categoria=teste&limite=5";
            System.out.println("URL final: " + url);
            httpClientService.sendGetRequest(url);
            System.out.println("\nExercício 4 concluído!");
        } catch (Exception e) {
            System.err.println("Erro no exercício 4: " + e.getMessage());
        }
    }

    private void exercicio5() {
        try {
            System.out.println("Processando exercício 5...");
            String jsonData = "{\"name\": \"aluno\"}";
            System.out.println("Body Request: " + jsonData);
            httpClientService.sendPostRequest(entitiesApiUrl, jsonData);
            System.out.println("Exercício 5 concluído!");
        } catch (Exception e) {
            System.err.println("Erro no exercício 5: " + e.getMessage());
        }
    }
}
