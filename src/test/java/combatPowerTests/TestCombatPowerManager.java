package combatPowerTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pogoeinstein.pokedex.Pokedex;
import pogoeinstein.pokedex.PokedexManager;
import pogoeinstein.pokemon.Pokemon;
import pogoeinstein.settings.environment.Settings;
import pogoeinstein.stats.combatPower.CombatPowerManager;

import java.math.BigDecimal;
import java.util.Random;
import java.util.Set;

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
        Pokemon rndPokemon = new Pokemon(pd.getSpeciesForId(242), 2.0, 2.0,45.0,0,0,0);

        System.out.println("CP Calculation for " + rndPokemon.getName());
        System.out.println("\tCP: " + rndPokemon.getCp().getValue());

        Assertions.assertEquals(BigDecimal.valueOf( 0.6475809663534164), cp.getMultiplierForLevel(23.5));

        CombatPowerManager cpm = new CombatPowerManager();
        cpm.parseMultipliers();

        //Find the optimal CP combination
        for(double iterator = 0; iterator < Settings.POKEMON_LEVEL_MAX - 1; iterator += 0.5){
            for(int j = 0; j <= Settings.POKEMON_STATS_IV_MAX; j++){
                for(int k = 0; k <= Settings.POKEMON_STATS_IV_MAX; k++){
                    for(int l = 0; l <= Settings.POKEMON_STATS_IV_MAX; l++){
                        int result = cpm.calculateCombatPower(iterator + 1, rndPokemon.getTotalDefense() + j,rndPokemon.getTotalAttack() + k,rndPokemon.getTotalStamina()).getValue() + l;
                        if(result > Settings.LEAGUE){
                            break;
                        }else if(result > 1490){
                            System.out.println("Level: " + iterator + " - " + " Defense: " + j + " Attack: " + k + " Stamina: " + l + " \t " + result);
                        }else{

                        }
                    }
                }
            }
        }

    }
}
