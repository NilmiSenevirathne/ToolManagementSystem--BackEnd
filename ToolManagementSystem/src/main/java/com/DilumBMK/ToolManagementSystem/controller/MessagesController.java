package com.DilumBMK.ToolManagementSystem.controller;

import com.DilumBMK.ToolManagementSystem.service.MessagesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/messages")
public class MessagesController {

    private final MessagesService messagesService;

    public MessagesController(MessagesService messagesService) {
        this.messagesService = messagesService;
    }
}
