package classes;

import classes.*;

import java.io.Serializable;

public class Subscriber implements Serializable {
    private String fullName;
    private String phoneNumber;
    private String moneyLeft;

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String newName) throws MyException {
        if (newName == "") {
            throw new MyException("Name can not be empty!");
        }
        fullName = newName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String newNumber) {
        phoneNumber = newNumber;
    }

    public String getMoneyLeft() {
        return moneyLeft;
    }
    public void setNewMoneyLeft(String newMoneyLeft){
        moneyLeft = newMoneyLeft;
    }
}
