package BotLimbs;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyWatermarkerBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        //This method will be called when an Update is received by your bot.

        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                    .setChatId(update.getMessage().getChatId())
                    .setText(update.getMessage().getText());
            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        //This method must always return your Bot username
        return "kjhgskdf743_bot";
    }

    @Override
    public String getBotToken() {
        //This method must always return your Bot Token
        return System.getenv("botToken");
    }
}
