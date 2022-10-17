package pokedex;

import org.junit.jupiter.api.Test;
import pogoeinstein.pokedex.PokedexManager;

public class TestPokedexManager {

    @Test
    public void generatePokeDex(){
        PokedexManager pdManager = new PokedexManager();
        pdManager.parsePokeDexFromResources();
    }

}
