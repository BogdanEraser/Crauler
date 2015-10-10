package WorkWithXML;

/**
 * Created by Bogdan Kukharskiy on 10.10.2015.
 */
public class Component {
    private String name;
    private String unit;
    private int amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Component{" +
                "name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", amount=" + amount +
                '}';
    }
}
