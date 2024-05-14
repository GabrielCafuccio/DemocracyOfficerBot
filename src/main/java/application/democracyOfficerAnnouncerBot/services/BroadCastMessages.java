package application.democracyOfficerAnnouncerBot.services;

import application.apiClient.ApiClient;
import application.apiClient.entities.MajorOrder;
import application.apiClient.entities.NewsFeed;
import application.democracyOfficerAnnouncerBot.DemocracyOfficerAnnouncerBot;
import application.democracyOfficerAnnouncerBot.commands.BotCommands;
import net.dv8tion.jda.api.JDA;

public class BroadCastMessages extends Thread {

    @Override
    public void run() {
        DemocracyOfficerAnnouncerBot democracyOfficerAnnouncerBot = DemocracyOfficerAnnouncerBot.getInstance();
        JDA jda = DemocracyOfficerAnnouncerBot.getJda();

        while (true) {
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                if (!NewsFeed.getNewsFeedItems().isEmpty() && !NewsFeed.isPublished()) {
                    jda.getTextChannelById("1199717602872791050").sendMessage(NewsFeed.getNewsFeedItems().get(NewsFeed.getNewsFeedItems().size() - 1).getMessage()).queue();
                    NewsFeed.setPublished(true);
                }
                if(ApiClient.getMajorOrder().getId32() != 0 && !MajorOrder.isPublished()){
                    String message = ApiClient.getMajorOrder().getSetting().getOverrideTitle() + "\n" + ApiClient.getMajorOrder().getSetting().getOverrideBrief() + "\n" + ApiClient.getMajorOrder().getSetting().getTaskDescription();

                    jda.getTextChannelById("1199737879115612240").sendMessage(message).queue();
                    MajorOrder.setPublished(true);
                }


        }
    }
}