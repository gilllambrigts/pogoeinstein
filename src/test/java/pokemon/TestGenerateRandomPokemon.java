package pokemon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pogoeinstein.pokedex.Pokedex;
import pogoeinstein.pokedex.PokedexManager;
import pogoeinstein.pokemon.Pokemon;

import java.util.Random;

public class TestGenerateRandomPokemon {

    @Test
    public void generatePokemonWithRandomId(){
        Pokedex pd = new Pokedex();
        PokedexManager pdManager = new PokedexManager();
        pdManager.parsePokeDexFromResources(pd);
        Integer rnd = new Random().nextInt(809);
        Pokemon rndPokemon = new Pokemon(pd.getSpeciesForId(rnd), 2.0, 2.0);

        System.out.println(rndPokemon.getName());
        Assertions.assertNotNull(rndPokemon.getName());
    }
}
