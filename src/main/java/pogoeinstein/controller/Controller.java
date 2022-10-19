package pogoeinstein.controller;

import pogoeinstein.calculators.CPCalculator;
import pogoeinstein.calculators.IVCalculator;
import pogoeinstein.move.Move;
import pogoeinstein.move.MoveManager;
import pogoeinstein.pokedex.Pokedex;
import pogoeinstein.pokedex.PokedexManager;
import pogoeinstein.stats.IV.IV;
import pogoeinstein.type.TypeManager;

public class Controller {

    public Pokedex pokedex = new Pokedex();
    public PokedexManager pokedexManager = new PokedexManager();
    public TypeManager typeManager = new TypeManager();
    public MoveManager moveManager = new MoveManager();
    public CPCalculator cpCalculator = new CPCalculator();
    public IVCalculator ivCalculator = new IVCalculator();

    public Controller(){
        pokedexManager.parsePokeDexFromResources(pokedex);
    }
}
