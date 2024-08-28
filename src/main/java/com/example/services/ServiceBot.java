package com.example.services;

import org.telegram.telegrambots.meta.api.methods.send.SendDocument;

public interface ServiceBot {
    SendDocument createSendDocument(String idUser, String path);
}
