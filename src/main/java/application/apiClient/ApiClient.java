package application.apiClient;

import application.apiClient.entities.MajorOrder;
import application.apiClient.entities.NewsFeed;
import application.apiClient.services.HttpMajorOrderRequest;
import application.apiClient.services.HttpNewsFeedRequest;
import application.apiClient.services.UpdateFeeds;

import java.io.IOException;
import java.net.URISyntaxException;


//Endpoints at https://api.diveharder.com/docs#/
public final class ApiClient {
    private static final NewsFeed newsFeed = new NewsFeed();
    private static MajorOrder majorOrder = new MajorOrder();
    private static final UpdateFeeds updateFeeds = new UpdateFeeds();

    public void startUpdateFeeds(){
        updateFeeds.start();
    }

    public static void updateNewsFeed() throws URISyntaxException, IOException, InterruptedException {
//        System.out.println("Updating newsFeed");
        HttpNewsFeedRequest.request();
    }

    public static void updateMajorOrder() throws URISyntaxException, IOException, InterruptedException {
        System.out.println("Updating Major Order");
        MajorOrder auxMajorOrder = HttpMajorOrderRequest.request();

        if(majorOrder == null || majorOrder.getId32() != auxMajorOrder.getId32()){
            majorOrder = auxMajorOrder;
            majorOrder.setPublished(false);
        }
    }

    public static NewsFeed getNewsFeed() {
        return newsFeed;
    }

    public static MajorOrder getMajorOrder() {
        return majorOrder;
    }
}
