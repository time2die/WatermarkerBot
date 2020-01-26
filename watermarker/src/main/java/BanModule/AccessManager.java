package BanModule;

public interface AccessManager {
     boolean ifBlocked(long chat_id);
     void banUser(long chat_id);
}
