public class Rocket implements SpaceShip {

    private double cost;
    private double weight;
    private double maxWeight;
    private double chanceOfExplosion;
    private double chanceOfCrash;


    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        return false;
    }

    @Override
    public double carry(Item item) {
        return 0;
    }

    public double getCost() {
        return cost;
    }

    public double getWeight() {
        return weight;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public double getChanceOfExplosion() {
        return chanceOfExplosion;
    }

    public double getChanceOfCrash() {
        return chanceOfCrash;
    }

    public void setCost(double cost){
        this.cost = cost;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void setChanceOfExplosion(double chanceOfExplosion) {
        this.chanceOfExplosion = chanceOfExplosion;
    }

    public void setChanceOfCrash(double chanceOfCrash) {
        this.chanceOfCrash = chanceOfCrash;
    }
}
