package sample;

import java.util.Scanner;

public class Tracker {
    Data data = new Data();

    ///////////////////////////////Transaction Adder///////////////////////////////
    public void addTransaction() {
        data.addAmount();
        data.addWhere();
        data.addWhat();
        System.out.println("The transaction has been added to the records");
    }

    ///////////////////////////////Gets Previous Transaction///////////////////////////////
    public void getTransaction() {
        Scanner input = new Scanner(System.in);
        System.out.println("which transaction would you like to see?");
        int transaction = input.nextInt();
        data.getAmountList(transaction);
        data.getWhereList(transaction);
        data.getWhatList(transaction);
    }

    ///////////////////////////////Total Calculator///////////////////////////////
    public void getTotal() {
        data.calcTotal();
    }

    ///////////////////////////////File Reader/Writer///////////////////////////////
    public void readData() {
        data.readFile();
    }

    public void writeData() {
        data.writeFile();
    }

    ///////////////////////////////User Interface///////////////////////////////
    public void userInterface() {
        Scanner input = new Scanner(System.in);
        String response = "default";
        while (!"save".equals(response.toLowerCase())) {
            readData();
            System.out.println("What would you like to do? (Add Transaction, Previous Transaction, Get Total, Save)");
            response = input.nextLine();
            if (response.toLowerCase().equals("add transaction")) {
                addTransaction();
            } else if (response.toLowerCase().equals("previous transaction")) {
                getTransaction();
            } else if (response.toLowerCase().equals("save")) {
                //this prevents from asking what to do again
            } else if (response.toLowerCase().equals("get total")) {
                getTotal();
            } else {
                System.out.println("Please enter one of the specified responses.");
            }
        }
        System.out.println("Thank you for using finance Tracker.");
        writeData();
    }
}
