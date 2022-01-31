package classes;

import classes.*;

public class Company {

    /*
    public void createDefaultCompany() throws MyException {
    }
*/

    private String name="SpaceX";
    private String info="<html>Information about 'SpaceX' company </br>" +
            "Since 2010 provide fast, secure and stable connection to a millions of people </br>" +
            "This telephone company has three tarifs: basic, per second and per minute </br> </html>";

    public String getName() {
        return name;
    }
    public void setName(String newName) throws MyException {
        if(newName == "") {
            throw new MyException("Name can not be empty!");
        }
        name = newName;
    }

    public String getInfo() {
        return info;
    }
    public void setInfo(String newInfo) {
        info = newInfo;
    }

    public String possibleTariffs() {
        return "tarifBasic, tarifPerSecond, tarifPerMinute";
    }
}