package ru.tadzh.Chain;

abstract class Sheet {

    private Sheet nextSheet;

    public void setNextSheet(Sheet sheet){
        nextSheet = sheet;
    }

    public void print (String text){
       printText(text);
        if(nextSheet !=null){
            nextSheet.print(text);
        }
    }

    abstract void printText(String text);

}
