package moveTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pogoeinstein.move.Move;
import pogoeinstein.move.MoveManager;
import pogoeinstein.pokedex.Pokedex;
import pogoeinstein.pokedex.PokedexManager;
import pogoeinstein.pokemon.Pokemon;

public class TestDoesMoveExist {

    @Test
    public void DoesMoveExist(){
        MoveManager mm = new MoveManager();
        Pokedex pd = new Pokedex();
        PokedexManager pdm = new PokedexManager();
        pdm.parsePokeDexFromResources(pd);

        mm.parseMovesFromJsonFile();
        System.out.println(mm.getMoveWithId(2).getName());

        Move move1 = mm.getMoveWithId(5);
        Move move2 = mm.getMoveWithId(20);

        Pokemon bulbasaur = new Pokemon(pd.getSpeciesForId(1),1.0,1.0);
        bulbasaur.addMove(move1);
        bulbasaur.addMove(move2);

        Assertions.assertEquals(mm.getMoveWithId(2).getName(), "Double Slap");
    }
}
