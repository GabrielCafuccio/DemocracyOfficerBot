import application.apiClient.ApiClient;
import application.democracyOfficerAnnouncerBot.DemocracyOfficerAnnouncerBot;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException {
//        System.out.println("Starting bot...");
//
//        DemocracyOfficerAnnouncerBot democracyOfficerAnnouncerBot = new DemocracyOfficerAnnouncerBot();
//        democracyOfficerAnnouncerBot.start();
//
//        System.out.println("Bot started!");
        ApiClient apiClient = new ApiClient();
        apiClient.requestTest();
    }
}
