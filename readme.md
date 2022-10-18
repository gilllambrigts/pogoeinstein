Pokemon Einstein

Used as a tool to track a pokedex. 

Planned to feature:
Compare different matchups of pokemon.
Show Meta combinations.


Usage:
Instantiating a pokemon:
        
        MoveManager mm = new MoveManager();
        mm.parseMovesFromJsonFile();

        Pokedex pd = new Pokedex();
        PokedexManager pdm = new PokedexManager();

        pdm.parsePokeDexFromResources(pd);

        Move move1 = mm.getMoveWithId(5);
        Move move2 = mm.getMoveWithId(20);

        Pokemon bulbasaur = new Pokemon(pd.getSpeciesForId(1),1.0,1.0);
 
        bulbasaur.addMove(move1);
        bulbasaur.addMove(move2);
