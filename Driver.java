import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) throws FileNotFoundException {
        /*
         TODO Auto-generated method stub
        load data from file
        */
        DataFile myData = new DataFile("src/directory.txt", "src/input.txt");

        //initialize Vending machine with loaded data
        ArrayList <String> myVending = myData.loadDirectory();
        ArrayList <Integer> mySelections = myData.loadSampleInput();

        Vending myMachine = new Vending(myVending);
        // Test line to show items before removing initially
         System.out.println("Items originally there:");
         myMachine.displayItems(); //debug helper function, REALLY NEEDS toString()
         System.out.println("______________________________");
        //remove items
        // System.out.println("Items removed final count: ");
        myMachine.unloadItems(mySelections);

        //Final output to display after removing
        myMachine.displayItems(); //debug helper function, REALLY NEEDS toString()


        System.out.println("-----EXTRA CREDIT EXTRA CREDIT EXTRA CREDIT EXTRA CREDIT EXTRA CREDIT EXTRA CREDIT EXTRA CREDIT------");

        DataFile dataFile = new DataFile("src/directory.txt", "src/input.txt"); // read files
        ArrayList<Integer> inputData = dataFile.loadSampleInput(); // load input
        ArrayList<String> directoryData = dataFile.loadDirectory(); // load directory
        Vending vending = new Vending(directoryData); //Construct Vending Object

        //Adding items to the vending machine
        String item1 = "Drink, Diet-Pepper, 120, 16, soda, 3";
        String item2 = "Drink, Pepsi, 120, 16, soda, 7";
        String item3 = "Snack, Candy, 50, 4, true, 8";
        String item4 = "Truck, Honda, 50, 4, true, 8,9,11,thisisbadcodeinput!"; //bad input. Skip over this
        ArrayList<String> resList = new ArrayList<>();
        resList.add(item1); resList.add(item2); resList.add(item3); resList.add(item4); //add them to my list
        vending.loadItem(resList);
        vending.displayItems();

        System.out.println("______________________________");

        //Pulling item from vending machine
        vending.unloadItem(-1); //edge case. Pull nothing.
        vending.unloadItem(100);//edge case. Pull nothing.
        ArrayList<Integer> inputList = new ArrayList<>(Arrays.asList(3,3,3,6,6,10000,-123,2,5,5)); // Acts as inputList for vending machine.
        vending.unloadItems(inputList);
        vending.displayItems();

        System.out.println("______________________________");

        //Check validity
        String myResult = vending.toString();
        StringBuilder solution = new StringBuilder();

        Scanner scanner = new Scanner(new File("src/results.txt"));
        while(scanner.hasNextLine()) {
            solution.append(scanner.nextLine() + "\n");
        }

        System.out.print("Checking validity of results: " + myResult.equals(solution.toString()));

        /*****************/
        // Above DisplayItems() call is fine, but the Vending machine's deconstructor
        // should call that function since it's the LAST operation. Notice it could be
        // done with a helper function that USES the toString()
        // We will NOT call DisplayItems() in testing
        /*****************/

    }

}