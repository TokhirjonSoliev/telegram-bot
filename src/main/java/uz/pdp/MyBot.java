package uz.pdp;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot implements TelegramBotUtils{
    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()){
            String text = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();
            SendMessage sendMessage = null;
            switch (text){
                case "hello":
                    sendMessage = new SendMessage(chatId + "", "hello");
                    break;
                case "hi":
                    sendMessage = new SendMessage(chatId + "", "hi");
                    break;
                case "how are you":
                    sendMessage = new SendMessage(chatId + "", "good, you");
                    break;
                case "what are you doing":
                    sendMessage = new SendMessage(chatId + "", "nothing you");
                    break;
                default:
                    sendMessage = new SendMessage(chatId + "", "i dont understand");
                    break;
            }
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
