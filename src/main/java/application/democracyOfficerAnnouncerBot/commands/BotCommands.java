package application.democracyOfficerAnnouncerBot.commands;

import application.democracyOfficerAnnouncerBot.entities.SubscribedChannelsList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Objects;

public class BotCommands extends ListenerAdapter {
    private static SubscribedChannelsList subscribedChannelsList;

    public BotCommands(){
        String filepath = "cache/cacheSubbedChannels.json";
        Gson gson = new Gson();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            StringBuilder jsonStringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonStringBuilder.append(line);
            }
            String json = jsonStringBuilder.toString();

            Type classType = new TypeToken<SubscribedChannelsList>() {}.getType();
            subscribedChannelsList = gson.fromJson(json, classType);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No Json file found in cache. Starting with empty SubbedChannelsList.");
            subscribedChannelsList = new SubscribedChannelsList();
        }
    }

    public static SubscribedChannelsList getSubscribedChannelsList() {
        return subscribedChannelsList;
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        super.onSlashCommandInteraction(event);

        //TODO: May need to add some exception in case of invalid channel id provided
        if (event.getName().equals("subscribe-channel")) {
            if(!subscribedChannelsList.contains(event.getOption("canal").getAsString())) {
                subscribedChannelsList.addTextChannel(Objects.requireNonNull(event.getOption("canal")).getAsString());
                event.reply("Channel: " + event.getChannel().getName() + " subbed!").queue();
            } else {
                event.reply("Channel " + event.getOption("canal").getAsString() + " already subscribed.").queue();
            }
            subscribedChannelsList.saveAsJson(subscribedChannelsList);
        }

        if(event.getName().equals("unsubscribe-channel")) {
            if(subscribedChannelsList.contains(event.getOption("canal").getAsString())){
                subscribedChannelsList.removeTextChannel(event.getOption("canal").getAsString());
                event.reply("Channel: " + event.getChannel().getName() + " unsubbed!").queue();
            } else {
                event.reply("Channel " + event.getOption("canal").getAsString() + " is not on subbed list.").queue();
            }
            subscribedChannelsList.saveAsJson(subscribedChannelsList);
        }

        if(event.getName().equals("show-subbed-channels")){
            if(subscribedChannelsList.isEmpty()){
                event.reply("Channel List is empty.").queue();
            } else {
                event.reply("List of channels: " + subscribedChannelsList.getChannels().toString()).queue();
            }
        }
    }
}
