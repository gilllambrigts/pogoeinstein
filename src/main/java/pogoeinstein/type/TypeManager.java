package pogoeinstein.type;

import org.json.JSONArray;
import org.json.JSONObject;
import pogoeinstein.dataParser.DataParser;

import pogoeinstein.environment.Environment;

import java.util.ArrayList;
import java.util.Iterator;

public class TypeManager {

    DataParser dataParser = new DataParser();
    private ArrayList<Type> types = new ArrayList<>();

    public TypeManager(){

    }

    public ArrayList<Type> getAllTypes(){
        return types;
    }

    public Type getTypeFromArrayList(String typeName){

        //Traverse the arraylist. If the name corresponds to the name of the passed typename, return it.
        for(Integer i = 0; i < types.toArray().length; i++){

            if (types.get(i).getName().equals(typeName)){
                return types.get(i);
            }
        }
        return null;
    }

    public void setupTypeEffectiveness(Type type){
        JSONArray jsonTypeEffectiveness = dataParser.parseDataFromJSON(Environment.TYPE_effectiveness_URI);
        JSONObject effectivenessJSONObject = jsonTypeEffectiveness.getJSONObject(0).getJSONObject(type.getName());
        System.out.println("Effectiveness of " + type.getName() + " against:");
        Iterator<String> keys = effectivenessJSONObject.keys();
        keys.forEachRemaining(key -> {
            System.out.println("\t" + key + ": " +  effectivenessJSONObject.getDouble(key));
            type.addToEffectivenessMap(key, effectivenessJSONObject.getDouble(key));
        });
//
    }

    //Go through the JSON file that contains all the types. Create a new type per type. After that, fill its weaknesses, strengths and immunes with newly created types as well.
    public void parseTypesFromResources(){
        JSONArray jsonTypesArray = dataParser.parseDataFromJSON(Environment.TYPE_URI);

        for (Integer i = 0; i < jsonTypesArray.length(); i++) {
            Type curType = new Type(jsonTypesArray.getJSONObject(i).getString("name"));

            //Set the weaknesses
            JSONArray weaknessArray = jsonTypesArray.getJSONObject(i).getJSONArray("weaknesses");
            if(weaknessArray.length() > 0){

                for(Integer j = 0; j < weaknessArray.length(); j++ ){
                    Type curWeaknessType = new Type(weaknessArray.getString(j));
                    curType.addWeakness(curWeaknessType);
                }
            }

            //Set the immunes
            JSONArray immunesArray = jsonTypesArray.getJSONObject(i).getJSONArray("immunes");
            if(immunesArray.length() > 0){

                for(Integer j = 0; j < immunesArray.length(); j++ ){
                    Type curImmuneType = new Type(immunesArray.getString(j));
                    curType.addImmunes(curImmuneType);
                }
            }

            //Set the strengths
            JSONArray strengthArray = jsonTypesArray.getJSONObject(i).getJSONArray("strengths");
            if(strengthArray.length() > 0){

                for(Integer k = 0; k < strengthArray.length(); k++ ){
                    Type curStrengthType = new Type(strengthArray.getString(k));
                    curType.addStrength(curStrengthType);
                }

            }

            //Set up the effectiveness
            setupTypeEffectiveness(curType);
            types.add(curType);
        }

    }
}
