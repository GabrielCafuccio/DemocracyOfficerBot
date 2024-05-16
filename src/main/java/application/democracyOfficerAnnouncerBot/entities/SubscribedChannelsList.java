package application.democracyOfficerAnnouncerBot.entities;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SubscribedChannelsList {
    private List<String> channels = new ArrayList<>();

    public void addTextChannel(String channel) {
        channels.add(channel);
    }

    public void removeTextChannel(String channel) {
        channels.remove(channel);
    }

    public boolean contains(String channel){
        return channels.contains(channel);
    }

    public boolean isEmpty(){
        return channels.isEmpty();
    }

    public List<String> getChannels() {
        return channels;
    }

    public void setChannels(List<String> channels) {
        this.channels = channels;
    }

    public void saveAsJson(SubscribedChannelsList subscribedChannelsList) {
        Gson gson = new Gson();
        String json = gson.toJson(subscribedChannelsList);

        try {
            System.out.println("Saving channels.");
            FileWriter fileWriter = new FileWriter("src/main/resources/cache/cacheSubbedChannels.json");
            fileWriter.write(json);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
