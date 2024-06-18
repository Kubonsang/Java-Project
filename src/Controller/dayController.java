package Controller;

import Model.dayInfo;
import Model.dayInfoLogic;

import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class dayController {

    private dayInfoLogic Logic;

    public dayController() {
        Logic = new dayInfoLogic();
    }


    public Vector<dayInfo> getList(int comparator) throws Exception {
        Vector<dayInfo> Days = Logic.getList(comparator);
        if(Days.isEmpty()){
            throw new Exception("Empty List!");
        }
        return Days;
    }

    public void setDateInfo(int day, int month, int year) {}


}


