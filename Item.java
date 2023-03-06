public class Item { //super class for Drink and Snack
    // data members for name, calories, and item type
    private String name;
    private float calories;
    private String itemType;

    // constructor for the Item class
    public Item(String name, float calories, String itemType) {
        this.name = name;
        this.calories = calories;
        this.itemType = itemType;
    }

    // setters and getters
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }
    public float getCalories() {
        return calories;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
    public String getItemType() {
        return itemType;
    }
}