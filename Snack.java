public class Snack extends Item { // is-a Item
    private float weight;
    private boolean containsNuts;

    // constructor for the Snack class
    public Snack(String name, float calories, String itemType, float weight, boolean containsNuts) {
        super(name, calories, itemType); // call the constructor of the Item class
        this.weight = weight;
        this.containsNuts = containsNuts;
    }

    // setters and getters
    public void setWeight(float weight) {
        this.weight = weight;
    }
    public float getWeight() {
        return weight;
    }

    public void setContainsNuts(boolean containsNuts) {
        this.containsNuts = containsNuts;
    }
    public boolean getContainsNuts() {
        return containsNuts;
    }
    @Override
    public String toString() {
        return "Snack [weight=" + weight + ", containsNuts=" + containsNuts + ", name=" + super.getName() + ", calories="+ super.getCalories() + ", itemType=" + super.getItemType() + "]";
    }
}