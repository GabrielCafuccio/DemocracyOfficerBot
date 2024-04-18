package application.apiClient;

import application.apiClient.utils.MajorOrder;
import application.apiClient.utils.NewsFeed;
import application.apiClient.utils.NewsFeedItems;
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

public class ApiClient {
    public void requestTest() throws IOException, InterruptedException, URISyntaxException {
        String majorOrderJson = "        {           \"id32\": 3541580460,                \"progress\": [            866701315    ],            \"expiresIn\": 493960,                \"setting\": {            \"type\": 4,                    \"overrideTitle\": \"MAJOR ORDER\",                    \"overrideBrief\": \"The Automaton invasion has slowed, thanks to valiant defense efforts. We must take this chance to refill our E-710 reserves in order to stage a counter-offensive.\",                    \"taskDescription\": \"Kill 2,000,000,000 Terminids.\",                    \"tasks\": [            {                \"type\": 3,                    \"values\": [                2,                        1,                        2000000000,                        0,                        0,                        0,                        0,                        0,                        0,                        0          ],                \"valueTypes\": [                1,                        2,                        3,                        4,                        6,                        5,                        8,                        9,                        11,                        12          ]            }      ],            \"reward\": {                \"type\": 1,                        \"id32\": 897894480,                        \"amount\": 45            },            \"flags\": 0        }        }        ";
        MajorOrder majorOrderExample = MajorOrder.fromJson(majorOrderJson);
//        System.out.println(majorOrderExample.getSetting().getOverrideBrief());

        String newsFeedJson = """          
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
                },
                ]                
                """;
        List<NewsFeedItems> newsFeedItems = NewsFeedItems.fromJson(newsFeedJson);
        System.out.println(newsFeedItems.get(0).getMessage());

//        HttpRequest getRequest = HttpRequest.newBuilder()
//                .uri(new URI("https://api.diveharder.com/v1/news_feed"))
//                .GET()
//                .build();
//
//        HttpClient httpClient = HttpClient.newHttpClient();
//        HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
//
//        Gson gson = new Gson();
//        Type listType = new TypeToken<List<NewsFeed>>(){}.getType();
//        List<NewsFeed> newsFeedList = gson.fromJson(getResponse.body(), listType);
//
//
//        for (NewsFeed items : newsFeedList){
//            System.out.println(items.getMessage() + "\n--------------------------------------------------------------------------------------\n");
//        }

    }

}
