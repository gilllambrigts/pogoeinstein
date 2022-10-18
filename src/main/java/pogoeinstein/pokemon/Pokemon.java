package pogoeinstein.pokemon;

import pogoeinstein.gender.Gender;
import pogoeinstein.move.Move;
import pogoeinstein.settings.environment.Settings;
import pogoeinstein.species.Species;
import pogoeinstein.stats.IV.Attack;
import pogoeinstein.stats.IV.Defense;
import pogoeinstein.stats.IV.HP;
import pogoeinstein.stats.IV.Stamina;
import pogoeinstein.stats.combatPower.CombatPower;
import pogoeinstein.stats.combatPower.CombatPowerManager;
import pogoeinstein.stats.level.Level;

import java.util.ArrayList;
import java.util.UUID;

public class Pokemon{
    private String uuid;
    private String nickname;
    private Species species = new Species();
    private Gender gender;
    private Double height;
    private Double weight;
    private Level level;
    private CombatPower cp;
    private Attack IVAttack;
    private Defense IVDefense;
    private Stamina IVStamina;
    private Attack totalAttack;
    private Defense totalDefense;
    private Stamina totalStamina;
    private ArrayList<Move> moves = new ArrayList<>();

    public Pokemon(Species parSpecies, Double height, Double weight, Double level, int attack, int defense, int stamina){
        setUuid(UUID.randomUUID().toString());
        setSpecies(parSpecies);
        setHeight(height);
        setWeight(weight);
        setIVAttack(attack);
        setIVDefense(defense);
        setIVStamina(stamina);
        setLevel(level);

        //Set the cp
        saveCP();
    }

    private void saveCP(){
        CombatPowerManager cpm = new CombatPowerManager();
        cpm.parseMultipliers();
        setCp(cpm.calculateCombatPower(getLevel(),getTotalDefense(),getTotalAttack(),getTotalStamina()));
    }

    private void setSpecies(Species species){
        this.species = species;
    }

    private void setGender(){
        //Gender
        Settings.getGenderMap().get(1);
    }

    public int getId() {
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

    public Double getLevel() {
        return level.getLevel();
    }

    public void setLevel(Double level) {
        this.level = new Level(level);
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public CombatPower getCp() {
        return cp;
    }

    public void setCp(CombatPower cp) {
        this.cp = cp;
    }

    public Attack getIVAttack() {
        return IVAttack;
    }

    public void setIVAttack(int IVAttack) {
        this.IVAttack = new Attack(IVAttack);
    }

    public Defense getIVDefense() {
        return IVDefense;
    }

    public void setIVDefense(int IVDefense) {
        this.IVDefense = new Defense(IVDefense);
    }

    public Stamina getIVStamina() {
        return IVStamina;
    }

    public void setIVStamina(int IVStamina) {
        this.IVStamina = new Stamina(IVStamina);
    }

    public int getTotalAttack() {
        return IVAttack.getValue() + species.getBaseIVAttack().getValue();
    }

    public void setTotalAttack(Attack totalAttack) {
        this.totalAttack = totalAttack;
    }

    public int getTotalDefense() {
        return IVDefense.getValue() + species.getBaseIVDefense().getValue();    }

    public void setTotalDefense(Defense totalDefense) {
        this.totalDefense = totalDefense;
    }

    public int getTotalStamina() {
        return IVStamina.getValue() + species.getBaseIVStamina().getValue();    }

    public void setTotalStamina(Stamina totalStamina) {
        this.totalStamina = totalStamina;
    }
}
