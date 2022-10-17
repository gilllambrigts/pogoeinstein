package pogoeinstein.species;

import pogoeinstein.stats.IV.*;

public class Species {
    private Integer generationID;
    private Integer id;
    private String name;

    //IV's
    private IVSpeed baseIVSpeed;
    private IVDefense baseIVDefense;
    private IVHP baseIVHealth;
    private IVAttack baseIVAttack;
    private IVSpecialAttack baseIVSpAttack;
    private IVSpecialDefense baseIVSpDefense;


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

    public IVAttack getBaseIVAttack() {
        return baseIVAttack;
    }

    public void setBaseIVAttack(IVAttack baseIVAttack) {
        this.baseIVAttack = baseIVAttack;
    }

    public IVHP getBaseIVHealth() {
        return baseIVHealth;
    }

    public void setBaseIVHealth(IVHP baseIVHealth) {
        this.baseIVHealth = baseIVHealth;
    }

    public IVDefense getBaseIVDefense() {
        return baseIVDefense;
    }

    public void setBaseIVDefense(IVDefense baseIVDefense) {
        this.baseIVDefense = baseIVDefense;
    }

    public IVSpeed getBaseIVSpeed() {
        return baseIVSpeed;
    }

    public void setBaseIVSpeed(IVSpeed baseIVSpeed) {
        this.baseIVSpeed = baseIVSpeed;
    }
}
