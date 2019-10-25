package org.alicebot.ab.controller;


import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String hello() {
        return  "hello";
    }




    @RequestMapping(value = "/chat/{userRequest}", method = RequestMethod.GET)
    public Message getResponse(@PathVariable("userRequest") String userRequest) {
        String response = chatSession.multisentenceRespond(userRequest);
        Message msg = new Message(response);
        System.out.print(userRequest);
        if (msg.getText().equalsIgnoreCase("Hello! I am ACLEDA Chatbot, your robot assistant? Choose your language")) {
            msg.setType("lang");
        } else if (msg.getText().equalsIgnoreCase("Feel free to select topic or type in your question and I'll help you out.")) {
            msg.setType("productionList");
        }

        return msg;
    }




}
