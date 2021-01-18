package com.example.hackdavis;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    HashMap<String, ArrayList<String>> t = new HashMap<String, ArrayList<String>>();
    HashMap<String, ArrayList<String>> h = new HashMap<String, ArrayList<String>>();
    boolean b = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        t.put("Cough(2yrs-11yrs)",t1);
        t.put("Cough(12yrs-59yrs)",t2);
        t.put("Cough(60+ yrs)",t3);
        t.put("Short-Breath(2yrs-11yrs)",t4);
        t.put("Short-Breath(12yrs-59yrs)",t5);
        t.put("Short-Breath(60+ yrs)",t6);
        t.put("Nausea(2yrs-11yrs)",t7);
        t.put("Nausea(12yrs-59yrs)",t8);
        t.put("Nausea(60+ yrs)",t9);
        t.put("Headache(2yrs-11yrs)",t10);
        t.put("Headache(12yrs-59yrs)",t11);
        t.put("Headache(60+ yrs)",t12);
        h=t;
        Button switchToFourthActivity = (Button)findViewById(R.id.DoctorBtn);
        switchToFourthActivity.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                b = true;
                switchActivitiesD();
            }
        });
        Button switchToThirdActivity = (Button)findViewById(R.id.PatientBtn);
        switchToThirdActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if(b==true){
                try {
                    getData();
                    sendData(t);
                } catch(Exception e){

                    sendData(h);
                }
                  /*String text = " ";
                  for(String h: t.keySet()) {
                      for (int i = 0; i < t.get(h).size(); i++) {
                          text += (h + ": " + t.get(h).get(i) + "\n");
                      }
                  }*/
                //System.out.println(text);
                //}

            }
        });


    }

    private void switchActivities() {
        Intent switchActivityIntent1 = new Intent(this, ThirdActivity.class);
        startActivity(switchActivityIntent1);
    }
    private void switchActivitiesD() {
        Intent switchActivityIntent = new Intent(this, FourthActivity.class);
        startActivity(switchActivityIntent);
    }
    private void sendData(HashMap<String, ArrayList<String>> a){
        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra("map", a);
        startActivity(intent);
    }

    private void getData(){
        Intent intent = getIntent();
        t = (HashMap<String, ArrayList<String>>) intent.getSerializableExtra("map");
        b = (Boolean)intent.getSerializableExtra("bool");
    }
}
