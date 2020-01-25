package BotLimbs;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyWatermarkerBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        //This method will be called when an Update is received by your bot.

        long chat_id = Long.parseLong(System.getenv("chat_id"));

        if (update.getMessage().getChatId().equals(chat_id)) {
        } else {
            if (update.hasMessage() && update.getMessage().hasText()) {
                SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
                message.setChatId(chat_id);
                message.setText("Cообщение от\n" + update.getMessage().getChatId() + "\t" + update.getMessage().getContact() + "\n" + update.getMessage().getText());

                try {
                    execute(message); // Call method to send the message
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
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
