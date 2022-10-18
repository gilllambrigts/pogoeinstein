package pogoeinstein.stats.combatPower;

import org.json.JSONArray;
import org.json.JSONObject;
import pogoeinstein.calculators.CPCalculator;
import pogoeinstein.dataParser.DataParser;
import pogoeinstein.environment.Environment;
import pogoeinstein.stats.IV.Defense;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CombatPowerManager {
    private DataParser dataParser = new DataParser();
    private Map<Double, BigDecimal> multiplierMap = new HashMap<>();
    public CombatPowerManager(){}

    public void parseMultipliers(){
        JSONArray multiplierJSONArray = dataParser.parseDataFromJSON(Environment.COMBAT_POWER_MULTIPLIER);

        for(int i = 0; i < multiplierJSONArray.length(); i++){
            JSONObject currentJSONObject = multiplierJSONArray.getJSONObject(i);
            multiplierMap.put(multiplierJSONArray.getJSONObject(i).getDouble("level"), currentJSONObject.getBigDecimal("multiplier"));
        }
    }

    public BigDecimal getMultiplierForLevel(Double level){
        return multiplierMap.get(level);
    }

    public CombatPower calculateCombatPower(Double level, int defenseTotal, int attackTotal, int staminaTotal){

        CPCalculator cpCalc = new CPCalculator();
        BigDecimal multiplier = getMultiplierForLevel(level);
        return new CombatPower(cpCalc.calculateCPAndFloor(multiplier,defenseTotal, attackTotal, staminaTotal), multiplier);
    }

}
