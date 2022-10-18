package pogoeinstein.stats.level;

public class Level {

    private Double level;
    private final static Double maxLevel = 50.0;
    private final static Double minLevel = 1.0;

    public Level(Double level){
        setLevel(level);
    }

    public Double getLevel() {
        return level;
    }

    public void setLevel(Double level) {
        if(level >= maxLevel){
            this.level = maxLevel;
            return;
        }

        if(level <= minLevel){
            this.level = minLevel;
            return;
        }

        this.level = level;
    }

    public Double getMaxLevel() {
        return maxLevel;
    }


    public Double getMinLevel() {
        return minLevel;
    }

    public void changeLevelBy(Double changeBy){
        setLevel(this.level + changeBy);
    }

    public void increaseLevel(){
        changeLevelBy(0.5);
    }

    public void decreaseLevel(){
        changeLevelBy(-0.5);
    }

}
