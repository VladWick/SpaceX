package classes;

import classes.*;

import java.io.Serializable;

public class TarifPerMinute implements Serializable {
    private int numberOfMinutes = 0;
    private int singleMinuteCost = 600;
    private String info= "default";
    private int numberOfSubscribers = 0;
    private String nameOfTariff = "default";

    public String getType() {
        return "per minute";
    }

    public String getNameOfTariff() {
        return nameOfTariff;
    }
    public void setNameOfTariff(String newName) {
        nameOfTariff = newName;
    }

    public String getInfo() {
        return info;
    }
    public void setInfo(String newInfo) {
        info = newInfo;
    }

    public int getSingleMinuteCost() {
        return singleMinuteCost;
    }
    public void setSingleMinuteCost(int newSingleMinuteCost) {
        singleMinuteCost = newSingleMinuteCost;
    }

    public int getNumberOfMinutes() {
        return numberOfMinutes;
    }
    public void setNumberOfMinutes(int newNumberOfMinutes) throws MyException {
        numberOfMinutes = newNumberOfMinutes;
        if (numberOfMinutes < 0) {
            throw new MyException("Number is lower that zero!");
        }
    }
    public int howMuchPerMinute() throws MyException {
        if (singleMinuteCost < 0) {
            throw new MyException("Value is lower than zero!");
        }
        return singleMinuteCost*numberOfMinutes;
    }

    public int getFinalCost() {
        return (singleMinuteCost*numberOfMinutes);
    }

    public int getNumberOfSubscribers() {
        return numberOfSubscribers;
    }
    public void setNumberOfSubscribers(int newNumberOfSubscribers) {
        numberOfSubscribers = newNumberOfSubscribers;
    }
}
