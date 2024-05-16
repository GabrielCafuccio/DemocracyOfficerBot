package application.democracyOfficerAnnouncerBot;

import application.democracyOfficerAnnouncerBot.commands.BotCommands;
import application.democracyOfficerAnnouncerBot.events.ReadyEventListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.OptionType;

public class DemocracyOfficerAnnouncerBot {
    public static DemocracyOfficerAnnouncerBot democracyOfficerAnnouncerBot = null;
    private static JDA jda;

    public static DemocracyOfficerAnnouncerBot getInstance(){
        if(democracyOfficerAnnouncerBot == null){
            democracyOfficerAnnouncerBot = new DemocracyOfficerAnnouncerBot();
        }
        return democracyOfficerAnnouncerBot;
    }

    public void start() throws InterruptedException {
        final String token = "BOT TOKEN GOES HERE";

        JDABuilder jdaBuilder = JDABuilder.createDefault(token);
        jda = jdaBuilder
                .addEventListeners(new ReadyEventListener(), new BotCommands())
                .build();

        jda.upsertCommand("subscribe-channel", "Choose a text channel to receive News")
                .addOption(OptionType.CHANNEL, "canal", "channel in which to receive news", true)
                .setGuildOnly(true)
                .queue();

        jda.upsertCommand("unsubscribe-channel", "Choose a text channel to unsubscribe")
                .addOption(OptionType.CHANNEL, "canal", "channel in which to unsubscribe", true)
                .setGuildOnly(true)
                .queue();

        jda.upsertCommand("show-subbed-channels", "Print all subbed channels")
                .setGuildOnly(true)
                .queue();

        jda.awaitReady();

    }

    public static JDA getJda(){
        return jda;
    }
}
