package pogoeinstein.pokedex;

public class PokedexPokemon {
    private Integer generationID;
    private Integer id;
    private String name;

    public PokedexPokemon(Integer id){
        setId(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
