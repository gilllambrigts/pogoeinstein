package combatPowerTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pogoeinstein.pokedex.Pokedex;
import pogoeinstein.pokedex.PokedexManager;
import pogoeinstein.pokemon.Pokemon;
import pogoeinstein.stats.combatPower.CombatPowerManager;

import java.math.BigDecimal;
import java.util.Random;

public class TestCombatPowerManager {


    CombatPowerManager cp;

    @BeforeEach
    public void reset(){
        cp = new CombatPowerManager();
        cp.parseMultipliers();
    }

    @Test
    public void checkIfMultiplierIsCorrect(){
        Pokedex pd = new Pokedex();
        PokedexManager pdManager = new PokedexManager();
        pdManager.parsePokeDexFromResources(pd);
        Integer rnd = new Random().nextInt(809);
        Pokemon rndPokemon = new Pokemon(pd.getSpeciesForId(306), 2.0, 2.0,32.0,13,11,14);



        System.out.println("CP Calculation for " + rndPokemon.getName());
        System.out.println("\tCP: " + rndPokemon.getCp().getValue());

        Assertions.assertEquals(BigDecimal.valueOf( 0.6475809663534164), cp.getMultiplierForLevel(23.5));
    }
}
