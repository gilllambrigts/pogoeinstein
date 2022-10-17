package pogoeinstein.settings.environment;

import org.json.JSONObject;
import pogoeinstein.gender.Gender;

import java.util.HashMap;
import java.util.Map;

public class Settings {
    public final static Integer IV_MAX = 31;

    //Gender
    public static Map<Integer, String> getGenderMap(){
        HashMap<Integer, String> genderMap = new HashMap<Integer, String>();

        genderMap.put(0,"MALE");
        genderMap.put(1,"FEMALE");
        genderMap.put(2,"UNKNOWN");

        return genderMap;
    }

}
