package com.korvai.shyam.korvaigenerator;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by sanjeev on 19/03/15.
 */
public class nadai extends MainActivity {
    public String st;
    public String TAK1;
    public int st14,na,i6,i7,TAK2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nadai);
        String[] nadai = {"CHATUSRA - 4","KANDA - 5", "TISRA - 6", "MISRA - 7","SANKEERNA - 9"};
        ArrayAdapter<String> stringArrayAdapter=
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_spinner_dropdown_item,
                        nadai);
        final Spinner spinner2 =
                (Spinner)  findViewById(R.id.spinner2);
        spinner2.setAdapter(stringArrayAdapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parentView,
                                       View selectedItemView, int position, long id) {
                // Object item = parentView.getItemAtPosition(position);
                //ta2 = getIntent().getStringExtra("ta3");
                //ta4=Integer.parseInt(ta2);
                TAK1 = getIntent().getStringExtra("TAK");
                TAK2=Integer.parseInt(TAK1);
                int j=4;
                //if(spinner2.getSelectedItemPosition()==4) j=5;
                na = spinner2.getSelectedItemPosition()+j;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        Button text = (Button) findViewById(R.id.button2);
        text.setOnClickListener(new View.OnClickListener()

                                {
                                    @Override
                                    public void onClick(View v) {
                                        EditText tx= (EditText)findViewById(R.id.editText2);
                                        st= tx.getText().toString();

                                        st14=Integer.parseInt(st);
                                        Log.d("TAK2",""+TAK2);
                                        Log.d("NA",""+na);
                                        Log.d("st14",""+st);
                                        ArrayList<String> al=new ArrayList<String>(50);

                                        String ans="";
                                        for (int i5 = 5;  i5 < 28; i5++) //Number of chollu
                                            for (int j5 = 0; j5 < 4; j5++) {
                                                i6 = ((TAK2 * na) - ((3 * i5 + 2 * j5) % (TAK2 * na)) + st14) % (TAK2 * na);
                                                i7 = ((TAK2 * na) - ((9 * i5 + 6 * j5) % (TAK2 * na)) + st14) % (TAK2 * na);

Log.d("i6",""+i6);
                                                Log.d("i7",""+i7);
                                                al.add("\n"+i6+"\t"+i7);

                                     //           ans=ans+"\t"+i6+"\t"+i7+"\n";
                                            }
                                       for(String a:al)ans+=a;
                                        setContentView(R.layout.answer);
                                        TextView tf= (TextView) findViewById(R.id.answer);
                                        tf.setText(ans);

                                        //Toast.makeText(getApplicationContext(), "" + i6+"", Toast.LENGTH_SHORT).show();
                                        //Toast.makeText(getApplicationContext(), ""+TAK2+na +st14+ "", Toast.LENGTH_SHORT).show();
                                        //Intent intent=new Intent(MainActivity.this, fragment.class);
                                        //startActivity(intent);
                                    }
                                }
        );

    }
}
