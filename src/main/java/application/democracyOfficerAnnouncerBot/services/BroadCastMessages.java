package application.democracyOfficerAnnouncerBot.services;

import application.apiClient.ApiClient;
import application.apiClient.entities.MajorOrder;
import application.apiClient.entities.NewsFeed;
import application.democracyOfficerAnnouncerBot.DemocracyOfficerAnnouncerBot;
import application.democracyOfficerAnnouncerBot.commands.BotCommands;
import net.dv8tion.jda.api.JDA;

import java.util.List;

public class BroadCastMessages extends Thread {

    @Override
    public void run() {
        DemocracyOfficerAnnouncerBot democracyOfficerAnnouncerBot = DemocracyOfficerAnnouncerBot.getInstance();
        JDA jda = DemocracyOfficerAnnouncerBot.getJda();

        while (true) {
            List<String> channelList = BotCommands.getSubscribedChannelsList().getChannels();
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //TODO: May need to add some exception handling in case of invalid channel id
            if (!NewsFeed.getNewsFeedItems().isEmpty() && !NewsFeed.isPublished()) {
                for (String channel : channelList) {
                    jda.getTextChannelById(channel).sendMessage(NewsFeed.getNewsFeedItems().get(NewsFeed.getNewsFeedItems().size() - 1).getMessage()).queue();
                }
                NewsFeed.setPublished(true);
            }

            if (ApiClient.getMajorOrder().getId32() != 0 && !MajorOrder.isPublished()) {
                String message = ApiClient.getMajorOrder().getSetting().getOverrideTitle() + "\n" + ApiClient.getMajorOrder().getSetting().getOverrideBrief() + "\n" + ApiClient.getMajorOrder().getSetting().getTaskDescription();
                for (String channel : channelList) {
                    jda.getTextChannelById(channel).sendMessage(message).queue();
                }
                MajorOrder.setPublished(true);
            }
        }
    }
}