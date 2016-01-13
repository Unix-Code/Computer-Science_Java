public class Encryptor {
    public static Message encrypt(Message sStart) {
        if (sStart.isEncrypted()) return sStart;
        
        String end = "";
        String start = sStart.getMessage();

        for (int i = 0; i < start.length(); i++) {
            end += (char)(((((int)(start.charAt(i)) - (int)'a') + i + 1)%26) + (int)'a');
        }

        return new Message(end, true);
    }

    public static Message decrypt(Message sStart) {
        if (sStart.isEncrypted() != true) return sStart;

        String start = sStart.getMessage();
        String end = "";

        for (int i = 0; i < start.length(); i++) {
            end += (char)((((((int)start.charAt(i) - (int)'a') - i - 1) + 26)%26) + (int)'a');
        }

        return new Message(end, false);

    }
}