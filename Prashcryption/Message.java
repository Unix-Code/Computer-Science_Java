public class Message {
    private String message;
    private boolean encrypted;
    
    public Message() {
        message = "";
        encrypted = false;
    }
    
    public Message(String message) {
        this.message = message;
        encrypted = false;
    }
    
    public Message(String message, boolean encrypted) {
        this.message = message;
        this.encrypted = encrypted;
    }
    
    public String getMessage() {return message;}
    
    public boolean isEncrypted() {return encrypted;}
}