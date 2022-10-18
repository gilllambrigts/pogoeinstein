package pokedexTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pogoeinstein.pokedex.Pokedex;
import pogoeinstein.pokedex.PokedexManager;
import pogoeinstein.species.Species;

public class TestDoesPokedexLoadJSONResources {

    @Test
    public void generatePokeDex(){
        Pokedex pokedex = new Pokedex();
        PokedexManager pdManager = new PokedexManager();
        pdManager.parsePokeDexFromResources(pokedex);
        for(Species species: pokedex.getAllSpecies()){
            System.out.println(species.getName());
            species.getTypes().forEach(type -> {
                System.out.println("\t" + type.getName());
            });
        }

        Assertions.assertEquals(pokedex.getAllSpecies().toArray().length, 1059);

    }
}
