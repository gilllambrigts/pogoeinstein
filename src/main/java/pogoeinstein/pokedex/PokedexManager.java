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

            if(pokemonId.equals(previousPokemonId)){
            }else{

                Species currentSpecies = new Species();

                Attack attack = new Attack(jsonArray.getJSONObject(i).getInt("base_attack"));
                Defense defense = new Defense(jsonArray.getJSONObject(i).getInt("base_defense"));
                Stamina stamina = new Stamina(jsonArray.getJSONObject(i).getInt("base_stamina"));
                currentSpecies.setId(jsonArray.getJSONObject(i).getInt("pokemon_id"));
                currentSpecies.setName(jsonArray.getJSONObject(i).getString("pokemon_name"));
                currentSpecies.setBaseIVAttack(attack);
                currentSpecies.setBaseIVDefense(defense);
                currentSpecies.setBaseIVStamina(stamina);

                pd.addSpecies(currentSpecies);
                System.out.println("Added pokemon - " + currentSpecies.getName().toString());
                System.out.println("\t" + currentSpecies.getId());
            }

            previousPokemonId = pokemonId;
        }

        //Set up the type per pokemon
        JSONArray jsonArrayPokemonTypes = dataParser.parseDataFromJSON(Environment.POKEMON_TYPE_URI);

        pokemonId = 0;
        previousPokemonId = 0;
        for (Integer i = 0; i < jsonArrayPokemonTypes.length(); i++){

            //The list contains multiple occurrences of one the same pokemon. Because of this, we are storing a temporary pokemon id to see if it is still the same one.
            pokemonId = jsonArray.getJSONObject(i).getInt("pokemon_id");
            if(previousPokemonId.equals(jsonArrayPokemonTypes.getJSONObject(i).getInt("pokemon_id"))){
            }else{
                JSONArray pokemonTypeObject= jsonArrayPokemonTypes.getJSONObject(i).getJSONArray("type");
                System.out.println("Adding types for " + pd.getSpeciesForId(pokemonId).getName());
                System.out.println("\tid: " + jsonArray.getJSONObject(i).getInt("pokemon_id"));
                System.out.println("\ttypes:");
                for(Integer j = 0; j < pokemonTypeObject.length(); j++){
                    //Check if the type has already been added. Only add if the pokemon does not have it.
                    if(!pd.getSpeciesForId(pokemonId).getTypes().contains(typeManager.getTypeFromArrayList(pokemonTypeObject.getString(j)))){
                        pd.getSpeciesForId(pokemonId).addType(typeManager.getTypeFromArrayList(pokemonTypeObject.getString(j)));
                        System.out.println("\t\t" + typeManager.getTypeFromArrayList(pokemonTypeObject.getString(j)).getName());
                    }else{
                    }
                }

            }
            previousPokemonId = pokemonId;
        }

    }

}
