import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class DataFile {
    // private data members
    private String directoryFilename; //directory of items in the vending machine
    private String inputFilename; //used to simulate human input

    // constructor to initialize the DataFile
    public DataFile(String directoryFilename, String inputFilename) {
        this.directoryFilename = directoryFilename;
        this.inputFilename = inputFilename;
    }

    //reads each line from “directory.txt” as a simple String,
    // places that dat into a ArrayList of Strings to be parsed later in Vending Machine
//            ["Drink, Coca-Cola, 120, 16, soda, 2",
//            "Drink, Coca-Cola, 120, 16, soda, 4",
//            "Drink, Coca-Cola, 120, 16, soda, 1",
//            "Snack, Chips, 220, 4, false, 8"]
    public ArrayList<String> loadDirectory() {
        int i = 0;
        ArrayList<String> directoryList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(directoryFilename));
            while (scanner.hasNextLine()) {
                directoryList.add(scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Error reading file in loadDirectory(): " + this.directoryFilename);
        }
        return directoryList;
    }
    //return an ArrayList of Integers from the input.txt file to be used later
    public ArrayList<Integer> loadSampleInput() {
        ArrayList<Integer> inputList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(inputFilename))) {
            while (scanner.hasNextLine()) {
                inputList.add(scanner.nextInt());
            }
        } catch (IOException e) {
            System.out.println("Error reading input file: " + this.inputFilename);
        }
        return inputList;
    }

}