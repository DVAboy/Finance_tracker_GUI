package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {
    ArrayList<Double> amountList = new ArrayList<>();
    ArrayList<String> whereList = new ArrayList<>();
    ArrayList<String> whatList = new ArrayList<>();

    ///////////////////////////////Add Functions/////////////////////////////////////
    public void addAmount() {
        System.out.print("enter the amount spent.");
        Scanner input = new Scanner(System.in);
        amountList.add(input.nextDouble());
    }

    public void addWhere() {
        System.out.print("enter where the transaction was held.");
        Scanner input = new Scanner(System.in);
        whereList.add(input.nextLine());
    }

    public void addWhat() {
        System.out.print("enter what was purchased");
        Scanner input = new Scanner(System.in);
        whatList.add(input.nextLine());
    }

    ///////////////////////////////Get Functions///////////////////////////////
    public void getAmountList(int transaction) {
        Double amount = amountList.get(transaction);
        System.out.print("$" + amount + ", ");
    }

    public void getWhereList(int transaction) {
        String where = whereList.get(transaction);
        System.out.print(where + ", ");
    }

    public void getWhatList(int transaction) {
        String what = whatList.get(transaction);
        System.out.println(what + ", ");
    }

    ///////////////////////////////Calculator///////////////////////////////
    public void calcTotal() {
        Double total = 0.0;
        for (int x = 0; x < amountList.size(); x++) {
            total += amountList.get(x);
        }
        System.out.printf("Your total amount spent was $%4.2f", total);
        System.out.println(" ");
    }

    ///////////////////////////////File Reader///////////////////////////////
    public void readFile() {
        String fileName = "StoredData.txt";
        String line = null;
        int l = 1;
        String[] vars;
        String temp;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                temp = line.substring(1, line.length() - 1);
                vars = temp.split(", ");
                switch (l++) {
                    case 1:
                        for (int o = 0; o < vars.length; o++) {
                            amountList.add(Double.parseDouble(vars[o]));
                        }
                        break;
                    case 2:
                        for (int o = 0; o < vars.length; o++) {
                            whereList.add(vars[o]);
                        }
                        break;
                    case 3:
                        for (int o = 0; o < vars.length; o++) {
                            whatList.add(vars[o]);
                        }
                        break;
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }

    ///////////////////////////////File Writer///////////////////////////////
    public void writeFile() {
        String fileName = "StoredData.txt";

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            fileWriter.flush();

            bufferedWriter.write(String.valueOf(amountList));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(whereList));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(whatList));

            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file '" + fileName + "'");
        }
    }
}
