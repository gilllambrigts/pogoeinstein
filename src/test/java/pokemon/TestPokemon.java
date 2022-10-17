package pokemon;

import org.junit.jupiter.api.Test;
import pogoeinstein.pokemon.Pokemon;

public class TestPokemon {

     @Test
    public void createPokemon(){
         Pokemon pokemon = new Pokemon(5);
         System.out.println(pokemon.getExternalId());
     }
}
