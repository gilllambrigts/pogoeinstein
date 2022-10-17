package pogoeinstein.pokedex;

import org.json.*;

import pogoeinstein.dataParser.DataParser;
import pogoeinstein.environment.Environment;
import pogoeinstein.species.Species;
import pogoeinstein.stats.IV.*;
import pogoeinstein.type.TypeManager;

public class PokedexManager {

    private DataParser dataParser = new DataParser();;
    private TypeManager typeManager = new TypeManager();
    private Pokedex pd = new Pokedex();

    public PokedexManager(){
        //Manage all the types.
        typeManager.parseTypesFromResources();
    }

    public void parsePokeDexFromResources(Pokedex pd){
        this.pd = pd;

        JSONArray jsonArray = dataParser.parseDataFromJSON(Environment.POKEDEX_URI);

        for (Integer i = 0; i < jsonArray.length(); i++) {

            Species currentSpecies = new Species();

            //Read values
            IVAttack attack = new IVAttack(jsonArray.getJSONObject(i).getJSONObject("base").getInt("Attack"));
            IVDefense defense = new IVDefense(jsonArray.getJSONObject(i).getJSONObject("base").getInt("Defense"));
            IVSpeed speed = new IVSpeed(jsonArray.getJSONObject(i).getJSONObject("base").getInt("Speed"));
            IVHP HP = new IVHP(jsonArray.getJSONObject(i).getJSONObject("base").getInt("HP"));
            IVSpecialAttack spAttack = new IVSpecialAttack(jsonArray.getJSONObject(i).getJSONObject("base").getInt("Sp. Attack"));
            IVSpecialDefense spDefense = new IVSpecialDefense(jsonArray.getJSONObject(i).getJSONObject("base").getInt("Sp. Defense"));

            //Set the properties
            currentSpecies.setId(jsonArray.getJSONObject(i).getInt("id"));
            currentSpecies.setName(jsonArray.getJSONObject(i).getJSONObject("name").getString("english"));
            currentSpecies.setBaseIVAttack(attack);
            currentSpecies.setBaseIVHealth(HP);
            currentSpecies.setBaseIVSpAttack(spAttack);
            currentSpecies.setBaseIVSpDefense(spDefense);
            currentSpecies.setBaseIVDefense(defense);
            currentSpecies.setBaseIVSpeed(speed);

            pd.addSpecies(currentSpecies);
        }
    }

}
