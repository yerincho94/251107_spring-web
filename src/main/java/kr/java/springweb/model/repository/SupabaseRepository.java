package kr.java.springweb.model.repository;

import io.github.cdimascio.dotenv.Dotenv;
import kr.java.springweb.model.entity.Food;
import org.springframework.stereotype.Repository;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Repository
public class SupabaseRepository implements FoodRepository{
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String API_URL;
    private final String API_KEY;

    public SupabaseRepository() {
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
        this.API_URL = dotenv.get("SUPABASE_API_URL");
        this.API_KEY = dotenv.get("SUPABASE_API_KEY");
    }

    @Override
    public List<Food> findAll() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("%s/rest/v1/FOOD?select=*".formatted(API_URL)))
                .header("api-key", API_KEY)
                .header("Authorization", "Bearer %s".formatted(API_KEY))
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(),new TypeReference<>(){});
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void save(Food food) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("%s/rest/v1/FOOD?select=*".formatted(API_URL)))
                .header("api-key", API_KEY)
                .header("Authorization", "Bearer %s".formatted(API_KEY))
                .header("Content-Type", "application/json")
                .header("Prefer", "return=minimal")
                .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(food)))
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
