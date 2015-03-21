package com.korvai.shyam.korvaigenerator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by sanjeev on 19/03/15.
 */
public class jaathi extends MainActivity {
    public int ja;
    public String ta2;
    public int ta4;
    MainActivity obj=new MainActivity();
    public int[][] talamAksharam=new int[7][5];




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jaathi);
        String[] jaathi = { "CHATUSRA - 4", "TISRA - 6", "MISRA - 7","KANDA - 5","SANKEERNA - 9"};
        for(int i1=0;i1<7;i1++)
        {


                talamAksharam[i1] = new int[5];

        }
        talamAksharam[0][0] = 14;
        talamAksharam[0][1] = 11;
        talamAksharam[0][2] = 23;
        talamAksharam[0][3] = 17;
        talamAksharam[0][4] = 29;

        talamAksharam[1][0] = 10;
        talamAksharam[1][1] = 8;
        talamAksharam[1][2] = 16;
        talamAksharam[1][3] = 12;
        talamAksharam[1][4] = 20;

        talamAksharam[2][0] = 6;
        talamAksharam[2][1] = 5;
        talamAksharam[2][2] = 9;
        talamAksharam[2][3] = 7;
        talamAksharam[2][4] = 11;

        talamAksharam[3][0] = 7;
        talamAksharam[3][1] = 6;
        talamAksharam[3][2] = 10;
        talamAksharam[3][3] = 8;
        talamAksharam[3][4] = 12;

        talamAksharam[4][0] = 12;
        talamAksharam[4][1] = 10;
        talamAksharam[4][2] = 18;
        talamAksharam[4][3] = 14;
        talamAksharam[4][4] = 22;

        talamAksharam[5][0] = 8;
        talamAksharam[5][1] = 7;
        talamAksharam[5][2] = 11;
        talamAksharam[5][3] = 9;
        talamAksharam[5][4] = 13;

        talamAksharam[6][0] = 4;
        talamAksharam[6][1] = 3;
        talamAksharam[6][2] = 7;
        talamAksharam[6][3] = 5;
        talamAksharam[6][4] = 9;
        ArrayAdapter<String> stringArrayAdapter=
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_spinner_dropdown_item,
                        jaathi);
        final Spinner spinner1 =
                (Spinner)  findViewById(R.id.spinner1);
        spinner1.setAdapter(stringArrayAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parentView,
                                       View selectedItemView, int position, long id) {
                // Object item = parentView.getItemAtPosition(position);
                ta2 = getIntent().getStringExtra("ta3");
                ta4=Integer.parseInt(ta2);

                ja = spinner1.getSelectedItemPosition();
                Toast.makeText(getApplicationContext(), "" + ta4 + ja+talamAksharam[ta4][ja]+"", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
       Button text = (Button) findViewById(R.id.button1);
        text.setOnClickListener(new View.OnClickListener()

                                {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent=new Intent(jaathi.this, nadai.class);
                                        intent.putExtra("TAK", Integer.toString(talamAksharam[ta4][ja]));
                                        startActivity(intent);
                                    }
                                }
        );

    }
}
