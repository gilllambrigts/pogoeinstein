package pogoeinstein.move;

import pogoeinstein.type.Type;

public class Move {

    private Integer id;
    private String name;
    private Integer accuracy;
    private Integer power;
    private Integer pp;
    private Type type;

    public Move(Integer id, String name, Integer accuracy, Integer power, Integer pp, Type type){
        setId(id);
        setName(name);
        setAccuracy(accuracy);
        setPower(power);
        setPp(pp);
        setType(type);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getPp() {
        return pp;
    }

    public void setPp(Integer pp) {
        this.pp = pp;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Integer accuracy) {
        this.accuracy = accuracy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
