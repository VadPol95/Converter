package converter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import record.Record;
import util.ReadFromFile;

import java.io.File;
import java.io.IOException;


public class YamlToJson {
        public static String converterJSON(String dirResult, String name, String dirName) {
            String dirFile = dirResult + "/" + name;
            String fileName = name.substring(0, name.indexOf(".")) + ".json";
            File file = new File(dirName + "/" + fileName);
            String json = null;
            try {
                file.createNewFile();
                String yaml = ReadFromFile.readToString(dirFile);
                json = asJson(yaml);
                Record.writeToFile(file, json);
            } catch (IOException e) {
                return json;
            }
            return json;
        }
    private static String asJson(String yamlString) {
        ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
        Object obj;
        try {
            obj = yamlReader.readValue(yamlString, Object.class);
            ObjectMapper jsonWriter = new ObjectMapper();
            return jsonWriter.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return "";
        }
    }
}
