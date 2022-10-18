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

            System.out.println("\tType(s):");
            species.getTypes().forEach(type -> {
                System.out.println("\t\t" + type.getName());
            });

            System.out.println("\tStats:");
            System.out.println("\t\tBase attack: " + species.getBaseIVAttack().getValue().toString());
            System.out.println("\t\tBase defense: " + species.getBaseIVDefense().getValue().toString());
            System.out.println("\t\tBase stamina: " + species.getBaseIVStamina().getValue().toString());
        }
        Assertions.assertEquals(900, pokedex.getAllSpecies().toArray().length );
    }
}
