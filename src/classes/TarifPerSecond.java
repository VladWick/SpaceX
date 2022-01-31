package classes;

import classes.*;

import java.io.Serializable;

public class TarifPerSecond implements Serializable {
    private int numberOfSeconds = 0;
    private int singleSecondCost = 11;
    private String info = "default";
    private int numberOfSubscribers = 0;
    private String nameOfTariff = "default";

    public String getType() {
        return "per second";
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

    public int getSingleSecondCost() {
        return singleSecondCost;
    }
    public void setSingleSecondCost(int newSingleSecondCost) {
        singleSecondCost = newSingleSecondCost;
    }

    public int getNumberOfSeconds() {
        return numberOfSeconds;
    }
    public void setNumberOfSeconds(int newNumberOfSeconds) throws MyException {
        numberOfSeconds = newNumberOfSeconds;
        if (newNumberOfSeconds < 0) {
            throw new MyException("Value is lower than zero!");
        }
    }

    public int singleSecondCost() throws MyException {
        if (singleSecondCost <= 0) {
            throw new MyException("Value is lower than zero!");
        }
        return singleSecondCost;
    }

    public int getFinalCost() {
        return (singleSecondCost*numberOfSeconds);
    }

    public int getNumberOfSubscribers() {
        return numberOfSubscribers;
    }
    public void setNumberOfSubscribers(int newNumberOfSubscribers) {
        numberOfSubscribers = newNumberOfSubscribers;
    }
}
