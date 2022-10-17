package pogoeinstein.move;

import org.json.JSONArray;
import org.json.JSONObject;
import pogoeinstein.dataParser.DataParser;
import pogoeinstein.environment.Environment;
import pogoeinstein.species.Species;
import pogoeinstein.stats.IV.*;
import pogoeinstein.type.Type;
import pogoeinstein.type.TypeManager;

import java.util.ArrayList;

public class MoveManager {

    private DataParser dataParser = new DataParser();
    private ArrayList<Move> moveList = new ArrayList<>();
    private TypeManager tm = new TypeManager();

    public MoveManager(){
        tm.parseTypesFromResources();
    }

    public Move getMoveWithId(Integer id){
        return moveList.get(id);
    }

    public void parseMovesFromJsonFile(){
        JSONArray jsonArray = dataParser.parseDataFromJSON(Environment.MOVES_URI);

        for (Integer i = 0; i < jsonArray.length(); i++) {
            Integer id = jsonArray.getJSONObject(i).getInt("id");
            String name = jsonArray.getJSONObject(i).getString("ename");
            Integer accuracy;
            Integer power;
            Integer pp;

            if(jsonArray.getJSONObject(i).get("pp") == JSONObject.NULL){
                pp = null;
            }else{
                pp = jsonArray.getJSONObject(i).getInt("pp");
            }

            if(jsonArray.getJSONObject(i).get("accuracy") == JSONObject.NULL){
                accuracy = null;
            }else{
                accuracy = jsonArray.getJSONObject(i).getInt("accuracy");
            }

            if(jsonArray.getJSONObject(i).get("power") == JSONObject.NULL){
                power = null;
            }else{
                power = jsonArray.getJSONObject(i).getInt("power");
            }

            Type type = new Type(tm.getTypeFromArrayList(jsonArray.getJSONObject(i).getString("type")).getName());

            Move currentMove = new Move(id, name, accuracy, power, pp, type);

            moveList.add(currentMove);
        }

    }
}
