package levelTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pogoeinstein.stats.level.Level;

public class TestLevel {

    private Level level = null;

    @BeforeEach
    public void setup(){
        level = new Level(40.0);
    }

    @Test
    public void testLevelBounds(){
        level = new Level(55.0);
        Assertions.assertEquals(level.getMaxLevel(), level.getLevel());
    }

    @Test
    public void testIncreaseLevel(){
        level.increaseLevel();
        Assertions.assertEquals(41, level.getLevel());
    }

    @Test
    public void testDecreaseLevel(){
        level.decreaseLevel();
        Assertions.assertEquals(39, level.getLevel());
    }
}
