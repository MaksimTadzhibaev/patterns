package ru.tadzh.Observer;

import java.util.ArrayList;
import java.util.List;

public class Dishwasher implements Appliances{

    String on; //включена
    String laundry; //стирает
    String rinse; //полоскание
    String spin; //отжим
    String off; //выключена

    public void setCondition(String on, String laundry, String rinse, String spin, String off){
        this.on = on;
        this.laundry = laundry;
        this.rinse = rinse;
        this.spin = spin;
        this.off = off;
        notifyHousemans();
    }

    List<Houseman> appliancesList = new ArrayList<>();

    @Override
    public void addHouseman(Houseman houseman) {
        appliancesList.add(houseman);
    }

    @Override
    public void removeHouseman(Houseman houseman) {
        appliancesList.remove(houseman);
    }

    @Override
    public void notifyHousemans() {
        for (Houseman houseman: appliancesList) {
            houseman.handleEvent(on, laundry, rinse, spin, off);
            
        }
    }
}
