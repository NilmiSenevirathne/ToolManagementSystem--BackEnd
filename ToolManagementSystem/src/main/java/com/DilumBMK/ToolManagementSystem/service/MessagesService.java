package com.DilumBMK.ToolManagementSystem.service;

import com.DilumBMK.ToolManagementSystem.repo.MessagesRepo;
import org.springframework.stereotype.Service;

@Service
public class MessagesService {

    private final MessagesRepo messagesRepo;

    public MessagesService(MessagesRepo messagesRepo) {
        this.messagesRepo = messagesRepo;
    }
}
