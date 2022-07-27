package converter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import record.Record;
import util.ReadFromFile;

import java.io.File;
import java.io.IOException;


public class JsonToYaml {
    public static String converterYAML(String dirResult, String name, String dirName) {
        String dirFile = dirResult + "/" + name;
        String fileName = name.substring(0, name.indexOf(".")) + ".yaml";
        File file = new File(dirName + "/" + fileName);
        String yaml = null;
        try {
            file.createNewFile();
            String json = ReadFromFile.readToString(dirFile);
            yaml = asYaml(json);
            Record.writeToFile(file, yaml);
            return yaml;
        } catch (IOException e) {
            return yaml;
        }
    }
    public static String asYaml(String jsonString) {
        try {
            JsonNode jsonNodeTree = new ObjectMapper().readTree(jsonString);
            return new YAMLMapper().writeValueAsString(jsonNodeTree);
        } catch (IOException e) {
            return "";
        }
    }
}
