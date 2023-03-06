import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Vending {
    // data members for the directory and slots arrays
    protected ArrayList<String> directory; //used to locate product i.e Coca-Cola, Coca-Cola, Coca-Cola, Coca-Cola Zero, Pepsi, Pepsi, etc
    protected ArrayList<Queue<Item>> slots; //polymorphism used (Q contains Drinks+Snacks AKA Items)

    // constructor for the Vending class
    public Vending(ArrayList<String> directoryData) {
            directory = new ArrayList<String>();
            slots = new ArrayList<Queue<Item>>();

            loadItem(directoryData);
    }

    // function to load the items into the vending machine
    public void loadItem(ArrayList<String> data) {
        for (String line : data) {
            String[] itemLine = line.split(",");

            // parse the data
            String itemType = itemLine[0].trim();
            String name = itemLine[1].trim();
            float calories = Float.parseFloat(itemLine[2].trim());
            int quantity = Integer.parseInt(itemLine[5].trim());

            //Determine which item it is
            Item item;
            if (itemType.equals("Drink")) {
                float ounces = Float.parseFloat(itemLine[3].trim());
                String type = itemLine[4].trim();
                item = new Drink(name, calories, itemType, ounces, type);
            } else{
                float weight = Float.parseFloat(itemLine[3].trim());
                boolean containsNuts = itemLine[4].trim().equals("true");
                item = new Snack(name, calories, itemType, weight, containsNuts);
            }

            // add the item's name to the directory
            directory.add(name);
            slots.add(loadQueue(quantity, item));
        }
    }

    // Function that unloads an item from the specified slot
    public void unloadItem(int index) {
        if(index < 0 || index >= directory.size()) { //empty Null nada nothing
            return;
        }

        ArrayList<Integer> itemIndexes = findProduct(directory.get(index)); //list of all indexes in slot matching the wanted item

        if(itemIndexes.isEmpty()) //case there is no item to pull from
            return;

        int maxItem = slots.get(index).size();
        int maxIndx = index;
        for(int i = 0; i < itemIndexes.size(); i++) {
            if(slots.get(itemIndexes.get(i)).size() > maxItem){
                maxIndx = i; // found a higher indx
                maxItem = slots.get(itemIndexes.get(i)).size();
            }
        }

        //use logic to check where we are pulling item from in slots
        if(index == maxIndx){ // case where all items size is same. Pull from leftmost slot
            pullLeft(itemIndexes);
        }else{ //case where we found the largest slot for item
            slots.get(maxIndx).poll();
        }
    }

    //unloads items from slots given a inputList of indexes
    public void unloadItems(ArrayList<Integer> inputList) {
        for(int i = 0; i < inputList.size(); i++) {
            unloadItem(inputList.get(i));
        }
    }

    // finds all the indexes in slots which contain the name of the wanted item
    public ArrayList<Integer> findProduct(String name) {
        ArrayList<Integer> indexes = new ArrayList<>();

        // Iterate through the slots of vending machine
        for (int i = 0; i < slots.size(); i++) {
            // Check if the current slot contains the given product
            if (!slots.get(i).isEmpty() && slots.get(i).peek().getName().equals(name)) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Loop through the slots in the vending machine
        for (int i = 0; i < slots.size(); i++) {
            // Skip the slot if it's empty
            if (slots.get(i) == null || slots.get(i).isEmpty()) {
                continue;
            }

            // Append the string representation of the current slot to the string builder
            String itemName = directory.get(i);
            String itemType = slots.get(i).peek().getItemType();
            int itemCount = slots.get(i).size();
            sb.append(itemName + ": " + "(" + itemType + "):" + itemCount + "\n");
        }
        return sb.toString();
    }


    public void displayItems() {
        System.out.print(this.toString());
    }

    //helper function to load item a quantity amount of times into a queue
    private Queue<Item> loadQueue(int quantity, Item item) {
        Queue<Item> q = new LinkedList<>();
        for (int i = 0; i < quantity; i++) {
            q.offer(item);
        }
        return q;
    }

    private void pullLeft(ArrayList<Integer> indxList) {
        for(int i = 0; i < indxList.size(); i++) {
            if(slots.get(indxList.get(i)).isEmpty()) { // find leftmost non-empty slot
                continue;
            }
            else{
                slots.get(indxList.get(i)).poll(); //remove item at the front of the queue
                break;
            }
        }
    }
}