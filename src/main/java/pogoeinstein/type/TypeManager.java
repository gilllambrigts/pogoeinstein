package pogoeinstein.type;

import org.json.JSONArray;
import pogoeinstein.dataParser.DataParser;

import pogoeinstein.environment.Environment;

import java.util.ArrayList;

public class TypeManager {

    DataParser dataParser = new DataParser();
    private ArrayList<Type> types;

    public TypeManager(){

    }

    public Type getTypeFromArrayList(String typeName){
        //Traverse the arraylist. If the name corresponds to the name of the passed typename, return it.
        for(Integer i = 0; i < types.toArray().length; i++){
            if (types.get(i).getName() == typeName){
                return types.get(i);
            }
        }
        return null;
    }

    //Go through the JSON file that contains all the types. Create a new type per type. After that, fill its weaknesses, strengths and immunes with newly created types as well.
    public void parseTypesFromResources(){
        JSONArray jsonArray = dataParser.parseDataFromJSON(Environment.TYPE_URI);

        for (Integer i = 0; i < jsonArray.length(); i++) {
            Type curType = new Type(jsonArray.getJSONObject(i).getString("name"));

            //Set the weaknesses
            JSONArray weaknessArray = jsonArray.getJSONObject(i).getJSONArray("weaknesses");
            if(weaknessArray.length() > 0){

                for(Integer j = 0; j < weaknessArray.length(); j++ ){
                    Type curWeaknessType = new Type(weaknessArray.getString(j));
                    curType.addWeakness(curWeaknessType);
                }
            }

            //Set the immunes
            JSONArray immunesArray = jsonArray.getJSONObject(i).getJSONArray("immunes");
            if(immunesArray.length() > 0){

                for(Integer j = 0; j < immunesArray.length(); j++ ){
                    Type curImmuneType = new Type(immunesArray.getString(j));
                    curType.addImmunes(curImmuneType);
                }
            }

            //Set the strengths
            JSONArray strengthArray = jsonArray.getJSONObject(i).getJSONArray("strengths");
            if(strengthArray.length() > 0){

                for(Integer k = 0; k < strengthArray.length(); k++ ){
                    Type curStrengthType = new Type(strengthArray.getString(k));
                    curType.addStrength(curStrengthType);
                }

            }
        }
    }
}
