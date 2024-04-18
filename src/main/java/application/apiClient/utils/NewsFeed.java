package application.apiClient.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class NewsFeed {
    List<NewsFeedItems> newsFeedItems;

    public List<NewsFeedItems> getNewsFeedItems() {
        return newsFeedItems;
    }

    public void setNewsFeedItems(List<NewsFeedItems> newsFeedItems) {
        this.newsFeedItems = newsFeedItems;
    }

    public static NewsFeed fromJson(String json){
        Gson gson = new Gson();
        Type classType = new TypeToken<NewsFeed>(){}.getType();
        NewsFeed newsFeed = gson.fromJson(json, classType);

        return newsFeed;
    }
}