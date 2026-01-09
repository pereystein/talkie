package pes.talkie.broadcast;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import pes.talkie.sse.SseService;
import pes.talkie.websocket.ChatMessage;
import pes.talkie.websocket.WebsocketController;

@RestController
@RequestMapping("/broadcast")
public class BroadcastController {
    private final SseService sse;
    private final SimpMessagingTemplate websocket;

    public BroadcastController(SseService sse, SimpMessagingTemplate websocket) {
        this.sse = sse;
        this.websocket = websocket;
    }

    @PostMapping()
    public void broadcast(@RequestBody String message) {
        System.out.println(message);
        sse.broadcast(message);
        websocket.convertAndSend("/topic/messages", ChatMessage.from(message));
    }

    @GetMapping("/ping")
    public String ping() {
        return "OK";
    }

}
