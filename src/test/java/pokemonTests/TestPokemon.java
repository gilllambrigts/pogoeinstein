package pokemonTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pogoeinstein.pokedex.Pokedex;
import pogoeinstein.pokedex.PokedexManager;
import pogoeinstein.pokemon.Pokemon;

public class TestPokemon {

    @Test
    public void createPokemon(){
        Pokedex pokedex = new Pokedex();
        PokedexManager pdManager = new PokedexManager();
        pdManager.parsePokeDexFromResources(pokedex);
        Pokemon Charmeleon = new Pokemon(pokedex.getSpeciesForId(5), 2.02,2.3,3.0,3,3,3);

        System.out.println(Charmeleon);
        Assertions.assertEquals(Charmeleon.getName(), "Charmeleon");
    }
}
