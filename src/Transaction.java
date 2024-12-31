package src;

import java.text.SimpleDateFormat;
import java.util.Date;

class Transactions{
    private String type;
    private double amount;
    private String date;
    private String description;

    public Transactions(String type, double amount, String description){
        this.type = type;
        this.amount = amount;
        this.description = description;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.date = formatter.format(new Date());
    }

    @Override
    public String toString(){
        return "Date: " + date + "\t" + "Type: " + type + "\t" + "Amount: " + amount + "\t" + "Description: " + description;
    }

}