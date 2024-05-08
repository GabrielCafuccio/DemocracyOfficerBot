import application.apiClient.ApiClient;
import application.democracyOfficerAnnouncerBot.DemocracyOfficerAnnouncerBot;
import application.democracyOfficerAnnouncerBot.services.BroadCastMessages;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException {
        System.out.println("Starting bot...");

        DemocracyOfficerAnnouncerBot democracyOfficerAnnouncerBot = DemocracyOfficerAnnouncerBot.getInstance();
        democracyOfficerAnnouncerBot.start();

        System.out.println("Starting Broadcasting Thread");
        BroadCastMessages broadCastMessages = new BroadCastMessages();
        broadCastMessages.start();

        System.out.println("Bot started!");

        ApiClient apiClient = new ApiClient();
        apiClient.startUpdateFeeds();
    }
}
