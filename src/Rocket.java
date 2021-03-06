import java.util.ArrayList;
import java.util.Random;

public class Rocket implements SpaceShip {

    private double cost;
    private double weight;
    private double maxWeight;
    private double initialWeight;
    private double explosionFactor;
    private double crashFactor;


    public double calculateExplosionRisk(){
        double calculatedExplosionRisk;
        calculatedExplosionRisk =
                this.getExplosionFactor() * calculateWeightToMaxWeightRatio();
        return calculatedExplosionRisk;
    }

    public double calculateCrashRisk(){
        double calculatedCrashRisk;
        calculatedCrashRisk =
                this.getCrashFactor() * calculateWeightToMaxWeightRatio();
        return calculatedCrashRisk;
    }

    private double calculateWeightToMaxWeightRatio(){
        double weightToMaxWeightRatio =
                this.getWeight() / this.getMaxWeight();
        return weightToMaxWeightRatio;
    }

    public void checkIfTheItemIsTransferable (Item item){
        double maxLoadOfItems = this.getMaxWeight() - this.getInitialWeight();
        if (item.getWeight() > maxLoadOfItems){
            System.out.println ("The item is too heavy to be carried by any rocket of the current type. You cannot transfer it.");
            System.exit(1);
        }
    }

    public double generateRandomNumber(){
        Random rand = new Random();
        double randomNumber = rand.nextDouble();
        return randomNumber;
    }

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
        if (item.getWeight() + this.getWeight() <= this.getMaxWeight()){
            //System.out.println(item.getWeight() + this.getWeight());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double carry(Item item) {
        this.setWeight(this.getWeight() + item.getWeight());
        return this.getWeight();
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

    public double getExplosionFactor(){
        return this.explosionFactor;
    }

    public double getCrashFactor() {
        return crashFactor;
    }

    public double getInitialWeight() {
        return initialWeight;
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

    public void setExplosionFactor(double explosionFactor){
        this.explosionFactor = explosionFactor;
    }

    public void setCrashFactor(double crashFactor) {
        this.crashFactor = crashFactor;
    }

    public void setInitialWeight(double initialWeight) {
        this.initialWeight = initialWeight;
    }
}
