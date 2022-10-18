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
        Integer pokemonId = 0;
        Integer previousPokemonId = 0;

        for (Integer i = 0; i < jsonArray.length(); i++) {

            pokemonId = jsonArray.getJSONObject(i).getInt("pokemon_id");

            if(pokemonId == previousPokemonId){
            }else{

                Species currentSpecies = new Species();
                previousPokemonId = pokemonId;

                IVAttack attack = new IVAttack(jsonArray.getJSONObject(i).getInt("base_attack"));
                IVDefense defense = new IVDefense(jsonArray.getJSONObject(i).getInt("base_defense"));
                IVStamina stamina = new IVStamina(jsonArray.getJSONObject(i).getInt("base_stamina"));
                currentSpecies.setId(jsonArray.getJSONObject(i).getInt("pokemon_id"));
                currentSpecies.setName(jsonArray.getJSONObject(i).getString("pokemon_name"));
                currentSpecies.setBaseIVAttack(attack);
                currentSpecies.setBaseIVDefense(defense);
                currentSpecies.setBaseIVStamina(stamina);

                pd.addSpecies(currentSpecies);
                System.out.println(currentSpecies.getName());
            }

        }

        //Set up the type per pokemon
        JSONArray jsonArrayPokemonTypes = dataParser.parseDataFromJSON(Environment.POKEMON_TYPE_URI);

        pokemonId = 0;
        previousPokemonId = 0;
        for (Integer i = 0; i < jsonArrayPokemonTypes.length(); i++){

            pokemonId = jsonArray.getJSONObject(i).getInt("pokemon_id");
            if(pokemonId == previousPokemonId){
            }else{
                previousPokemonId = pokemonId;
                JSONArray pokemonTypeObject= jsonArrayPokemonTypes.getJSONObject(i).getJSONArray("type");

                for(Integer j = 0; j < pokemonTypeObject.length(); j++){
                    pd.getSpeciesForId(pokemonId).addType(typeManager.getTypeFromArrayList(pokemonTypeObject.getString(j)));
                }

            }
        }

    }

}
