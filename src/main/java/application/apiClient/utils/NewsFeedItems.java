package application.apiClient.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class NewsFeedItems {
    private int id;
    private long published;
    private int type;
    private List<Integer> tagIds;
    private String message;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPublished() {
        return this.published;
    }

    public void setPublished(long published) {
        this.published = published;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Integer> getTagIds() {
        return this.tagIds;
    }

    public void setTagIds(List<Integer> tagIds) {
        this.tagIds = tagIds;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static List<NewsFeedItems> fromJson(String json){
        Gson gson = new Gson();
        Type classType = new TypeToken<List<NewsFeedItems>>(){}.getType();
        List<NewsFeedItems> newsFeedItems = gson.fromJson(json, classType);

        return newsFeedItems;
    }
}
