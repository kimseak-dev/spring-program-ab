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

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String hello() {
        return  "hello";
    }




//    @RequestMapping(value = "/chat/{userRequest}", method = RequestMethod.GET)
//    public Message getResponse(@PathVariable("userRequest") String userRequest) {
//
//        String path = System.getProperty("user.dir");
//        String name = "alice2";
//        String action = "chat";
//
//        Bot bot = new Bot(name, path, action);
//        bot.brain.nodeStats();
//        Chat chatSession = new Chat(bot);
//        String response = chatSession.multisentenceRespond(userRequest);
//        Message msg = new Message(response);
//
//        return msg;
//    }


}
