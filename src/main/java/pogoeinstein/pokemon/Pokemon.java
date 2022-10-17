package pogoeinstein.pokemon;

import pogoeinstein.pokedex.PokedexPokemon;

import java.util.UUID;

public class Pokemon {

    private PokedexPokemon pokedexPokemon;
    private String externalId;
    UUID uuid;

    public Pokemon(Integer id){
        this.pokedexPokemon = new PokedexPokemon(id);
        this.externalId =  uuid.randomUUID().toString();
    }

    public Integer getId() {
        return pokedexPokemon.getId();
    }

    public void setId(Integer id) {
        this.pokedexPokemon.setId(id);
    }

    public String getExternalId() {
        return externalId;
    }
}
