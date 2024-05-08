package application.democracyOfficerAnnouncerBot.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BotCommands extends ListenerAdapter {
    private static final List<String> SubscribedChannels = new ArrayList<>();

    public static List<String> getSubscribedChannels() {
        return SubscribedChannels;
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        super.onSlashCommandInteraction(event);

        if (event.getName().equals("write-to-channel")){
             SubscribedChannels.add(Objects.requireNonNull(event.getOption("canal")).getAsString());
             event.reply("Done").queue();
        }
    }
}
