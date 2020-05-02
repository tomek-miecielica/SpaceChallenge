import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MissionObjects {

    public ArrayList<Item> loadItems (File file, String separator) throws Exception{
        MissionObjects objectsNeeded = new MissionObjects();
        ArrayList<Item> itemList = new ArrayList<Item>();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String[] separatedReadLine
                    = objectsNeeded.defineItemParameters(scanner, separator);
            String itemName = separatedReadLine[0];
            int itemWeight = Integer.parseInt(separatedReadLine[1]);
            itemList.add(new Item(itemName, itemWeight));
        }
        return itemList;
    }

    public String[] defineItemParameters (Scanner scanner, String separator){
        String readLine = scanner.nextLine();
        String[] separatedReadLine = readLine.split(separator);
        return separatedReadLine;
    }
}
