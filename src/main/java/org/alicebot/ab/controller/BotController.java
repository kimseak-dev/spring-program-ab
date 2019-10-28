package org.alicebot.ab.controller;


import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.entities.ClientMessage;
import org.alicebot.ab.entities.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/bot")
public class BotController {

    private static final Logger log = LoggerFactory.getLogger(BotController.class);
    private Chat chatSession;

    public BotController() {
        String path = System.getProperty("user.dir");
        String name = "acleda";
        String action = "chat";

        Bot bot = new Bot(name, path, action);
        bot.brain.nodeStats();
        chatSession = new Chat(bot);
    }



    @RequestMapping(value = "/post/chat/anylse", method = RequestMethod.POST)
    public Message postChatAnalyseToken(@RequestBody ClientMessage clientMessage){
        String response = chatSession.multisentenceRespond(clientMessage.getText());
        System.out.println(response);
        Message msg = new Message();
        msg.anylseData(response);
        return msg;
    }






}
