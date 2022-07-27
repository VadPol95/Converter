package record;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Record {
    public static boolean writeToFile(File file, String text) {
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(text);
            return true;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
