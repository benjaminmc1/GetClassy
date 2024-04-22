public class Product {
    private String name;
    private String description;
    private String ID;
    private double cost;

    public Product(String name, String description, String ID, double cost) {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getID() {
        return ID;
    }

    public double getCost() {
        return cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String toCSVDataRecord() {
        return name + ", " + description + ", " + ID + ", " + cost;
    }
}