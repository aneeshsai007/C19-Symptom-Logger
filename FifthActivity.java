package com.example.hackdavis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FifthActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    String h;
    String sym;
    String newS;
    String a;
    Spinner spinnera;
    Spinner spinner;
    HashMap<String, ArrayList<String>> t = new HashMap<String, ArrayList<String>>();
    boolean b = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        getData();
        spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Symptoms, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        h = spinner.getSelectedItem().toString();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {




                h = parent.getItemAtPosition(position).toString();
                h = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        h = spinner.getSelectedItem().toString();
        //ba = spinner.getSelectedItem().toString();
        sym = h;
        //System.out.println(h + "\n" + sym);

        //AGES
        spinnera = (Spinner) findViewById(R.id.spinner2);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adaptera = ArrayAdapter.createFromResource(this,
                R.array.Age, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adaptera.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnera.setAdapter(adaptera);
        a = spinnera.getSelectedItem().toString();
        spinnera.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                a = parent.getItemAtPosition(position).toString();
                a = spinnera.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //a = spinnera.getSelectedItem().toString();
        //ab = spinnera.getSelectedItem().toString();
//sym+=a;

        if (spinnera.getSelectedItem().toString().contains("11")) {
            sym += "(2yrs-11yrs)";
        } else if (spinnera.getSelectedItem().toString().contains("12")) {
            sym += "(12yrs-59yrs)";
        } else if (spinnera.getSelectedItem().toString().contains("60")) {
            sym += ("60+ yrs");
        }

        Button add = (Button) findViewById(R.id.Add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText NewsymEditText = (EditText) findViewById(R.id.NewT);
                newS = NewsymEditText.getText().toString();
                String text = "";
                for (String h : t.keySet()) {
                    for (int i = 0; i < t.get(h).size(); i++) {
                        text += (h + ": " + t.get(h).get(i) + "\n");
                    }
                }
                t.get(sym).add(newS);
            }
        });
        Button send = (Button) findViewById(R.id.Sen);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = " ";
                for (String h : t.keySet()) {
                    for (int i = 0; i < t.get(h).size(); i++) {
                        text += (h + ": " + t.get(h).get(i) + "\n");
                    }
                }
                sendData(t);
            }
        });
    }

    private void getData() {
        Intent intent = getIntent();
        t = (HashMap<String, ArrayList<String>>) intent.getSerializableExtra("map1");

    }

    private void sendData(HashMap<String, ArrayList<String>> a) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("map", t);
        intent.putExtra("bool", b);
        startActivity(intent);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String h = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), h, Toast.LENGTH_SHORT);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}


