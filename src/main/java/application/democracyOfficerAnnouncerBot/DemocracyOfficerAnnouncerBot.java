package application.democracyOfficerAnnouncerBot;

import application.democracyOfficerAnnouncerBot.events.ReadyEventListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class DemocracyOfficerAnnouncerBot {
    private static JDA jda;

    public void start() throws InterruptedException {
        final String token = "YOUR BOT TOKEN HERE";

        JDABuilder jdaBuilder = JDABuilder.createDefault(token);
        this.jda = jdaBuilder
                .addEventListeners(new ReadyEventListener())
                .build();

        jda.awaitReady();
    }
}
