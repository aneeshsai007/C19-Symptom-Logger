package com.company;
import java.util.*;
import java.util.Scanner;
public class Patient {
    public String name;
    public int age;
    public ArrayList<String> h = new ArrayList<String>();
    public Patient(String n, int a){
        name = n;
        age = a;
    }
    public void askInfo(){
        System.out.println("Welcome to C19 Symptom Logger. Please read the following symptoms:");
        System.out.println("Cough, Short-Breath, Nausea, Headache");
        System.out.println("How many of the symptoms do you have?");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        String input1;
        String input2;
        for (int i = 0; i < input; i++){
            System.out.println("What is your symptom?");
            Scanner sc1 = new Scanner(System.in);
            input1 = sc1.next();
            if (age >= 2 && age <= 11){
                input1 += "(2yrs-11yrs)";
            }
            if (age >= 12 && age <= 59){
                input1 += "(12yrs-59yrs)";
            }
            if (age > 60){
                input1 += "(60+yrs)";
            }
            h.add(input1); // storing all the patient's symptoms in h
        }
    }
    public void getAdvice(Treatments t){
        for (int i = 0; i < h.size(); i++){
            System.out.println("For the symptom, " + h.get(i) + ": ");
            System.out.println("These are the recommended medications: ");
            for (int j = 0; j < t.treat.get(h.get(i)).size();j++){
                System.out.println(t.treat.get(h.get(i)).get(j));
            }
            System.out.println();
        }
    }
}
