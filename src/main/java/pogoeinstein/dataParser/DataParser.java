package pogoeinstein.dataParser;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class DataParser {

    final String defaultCharSet = "UTF-8";

    public JSONArray parseDataFromJSON(String uri){
        File jsonFile = new File(uri);
        if(jsonFile.exists()){
            try{

                InputStream io = new FileInputStream(jsonFile);
                String jsonString = IOUtils.toString(io, defaultCharSet);
                JSONArray jsonArray = new JSONArray(jsonString);
                return jsonArray;

            }catch (Exception e){
                System.out.println(e.toString());

            }
        }
        return null;
    }
}
