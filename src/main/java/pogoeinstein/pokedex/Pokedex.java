package pogoeinstein.pokedex;


import pogoeinstein.species.Species;

import java.util.ArrayList;

public class Pokedex {
    private ArrayList<Species> species = new ArrayList<Species>();

    public Pokedex(){

    }

    public Species getSpeciesForId(int id){
        return species.stream().filter(currentSpecies -> currentSpecies.getId().equals(id)).findFirst().orElse(null);
    }

    public ArrayList<Species> getAllSpecies(){
        return species;
    }

    public void addSpecies(Species species){
        this.species.add(species);
    }
}
