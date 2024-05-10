package application.apiClient.services;

import application.apiClient.entities.NewsFeed;
import application.apiClient.entities.NewsFeedItems;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class HttpNewsFeedRequest {

    public static void request() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.diveharder.com/v1/news_feed"))
                .GET()
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

        try {
            Gson gson = new Gson();
            Type classType = new TypeToken<List<NewsFeedItems>>() {
            }.getType();
            List<NewsFeedItems> newsFeedItems = gson.fromJson(getResponse.body(), classType);

            //Update NewsFeed if NewsFeed is empty or if the ID of the last item from NewsFeed.getNewsFeedItems() is different then the last one from the newly requested newsFeedItems.
            //And sets the published flag false
            if(NewsFeed.getNewsFeedItems().isEmpty() || NewsFeed.getNewsFeedItems().get(NewsFeed.getNewsFeedItems().size()-1).getId() != newsFeedItems.get(newsFeedItems.size()-1).getId()){
                NewsFeed.setNewsFeedItems(newsFeedItems);
                NewsFeed.setPublished(false);
            }
        } catch (Exception e){
            System.out.println("Exception at HttpNewsRequest: " + e);
        }
    }
}
