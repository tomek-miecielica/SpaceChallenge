public class Item {

    private String name;
    private int weight;

    public Item (String name, int weight){
        this.setName(name);
        this.setWeight(weight);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


}
