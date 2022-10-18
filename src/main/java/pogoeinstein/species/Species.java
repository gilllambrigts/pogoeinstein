package pogoeinstein.species;

import pogoeinstein.stats.IV.*;
import pogoeinstein.type.Type;

import java.util.ArrayList;

public class Species {
    private Integer generationID;
    private Integer id;
    private String name;

    //IV's
    private IVSpeed baseIVSpeed;
    private Defense baseDefense;
    private HP baseIVHealth;
    private Stamina baseStamina;
    private Attack baseAttack;
    private IVSpecialAttack baseIVSpAttack;
    private IVSpecialDefense baseIVSpDefense;
    private ArrayList<Type> types = new ArrayList<>();


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

    public IVSpecialDefense getBaseIVSpDefense() {
        return baseIVSpDefense;
    }

    public void setBaseIVSpDefense(IVSpecialDefense baseIVSpDefense) {
        this.baseIVSpDefense = baseIVSpDefense;
    }

    public IVSpecialAttack getBaseIVSpAttack() {
        return baseIVSpAttack;
    }

    public void setBaseIVSpAttack(IVSpecialAttack baseIVSpAttack) {
        this.baseIVSpAttack = baseIVSpAttack;
    }

    public Attack getBaseIVAttack() {
        return baseAttack;
    }

    public void setBaseIVAttack(Attack baseAttack) {
        this.baseAttack = baseAttack;
    }

    public HP getBaseIVHealth() {
        return baseIVHealth;
    }

    public void setBaseIVHealth(HP baseIVHealth) {
        this.baseIVHealth = baseIVHealth;
    }

    public Defense getBaseIVDefense() {
        return baseDefense;
    }

    public void setBaseIVDefense(Defense baseDefense) {
        this.baseDefense = baseDefense;
    }

    public IVSpeed getBaseIVSpeed() {
        return baseIVSpeed;
    }

    public void setBaseIVSpeed(IVSpeed baseIVSpeed) {
        this.baseIVSpeed = baseIVSpeed;
    }

    public Stamina getBaseIVStamina() {
        return baseStamina;
    }

    public void setBaseIVStamina(Stamina baseStamina) {
        this.baseStamina = baseStamina;
    }

    public ArrayList<Type> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<Type> types) {
        this.types = types;
    }

    public void addType(Type type) {
        this.types.add(type);
    }
}
