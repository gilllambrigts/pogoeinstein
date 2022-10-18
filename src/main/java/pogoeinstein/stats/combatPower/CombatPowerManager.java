package pogoeinstein.stats.combatPower;

import org.json.JSONArray;
import org.json.JSONObject;
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
        BigDecimal multiplier = getMultiplierForLevel(level);
        BigDecimal multiplierForFormula = multiplier.multiply(multiplier);
        Double cp1 = (attackTotal) * Math.pow(defenseTotal, 0.5) * Math.pow(staminaTotal, 0.5);
        BigDecimal result = multiplierForFormula.multiply(BigDecimal.valueOf(cp1));
        result = result.divide(BigDecimal.valueOf(10));
        int resultFloor = (int) Math.floor(result.doubleValue());

        return new CombatPower(resultFloor, multiplier);
    }

}
