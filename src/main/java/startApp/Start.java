package startApp;

import util.FilesDir;

import java.io.IOException;

public class Start {
    public static void start(String[] args) throws IOException {
        FilesDir file = new FilesDir();
        try {
            String dir = args[0];
            file.listFiles(dir);
        } catch (ArrayIndexOutOfBoundsException e) {

            String dir = System.getProperty("user.dir");
            file.listFiles(dir);
        }
    }
}
