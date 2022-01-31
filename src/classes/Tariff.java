package classes;

import java.io.Serializable;

import classes.*;

public class Tariff implements Serializable {
    private String nameOfTariff = "default";
    private int numberOfSubscribers = 0;
    private String info = "default";
    private int finalCost = 1000;


    public String getType() {
        return "basic";
    }

    public String getInfo() {
        return info;
    }
    public void setInfo(String newInfo) {
        info = newInfo;
    }

    public String getNameOfTariff() {
        return nameOfTariff;
    }
    public void setNameOfTariff(String newName) {
        nameOfTariff = newName;
    }

    public int getNumberOfSubscribers() {
        return numberOfSubscribers;
    }
    public void setNumberOfSubscribers(int newNumberOfSubscribers) {
        numberOfSubscribers = newNumberOfSubscribers;
    }

    public int getFinalCost() {
        return (finalCost);
    }
}
