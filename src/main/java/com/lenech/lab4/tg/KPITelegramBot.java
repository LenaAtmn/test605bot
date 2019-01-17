package com.lenech.lab4.tg;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class KPITelegramBot extends TelegramLongPollingBot {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi botapi = new TelegramBotsApi();

        try {
            botapi.registerBot(new KPITelegramBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sendTextMsg(Message msg, String text) {
        try {
            execute(new SendMessage().setChatId(msg.getChatId()).setText(text));
        } catch (Exception e) {
//            LOG.error("Can't send Text message: ", e);
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message msg = update.getMessage();
        sendTextMsg(msg, "Brave new world");
    }

    @Override
    public String getBotUsername() {
        return "test605bot";
    }

    @Override
    public String getBotToken() {
        return "692962048:AAAG0_IqNZFUyY78V59AFh4y17uwVwKFtttc";
    }
}
