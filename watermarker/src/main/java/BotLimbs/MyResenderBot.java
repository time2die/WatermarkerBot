package BotLimbs;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyResenderBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        //This method will be called when an Update is received by your bot.

        Message inc_message = update.getMessage();
        long chat_id = Long.parseLong(System.getenv("chat_id")); //Get env var for Home chat id

        if (this.isMsgFromHome(inc_message,chat_id)) {
        } else {
            if (this.isMsgValid(update)) {
                if (this.isMsgLongEnough(inc_message))
                {
                    SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
                    message.setChatId(update.getMessage().getChatId());
                    message.setText("Необходимо больше 50 смволов.");
                    try {
                        execute(message); // Call method to send the message
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    try {
                        execute(MessageSender.resendMessage(chat_id,update)); // Call method to send the message
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
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

    private boolean isMsgValid(Update update){ //Check if bot get message
        return update.hasMessage() && update.getMessage().hasText();
    }

    private boolean isMsgFromHome(Message message,Long chat_id){ //Check if message from Home chat
        return message.getChatId().equals(chat_id);
    }

    private boolean isMsgLongEnough(Message message){
        return message.getText().length()<50;
    }

}
