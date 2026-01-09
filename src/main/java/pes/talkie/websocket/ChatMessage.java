package pes.talkie.websocket;

public record ChatMessage(String sender, String content) {
    public static ChatMessage from(String message) {
        return new ChatMessage("sender", message);
    }
}
