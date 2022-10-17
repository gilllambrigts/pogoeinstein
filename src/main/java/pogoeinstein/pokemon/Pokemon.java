package pogoeinstein.pokemon;

import pogoeinstein.gender.Gender;
import pogoeinstein.move.Move;
import pogoeinstein.pokedex.Pokedex;
import pogoeinstein.settings.environment.Settings;
import pogoeinstein.species.Species;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Pokemon{

    private String uuid;
    private Species species = new Species();
    private Pokedex pokedex;
    private Gender gender;
    private Double height;
    private Double weight;
    private ArrayList<Move> moves = new ArrayList<>();

    public Pokemon(Species parSpecies, Double height, Double weight){
        setUuid(UUID.randomUUID().toString());
        setSpecies(parSpecies);
        setHeight(height);
        setWeight(weight);
    }

    private void setSpecies(Species species){
        this.species = species;
    }

    private void setGender(){
        //Gender
        Settings.getGenderMap().get(1);
    }

    public Integer getId() {
        return species.getId();
    }

    public String getName(){
        return species.getName();
    }

    public Gender getGender() {
        return gender;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public ArrayList<Move> getMoves() {
        return moves;
    }

    public void setMoves(ArrayList<Move> moves) {
        this.moves = moves;
    }

    public void addMove(Move move) {
        this.moves.add(move);
    }
}
