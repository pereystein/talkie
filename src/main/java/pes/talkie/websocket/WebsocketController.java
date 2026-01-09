package pes.talkie.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebsocketController {

    @MessageMapping("/chat.send") // Clients send to /app/chat.send
    @SendTo("/topic/messages")    // Subscribers of /topic/messages will receive this
    public ChatMessage sendMessage(ChatMessage message) {
        System.out.println("sendMessage " + message);
        return message;
    }
}
