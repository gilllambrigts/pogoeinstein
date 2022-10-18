package pogoeinstein.stats.combatPower;

import java.math.BigDecimal;

public class CombatPower {
    private Integer value;
    private BigDecimal multiplier;
    public CombatPower(Integer value, BigDecimal multiplier){
        setValue(value);
        setMultiplier(multiplier);
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public BigDecimal getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(BigDecimal multiplier) {
        this.multiplier = multiplier;
    }
}
