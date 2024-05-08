package application.apiClient.entities;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class NewsFeed {
    private static List<NewsFeedItems> newsFeedItems = new ArrayList<>();
    private static boolean isPublished = false;

    public static boolean isPublished() {
        return isPublished;
    }

    public static void setPublished(boolean published) {
        isPublished = published;
    }

    public static List<NewsFeedItems> getNewsFeedItems() {
        return newsFeedItems;
    }

    public static void setNewsFeedItems(List<NewsFeedItems> newsFeedItems) {
        NewsFeed.newsFeedItems = newsFeedItems;
    }

    public static NewsFeed fromJson(String json){
        Gson gson = new Gson();
        Type classType = new TypeToken<NewsFeed>(){}.getType();
        NewsFeed newsFeed = gson.fromJson(json, classType);

        return newsFeed;
    }
}