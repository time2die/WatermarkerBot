package BotLimbs;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class MessageSender {

    //Main method for resend messages to Home chat
     static SendMessage resendMessage(long chat_id, Update update){
        SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
        message.setChatId(chat_id);
        message.setText(update.getMessage().getDate() + " Cообщение от\n" +
                "FirstName\t\tLastName\t\tUsername\t\tID\n" +
                update.getMessage().getFrom().getFirstName() + "\t" +
                update.getMessage().getFrom().getLastName() + "\t" +
                update.getMessage().getFrom().getUserName() + "\t" +
                update.getMessage().getChatId() + "\n" +
                update.getMessage().getText());
        return message;

    }
}
