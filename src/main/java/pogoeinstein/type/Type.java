package pogoeinstein.type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Type {

    private String name;

    private List<Type> weaknesses = new ArrayList<Type>();
    private List<Type> immunes = new ArrayList<Type>();
    private List<Type> strengths = new ArrayList<Type>();
    private Map<String, Double> effectivenessMap = new HashMap<>();

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

    public Map<String, Double> getEffectivenessMap() {
        return effectivenessMap;
    }

    public Double getEffectivenessAgainstType(String typeName){
        return effectivenessMap.get(typeName);
    }

    public void setEffectivenessMap(Map<String, Double> effectivenessMap) {
        this.effectivenessMap = effectivenessMap;
    }

    public void addToEffectivenessMap(String key, Double value){
        this.effectivenessMap.put(key, value);
    }
}
