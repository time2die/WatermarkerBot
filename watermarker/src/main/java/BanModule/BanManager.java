package BanModule;

import java.io.*;

public class BanManager implements AccessManager {

    private String initBlacklist() {
        String out = null;

        try (BufferedReader helpRdr = new BufferedReader(new FileReader("blacklist.txt"))) {
            String lineval;
            do {
                lineval = helpRdr.readLine();
                if (lineval != null)
                    out += lineval;
                else {
                    helpRdr.close();
                    return out;
                }
            } while (1 != 0);
        } catch (
                Throwable exc) {
            System.out.println("Error: " + exc.getMessage());
            return null;
        }
    }

    public boolean ifBlocked(long chat_id) { //Check if id blocked
        String blacklist = initBlacklist();
        try {
            return blacklist.contains(String.valueOf(chat_id));
        } catch (NullPointerException exc) {
            System.out.println("Error: " + exc.getMessage());
            return false;
        }

    }

    public void banUser(long chat_id) {
        File fout = new File("blacklist.txt");

        if (!ifBlocked(chat_id)) {     //Check if id blocked already
            try (FileOutputStream fos = new FileOutputStream(fout, true);
                 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
                 PrintWriter pw = new PrintWriter(bw)) {

                pw.println(chat_id);
            } catch (Throwable exc) {
                System.out.println("Error: " + exc.getMessage());
            }
        }
    }
}
