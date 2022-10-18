package pogoeinstein.calculators;

import pogoeinstein.pokemon.Pokemon;
import pogoeinstein.settings.environment.Settings;
import pogoeinstein.stats.combatPower.CombatPower;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CPCalculator {
    private Double calculateCP(BigDecimal multiplier, int defenseTotal, int attackTotal, int staminaTotal){
        multiplier = multiplier.multiply(multiplier);
        Double cp1 = (attackTotal) * Math.pow(defenseTotal, 0.5) * Math.pow(staminaTotal, 0.5);
        BigDecimal result = multiplier.multiply(BigDecimal.valueOf(cp1));
        result = result.divide(BigDecimal.valueOf(10));
        return result.doubleValue();
    }
    public Integer calculateCPAndFloor(BigDecimal multiplier, int defenseTotal, int attackTotal, int staminaTotal){
        return (int) Math.floor(calculateCP(multiplier, defenseTotal,attackTotal,staminaTotal));
    }

}
