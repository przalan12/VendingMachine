public class Drink extends Item { // is-a Item
    // data members for ounces and type
    private float ounces;
    private String type; // will be soda, water, other(i.e Chips)

    // constructor for the Drink class. itemType is Drink/Snack
    public Drink(String name, float calories, String itemType, float ounces, String type) {
        super(name, calories, itemType); // call the constructor of the Item class
        this.ounces = ounces;
        this.type = type;
    }

    // setters and getters for data members
    public void setOunces(float ounces) {
        this.ounces = ounces;
    }
    public float getOunces() {
        return ounces;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return  "Drink [ounces=" + ounces + ", type=" + type + ", name=" + super.getName() + ", calories=" + super.getCalories() + ", itemType=" + super.getItemType() + "]";
    }
}