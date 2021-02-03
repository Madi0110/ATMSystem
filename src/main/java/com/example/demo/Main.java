package com.example.demo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;
import java.util.Scanner;
public class Main {


    public static void main(String args[]) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Bank bank = context.getBean("bank", Bank.class);

        Main main = new Main();

        Random rand = new Random();
        Client client = bank.getClients().get(rand.nextInt(bank.getClients().size()));


        int balance, withdraw, deposit;

        Scanner s = new Scanner(System.in);

        while (true) {

            System.out.println("Welcome to ATM " + client.getName() + "!");
            System.out.println("1.Withdraw");
            System.out.println("2.Deposit");
            System.out.println("3.Check Balance");
            System.out.println("4.EXIT");

            System.out.print("Choose the operation you want to perform:");

            int n = s.nextInt();

            switch (n) {

                case 1:


                    if (main.checkPin(client.getPin())) {

                        System.out.print("Enter money to be withdrawn:");

                        withdraw = s.nextInt();

                        if (client.getCash() >= withdraw) {

                            client.setCash(client.getCash() - withdraw);

                            System.out.println("Please collect your money");

                        }

                    } else{
                        System.out.println("Incorrect PIN");
                    }
                    break;

                case 2:

                    if (main.checkPin(client.getPin())) {

                    System.out.print("Enter money to be deposited:");

                    deposit = s.nextInt();


                            client.setCash(client.getCash() + deposit);

                            System.out.println("Your Money has been successfully deposited");

                            System.out.println("");
                        }  else{
                            System.out.println("Incorrect PIN");
                        }

                    break;

                case 3:

                    System.out.println("Balance : " + client.getCash());

                    System.out.println("");

                    break;

                case 4:

                    System.exit(0);

            }

        }

    }

    public boolean checkPin(String pin){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the pin:");
        String pin2 = scan.next();

        if (pin.equals(pin2)){
            return true;
        } else{
            return false;
        }
    }
}
