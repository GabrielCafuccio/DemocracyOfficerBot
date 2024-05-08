package application.apiClient.services;

import application.apiClient.ApiClient;
import application.apiClient.entities.NewsFeed;

import java.io.IOException;
import java.net.URISyntaxException;

public class UpdateFeeds extends Thread{

    @Override
    public void run(){
        while (true){
            try {
                ApiClient.updateNewsFeed();
            } catch (URISyntaxException | IOException | InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
