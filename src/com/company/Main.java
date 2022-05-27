package com.company;

import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

public class Main {

    public static void DATA(AEROFLOT[] AIR){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < AIR.length; i++){
        System.out.println("Введіть дані " + (i + 1) + "-ого літака!");
        System.out.print("Назва населеного пункта призначення: ");
            AIR[i].CITY = scanner.next();
            while(true) {
                System.out.print("Номер рейса: ");
                AIR[i].NUM = scanner.nextInt();
                if (AIR[i].NUM < 0) {
                    System.out.println("Помилка! Введіть невід'ємне значення!");
                    continue;
                }
                break;
            }
            System.out.print("Тип літака: ");
            AIR[i].TYPE = scanner.next();
        }
    }

    public static void SORT(AEROFLOT[] AIR) {
        // ArrayList list = new ArrayList();
        // for (int i = 0; i < AIR.length; i++) {
        //  list.add(AIR[i].NUM);
        // }
        // Collections.sort(list);
        //System.out.println(list);

        int[] Distance = new int[AIR.length];
        for(int i = 0; i < AIR.length; i++){
            Distance[i] = AIR[i].NUM;
        }
        Arrays.sort(Distance);

        for(int i = 0; i < AIR.length; i++){
            for(int j = 0; j < AIR.length; j++){
                if(AIR[j].NUM == Distance[i]){
                    System.out.println("Літак з номером " + Distance[i] + " та типом " + AIR[j].TYPE + " прилетів у пункт " + AIR[j].CITY);
                    break;
                }
            }
        }
    }

    public static void SHOW(AEROFLOT[] AIR){
        Scanner scanner = new Scanner(System.in);
        boolean turn = false;
        String input_city;
        int selection;
        while(true){
            System.out.println("Введіть населений пункт, щоб отримати номера рейсів і типи літаків: ");
            input_city = scanner.next();
            for(int i = 0; i < AIR.length; i++){
                if(input_city.equals(AIR[i].CITY)){
                    System.out.println("Літак з номером " + AIR[i].NUM + " та типом " + AIR[i].TYPE + " прилетів у пункт " + input_city + ";");
                     turn = true;
                }
            }
            if(!turn){
                System.out.println("В пункт призначення " + input_city + " не прибуло жодного літака!");
            }
            while (true){
                System.out.println("Вказати інший пункт призначення, натисніть 1.");
                System.out.println("Перейти до головного меню, натисніть 2.");
                selection = scanner.nextInt();
                if(selection < 1 || selection > 2){
                    System.out.println("Укажіть вірне значення!");
                    continue;
                }
                break;
            }
            if(selection == 1){
                continue;
            }
            else {
                System.out.println("Виходимо у головне меню!");
                break;
            }
        }
    }

    public static void menu () {
        System.out.println("Меню: ");
        System.out.println("Вказати параметри літаків: 1;");
        System.out.println("Впорядкувати записи за зростанням номеру рейса: 2;");
        System.out.println("Виведення на екран номерів рейсів і типів літаків за пунктом їх призначення: 3;");
        System.out.println("Завершення програми: 4;");
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N, selection;
        while(true){
            System.out.print("Введіть кількість літаків: ");
            N = scanner.nextInt();
            if(N <= 0){
                System.out.println("Невірно вказана кількість, введіть коректне значення!");
                continue;
            }
            break;
        }
        AEROFLOT[] AIR = new AEROFLOT[N];
        for (int i = 0; i < AIR.length; i++){
            AIR[i] = new AEROFLOT();
        }

        while (true){
            System.out.println(" ");
            menu();
            selection = scanner.nextInt();
            switch (selection){
                case 1:
                    DATA(AIR);
                    break;
                case 2:
                    SORT(AIR);
                    break;
                case 3:
                    SHOW(AIR);
                    break;
                case 4:
                    System.out.println("Програму завершено!");
                    System.exit(0);
                default:
                    System.out.println("Введіть вірне значення!");
            }
        }
    }
}
