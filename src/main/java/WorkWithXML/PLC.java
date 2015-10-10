package WorkWithXML;

import java.util.ArrayList;

/**
 * Created by Bogdan Kukharskiy on 10.10.2015.
 */
public class PLC {
    private String plcType;
    private String plcModelName;
    private boolean isRedundable;
    private ArrayList<Component> componentList;

    public String getPlcType() {
        return plcType;
    }

    public void setPlcType(String plcType) {
        this.plcType = plcType;
    }

    public String getPlcModelName() {
        return plcModelName;
    }

    public void setPlcModelName(String plcModelName) {
        this.plcModelName = plcModelName;
    }

    public boolean isRedundable() {
        return isRedundable;
    }

    public void setIsRedundable(boolean isRedundable) {
        this.isRedundable = isRedundable;
    }

    public ArrayList<Component> getComponentList() {
        return componentList;
    }

    public void setComponentList(ArrayList<Component> componentList) {
        this.componentList = componentList;
    }

    @Override
    public String toString() {
        return "PLC{" +
                "plcType='" + plcType + '\'' +
                ", plcModelName='" + plcModelName + '\'' +
                ", isRedundable=" + isRedundable +
                ", componentList=" + componentList +
                '}';
    }
}
