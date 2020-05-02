import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    public ArrayList<Item> loadItems (File file) throws Exception{
        ArrayList<Item> itemList = new ArrayList<Item>();
        Scanner scanner = new Scanner(file);
        int numberOfItemsToCarry = 0;
        while (scanner.hasNextLine()) {
            String readLine = scanner.nextLine();
            String[] separatedReadLine = readLine.split("=");
            String itemName = separatedReadLine[0];
            int itemWeight = Integer.parseInt(separatedReadLine[1]);
            itemList.add(new Item(itemName, itemWeight));
            //System.out.println("nazwa "+itemList.get(itemList.size()-1).getName()+" waga: "+ itemList.get(itemList.size()-1).getWeight());
            numberOfItemsToCarry++;
        }
        System.out.println(numberOfItemsToCarry);
        System.out.println (itemList.size());

        return itemList;
    }

    public static void main(String[] args) throws Exception{
        Rocket rocket = new Rocket();
        Simulation simulation = new Simulation();
        File file = new File("/home/tom/Documents/SpaceChallenge/src/phase2.txt");
        rocket.loadU1(simulation.loadItems(file));
    }

}
