package pogoeinstein.pokedex;


import pogoeinstein.species.Species;

import java.util.ArrayList;

public class Pokedex {
    private ArrayList<Species> species = new ArrayList<Species>();

    public Pokedex(){

    }

    public Species getSpeciesForId(Integer id){
        if(id < 0){
            return species.get(0);
        }else{
            return species.get(id - 1);
        }
    }

    public ArrayList<Species> getAllSpecies(){
        return species;
    }

    public void addSpecies(Species species){
        this.species.add(species);
    }
}
