package pokedex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pogoeinstein.pokedex.Pokedex;
import pogoeinstein.pokedex.PokedexManager;

public class TestDoesPokedexLoadJSONResources {

    @Test
    public void generatePokeDex(){
        Pokedex pokedex = new Pokedex();
        PokedexManager pdManager = new PokedexManager();
        pdManager.parsePokeDexFromResources(pokedex);
        Assertions.assertEquals(pokedex.getAllSpecies().toArray().length, 809);
    }
}
