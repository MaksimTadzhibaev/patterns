package ru.tadzh.Observer;

public interface Appliances {
    void addHouseman(Houseman houseman);
    void removeHouseman(Houseman houseman);
    void notifyHousemans();
}
