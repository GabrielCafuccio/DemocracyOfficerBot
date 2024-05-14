package application.apiClient.services;

import application.apiClient.ApiClient;
import application.apiClient.entities.NewsFeed;

import java.io.IOException;
import java.net.URISyntaxException;

public class UpdateFeeds extends Thread{
    int i = 0;
    @Override
    public void run(){
        while (true){
            try {
                System.out.println(i + ": Updating NewsFeed & MajorOrder");
                ApiClient.updateNewsFeed();
                ApiClient.updateMajorOrder();
            } catch (URISyntaxException | IOException | InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1800000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }
}
