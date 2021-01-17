package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Treatments t = new Treatments();
        ArrayList<String> t1 = new ArrayList<String>(); // cough ages 2-11
        t1.add("Children's Motrin/Tussin");
        ArrayList<String> t2 = new ArrayList<String>(); // cough ages 12-59
        t2.add("Robitussin/Tussin/Theraflu");
        ArrayList<String> t3 = new ArrayList<String>(); // cough ages 60 +
        t3.add("Delsym/Theraflu");
        ArrayList<String> t4 = new ArrayList<String>(); // breathing problems 2-11
        t4.add("Children's Flonase Sensimist Allergy Relieve Nasal Spray/Equate Nasal Spray");
        ArrayList<String> t5 = new ArrayList<String>(); // breathing problems 12-59
        t5.add("Respitrol/Sterimar Hayfever Nasal Spray");
        ArrayList<String> t6 = new ArrayList<String>(); // breathing problems 60+
        t6.add("Breathe/Ridgecrest Herbals");
        ArrayList<String> t7 = new ArrayList<String>(); // nausea ages 2-11
        t7.add("Emetrol/Dramamine(Kids)/Nauzene");
        ArrayList<String> t8 = new ArrayList<String>(); // nausea ages 12-59
        t8.add("Pepto Bismol/Bonine/Dramamine(Adults)");
        ArrayList<String> t9 = new ArrayList<String>(); // nausea ages 60+
        t9.add("Apoquel/Ondansetron/Alka Seltzer");
        ArrayList<String> t10 = new ArrayList<String>(); // headache ages 2-11
        t10.add("Tylenol/Motrin IB");
        ArrayList<String> t11 = new ArrayList<String>(); // headache ages 12-59
        t11.add("Aspirin/Ibuprofen");
        ArrayList<String> t12 = new ArrayList<String>(); // headache ages 60+
        t12.add("Naproxen/Aleve/Naprosyn");

        t.treat.put("Cough(2yrs-11yrs)",t1);
        t.treat.put("Cough(12yrs-59yrs)",t2);
        t.treat.put("Cough(60+ yrs)",t3);
        t.treat.put("Short-Breath(2yrs-11yrs)",t4);
        t.treat.put("Short-Breath(12yrs-59yrs)",t5);
        t.treat.put("Short-Breath(60+ yrs)",t6);
        t.treat.put("Nausea(2yrs-11yrs)",t7);
        t.treat.put("Nausea(12yrs-59yrs)",t8);
        t.treat.put("Nausea(60+ yrs)",t9);
        t.treat.put("Headache(2yrs-11yrs)",t10);
        t.treat.put("Headache(12yrs-59yrs)",t11);
        t.treat.put("Headache(60+ yrs)",t12);

        System.out.println("What is your name?");
        Scanner sc1 = new Scanner(System.in);
        String input1 = sc1.next();
        System.out.println("What is your age?");
        Scanner sc2 = new Scanner(System.in);
        int input2 = sc2.nextInt();

        Patient pat = new Patient(input1,input2);
        pat.askInfo();
        pat.getAdvice(t);

    }
}
