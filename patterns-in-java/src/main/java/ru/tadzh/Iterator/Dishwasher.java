package ru.tadzh.Iterator;

public class Dishwasher implements Collection{
    private String name;
    private  String[]features;


    public Dishwasher(String name, String[] features) {
        this.name = name;
        this.features = features;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getFeatures() {
        return features;
    }

    public void setFeatures(String[] features) {
        this.features = features;
    }

    @Override
    public Iterator getIterator() {
        return new FeaturesIterator();
    }

    private class FeaturesIterator implements Iterator{

        int index;

        @Override
        public boolean hasNext() {
            if (index<features.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            return features[index++];
        }
    }
}
