package application.apiClient.services;

import application.apiClient.entities.MajorOrder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpMajorOrderRequest {

    public static MajorOrder request() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.diveharder.com/v1/major_order"))
                .GET()
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        Type classType = new TypeToken<MajorOrder>(){}.getType();

        return gson.fromJson(getResponse.body(), classType);
    }
}
