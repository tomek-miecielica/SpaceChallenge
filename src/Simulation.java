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
            int itemWeight = Integer.parseInt(separatedReadLine[0]);
            itemList.add(new Item(itemName, itemWeight));
            numberOfItemsToCarry++;
        }
        System.out.println(numberOfItemsToCarry);

        return itemList;
    }

    public static void main(String[] args) throws Exception{
        Simulation simulation = new Simulation();
        File file = new File("/home/tom/Documents/SpaceChallenge/src/phase1.txt");
        simulation.loadItems(file);
    }

}
