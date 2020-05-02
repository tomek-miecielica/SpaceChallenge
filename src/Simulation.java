import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {


    //returns cost of mission in USD mio
    public double calculateBudget(int numOfRockets, double costOfOneRocket){
        double calculatedBudget = numOfRockets * costOfOneRocket;
        return calculatedBudget;
    }

    public double runSimulation (ArrayList<U2> listOfRockets){
        double missionCost;
        int numOfBrokenRockets = 0;
        double costOfRocket = listOfRockets.get(0).getCost();
        for (Rocket rocket :listOfRockets){
            while (!rocket.land() || !rocket.launch()){
                numOfBrokenRockets++;
            }
        }
        int totalNumberOfRocketsUsed = numOfBrokenRockets + listOfRockets.size();
        missionCost = this.calculateBudget(totalNumberOfRocketsUsed, costOfRocket);
        return missionCost;
    }

    public ArrayList<U1> loadU1 (ArrayList<Item> listOfItems){
        ArrayList<U1> listOfU1RocketsNeeded = new ArrayList<U1>();

        listOfU1RocketsNeeded.add(new U1());
        U1 lastRocket =
                listOfU1RocketsNeeded.get(listOfU1RocketsNeeded.size()-1);
        for (Item item : listOfItems){
            if (lastRocket.canCarry(item)){
                lastRocket.carry(item);
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

    public ArrayList<U2> loadU2 (ArrayList<Item> listOfItems){
        ArrayList<U2> listOfU2RocketsNeeded = new ArrayList<U2>();

        listOfU2RocketsNeeded.add(new U2());
        U2 lastRocket =
                listOfU2RocketsNeeded.get(listOfU2RocketsNeeded.size()-1);
        for (Item item : listOfItems){
            if (lastRocket.canCarry(item)){
                lastRocket.carry(item);
            }else{
                listOfU2RocketsNeeded.add(new U2());
                lastRocket =
                        listOfU2RocketsNeeded.get(listOfU2RocketsNeeded.size()-1);
                lastRocket.carry(item);
            }
        }
        System.out.println("Items left: " + listOfItems.size());
        System.out.println("U1 created: " + listOfU2RocketsNeeded.size());
        return listOfU2RocketsNeeded;
    }

    public static void main(String[] args) throws Exception{
        Simulation simulation = new Simulation();
        MissionObjects missionObjects = new MissionObjects();
        File file = new File("/home/tom/Documents/SpaceChallenge/src/phase1.txt");
        missionObjects.loadItems(file, "=");
        simulation.loadU2(missionObjects.loadItems(file, "="));
        double cost = simulation.runSimulation(simulation.loadU2(missionObjects.loadItems(file, "=")));
        System.out.println(cost);
    }

//obiektowosc
    //odpalanie dwoch faz na raz i liczenie dla nich budzetu

}
