package com.example.hackdavis;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.*;

public class ThirdActivity extends AppCompatActivity {

    HashMap<String, ArrayList<String>> t = new HashMap<String, ArrayList<String>>();
    int age;

    String s = "";
    boolean b = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
      /*ArrayList<String> t1 = new ArrayList<String>(); // cough ages 2-11
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
      t.put("Headache(60+ yrs)",t12);*/
        getData();






        CheckBox cough = (CheckBox)findViewById(R.id.coughCheckBoxBtn);
        cough.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView symptomC = (TextView)findViewById(R.id.CoughText);
                EditText firstNumEditText = (EditText) findViewById(R.id.PatientAgeText);
                age = Integer.parseInt(firstNumEditText.getText().toString());
                s = printFunc(age, "Cough");
                symptomC.setText(s);
            }
        });
        CheckBox breath = (CheckBox)findViewById(R.id.breathingCheckBoxBtn);
        breath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView symptomS = (TextView)findViewById(R.id.BreathText);
                EditText firstNumEditText = (EditText) findViewById(R.id.PatientAgeText);
                age = Integer.parseInt(firstNumEditText.getText().toString());
                s=printFunc(age, "Short-Breath");
                symptomS.setText(s);
            }
        });
        CheckBox nausea = (CheckBox)findViewById(R.id.nauseaCheckBoxBtn);
        nausea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView symptomN = (TextView)findViewById(R.id.NauseaText);
                EditText firstNumEditText = (EditText) findViewById(R.id.PatientAgeText);
                age = Integer.parseInt(firstNumEditText.getText().toString());
                s=printFunc(age, "Nausea");
                symptomN.setText(s);
            }
        });
        CheckBox headache = (CheckBox)findViewById(R.id.headacheCheckBoxBtn);

        headache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView symptomH = (TextView)findViewById(R.id.HeadacheText);
                EditText firstNumEditText = (EditText) findViewById(R.id.PatientAgeText);
                age = Integer.parseInt(firstNumEditText.getText().toString());
                s=printFunc(age, "Headache");
                symptomH.setText(s);
            }
        });

    }
    private void sendData(HashMap<String,ArrayList<String>>a){
        Intent intent = new Intent(this, FourthActivity.class);
        intent.putExtra("map", t);
        startActivity(intent);
    }
    private void getData(){
        Intent intent = getIntent();
        t = (HashMap<String, ArrayList<String>>) intent.getSerializableExtra("map");
    }


    public String printFunc(int age, String r){
        String response = r;
        if (age >= 2 && age <= 11){
            response += "(2yrs-11yrs)";
        }
        if (age >= 12 && age <= 59){
            response += "(12yrs-59yrs)";
        }
        if (age > 60) {
            response += "(60+yrs)";
        }
        String text = " ";
        for(int i = 0; i < t.get(response).size(); i++){
            text += (t.get(response).get(i) + "\n");
        }
        return text;
    }


}
