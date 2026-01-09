package pes.talkie.broadcast;

import org.springframework.web.bind.annotation.*;
import pes.talkie.sse.SseService;

@RestController
@RequestMapping("/broadcast")
public class BroadcastController {
    private final SseService sseService;

    public BroadcastController(SseService sseService) {
        this.sseService = sseService;
    }

    @PostMapping()
    public void broadcast(@RequestBody String message) {
        System.out.println(message);

        sseService.broadcast(message);
    }

    @GetMapping("/ping")
    public String ping() {
        return "OK";
    }

}
