import java.util.ArrayList;
import java.util.Random;

public class Rocket implements SpaceShip {

    private double cost;
    private double weight;
    private double maxWeight;
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

    public double generateRandomNumber(){
        Random rand = new Random();
        double randomNumber = rand.nextDouble();
        return randomNumber;
    }

    public ArrayList<U1> loadU1 (ArrayList<Item> listOfItems){
        ArrayList<U1> listOfU1RocketsNeeded = new ArrayList<U1>();

        listOfU1RocketsNeeded.add(new U1());
        U1 lastRocket =
                listOfU1RocketsNeeded.get(listOfU1RocketsNeeded.size()-1);
        for (Item item : listOfItems){
            if (lastRocket.canCarry(item)){
                lastRocket.carry(item);
                System.out.println("adding: " + item.getName()+ " waga: " + item.getWeight() + " kg");
                System.out.println("total weight of rocket: " + listOfU1RocketsNeeded.get(listOfU1RocketsNeeded.size()-1).getWeight()+ " / last rocket: "+lastRocket.getWeight());
            }else{
                listOfU1RocketsNeeded.add(new U1());
                lastRocket =
                        listOfU1RocketsNeeded.get(listOfU1RocketsNeeded.size()-1);
                lastRocket.carry(item);
            }
        }
        System.out.println("Items left: " + listOfItems.size());
        System.out.println("U1 created: " + listOfU1RocketsNeeded.size());
        return listOfU1RocketsNeeded;
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
}
