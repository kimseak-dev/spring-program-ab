package org.alicebot.ab.controller;


import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.crypto.AES;
import org.alicebot.ab.entities.ClientMessage;
import org.alicebot.ab.entities.CreditInfo;
import org.alicebot.ab.entities.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/bot")
public class BotController {

    CreditInfo creditInfo = new  CreditInfo();

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



    @RequestMapping(value = "/post/chat/anylse", method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public Message postChatAnalyseToken(@RequestBody ClientMessage clientMessage){



        // test encryption
        final String secretKey = "d900d6e900081ae0e84ad160c40000fa";
        String originalString = "howtodoinjava.com";



        AES.setKey("d900d6e900081ae0e84ad160c40000fa");
        String encryptedString = AES.encrypt(originalString, secretKey) ;
        String decryptedString = AES.decrypt(encryptedString, secretKey) ;


        System.out.println(originalString);
        System.out.println(encryptedString);
        System.out.println(decryptedString);




        System.out.println(clientMessage.getTextCode() + " " + clientMessage.getText());

        String response = chatSession.multisentenceRespond(clientMessage.getTextCode() + " " +clientMessage.getText());
        System.out.println(response);
        creditInfo.config(clientMessage.getTextCode(), clientMessage.getText());

        Message msg = new Message();
        msg.anylseData(response);

        Boolean test = (clientMessage.getTextCode().equalsIgnoreCase("CRE"));

        if (test == true) {
            msg.setText(creditInfo.toString());
        }



        return msg;
    }






}
