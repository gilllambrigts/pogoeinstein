package pogoeinstein.type;

import java.util.ArrayList;
import java.util.List;

public class Type {

    private String name;

    private List<Type> weaknesses = new ArrayList<Type>();
    private List<Type> immunes = new ArrayList<Type>();
    private List<Type> strengths = new ArrayList<Type>();

    public Type(String typeName){
        setName(typeName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addWeakness(Type type){
        this.weaknesses.add(type);
    }

    public List<Type> getWeaknesses(){
        return weaknesses;
    }

    public List<Type> getImmunes() {
        return immunes;
    }

    public void addImmunes(Type type) {
        this.immunes.add(type);
    }

    public List<Type> getStrengths() {
        return strengths;
    }

    public void addStrength(Type type) {
        this.strengths.add(type);
    }
}
