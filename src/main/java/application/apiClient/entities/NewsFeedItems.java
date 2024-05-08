package application.apiClient.entities;

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

    /*String newsFeedJson = """
                [
                {
                    "id": 2797,
                        "published": 2414563,
                        "type": 0,
                        "tagIds": [],
                    "message": "Terminid spores have engulfed Heeth and Angel's Venture, spawning hordes of Terminids that overwhelmed our colonial militias. Clearly, the bug hive instinct oriented their mindless expansion towards dishonoring the memory of those who fought to free these planets.\n\nYour fellow Helldivers paid for these lands with their lives. We cannot lose them now. Hold the planets until SEAF reinforcements arrive."
                },
                {
                    "id": 2798,
                        "published": 2499000,
                        "type": 0,
                        "tagIds": [],
                    "message": "The Advanced Liberation Tools Research Agency (ALTRA) has tested successful prototypes of a new combat asset. Helldivers are advised to review proper mechanical operation procedures in preparation for the incoming asset."
                }
                ]
                """;
*/