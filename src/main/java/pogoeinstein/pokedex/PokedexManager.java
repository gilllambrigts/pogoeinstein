package pogoeinstein.pokedex;

import org.json.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import pogoeinstein.dataParser.DataParser;
import pogoeinstein.settings.environment.Environment;
import pogoeinstein.type.TypeManager;

public class PokedexManager {

    DataParser dataParser = new DataParser();;
    TypeManager typeManager = new TypeManager();

    public PokedexManager(){
        //Manage all the types.
        typeManager.parseTypesFromResources();
    }

    public void parsePokeDexFromResources(){

        JSONArray jsonArray = dataParser.parseDataFromJSON(Environment.POKEDEX_URI);
        for (Integer i = 0; i < jsonArray.length(); i++) {
            System.out.println(jsonArray.getJSONObject(i).toString());
            PokedexPokemon pdPokemon = new PokedexPokemon(Integer.valueOf(jsonArray.getJSONObject(i).getInt("id")));
            System.out.println(pdPokemon.getId());
        }

    }
}
