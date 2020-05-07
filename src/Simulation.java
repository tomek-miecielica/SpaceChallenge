import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {


    //returns cost of mission in USD mio
    public double calculateBudget(int numOfRockets, double costOfOneRocket){
        double calculatedBudget = numOfRockets * costOfOneRocket;
        return calculatedBudget;
    }

    public double runSimulationU2 (ArrayList<U2> listOfRockets){
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
    public double runSimulationU1 (ArrayList<U1> listOfRockets){
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
    //create a list of rockets needed to transport things in array list of Items
    public ArrayList<U1> loadU1 (ArrayList<Item> listOfItems){
        ArrayList<U1> listOfU1RocketsNeeded = new ArrayList<U1>();

        listOfU1RocketsNeeded.add(new U1());
        U1 lastRocket =
                listOfU1RocketsNeeded.get(listOfU1RocketsNeeded.size()-1);
        for (Item item : listOfItems){
            lastRocket.checkIfTheItemIsTransferable(item);
            if (lastRocket.canCarry(item)){
                lastRocket.carry(item);
            }else{
                listOfU1RocketsNeeded.add(new U1());
                lastRocket =
                        listOfU1RocketsNeeded.get(listOfU1RocketsNeeded.size()-1);
                lastRocket.carry(item);
            }
        }
        return listOfU1RocketsNeeded;
    }

    //create a list of rockets needed to transport things in array list of Items
    public ArrayList<U2> loadU2 (ArrayList<Item> listOfItems){
        ArrayList<U2> listOfU2RocketsNeeded = new ArrayList<U2>();

        listOfU2RocketsNeeded.add(new U2());
        U2 lastRocket =
                listOfU2RocketsNeeded.get(listOfU2RocketsNeeded.size()-1);
        for (Item item : listOfItems){
            lastRocket.checkIfTheItemIsTransferable(item);
            if (lastRocket.canCarry(item)){
                lastRocket.carry(item);
            }else{
                listOfU2RocketsNeeded.add(new U2());
                lastRocket =
                        listOfU2RocketsNeeded.get(listOfU2RocketsNeeded.size()-1);
                lastRocket.carry(item);
            }
        }
        return listOfU2RocketsNeeded;
    }

    public static void main(String[] args) throws Exception{
        double costU1 = 0;
        double costU2 = 0;
        for (int i = 0; i < 2; i++){
            Simulation simulation = new Simulation();
            MissionObjects missionObjects = new MissionObjects();
            File file = missionObjects.readFilesIntoList()[i];
            missionObjects.loadItems(file, "=");
            simulation.loadU2(missionObjects.loadItems(file, "="));
            simulation.loadU1(missionObjects.loadItems(file, "="));
            costU1 = costU1 + simulation.runSimulationU1(simulation.loadU1(missionObjects.loadItems(file, "=")));
            costU2 = costU2 + simulation.runSimulationU2(simulation.loadU2(missionObjects.loadItems(file, "=")));
        }

        System.out.println("The cost of sending U1 rockets is : " + costU1);
        System.out.println("The cost of sending U2 rockets is : " + costU2);

    }

    // ww rocket metoda loadRocket ktorej robimy override w U1 oraz U2 podmieniajac tylko typ inputu i outputu
    // funkcja main jest brzydka, wywalic to do metody
    //obiektowosc - duplikacja kodu w metodach ktore biora inny parametr (u1, u2) i zwracja inny rezultat (u1,u2)
    //czytanie plikow do array i robienie tego w petli dodac do missionobjects
    //odpalanie dwoch faz na raz i liczenie dla nich budzetu

}
