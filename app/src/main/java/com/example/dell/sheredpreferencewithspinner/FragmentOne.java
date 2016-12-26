package com.example.dell.sheredpreferencewithspinner;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;

import static android.R.layout.simple_spinner_item;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment implements AdapterView.OnItemSelectedListener {
    EditText et1, et2, et3;
    Button b1;
    Spinner spinner;
    int s = 0;
    //    ArrayList<String> arrayList = new ArrayList<String>();
    String[] str = {"Select item to Modify","Name","Subject","Email" };

    public FragmentOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ragment_one, container, false);
        et1 = (EditText) v.findViewById(R.id.editetxt1);
        et2 = (EditText) v.findViewById(R.id.editetxt2);
        et3 = (EditText) v.findViewById(R.id.editetxt3);
        b1 = (Button) v.findViewById(R.id.button1);

        spinner = (Spinner) v.findViewById(R.id.spinner);
        // spinner.OnItemClickListener(getActivity());
//       ArrayList<String> arrayList = new ArrayList<String>();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, str);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 s = spinner.getSelectedItemPosition();
               // Toast.makeText(getActivity(), ""+s, Toast.LENGTH_SHORT).show();
                switch (s)
                {

                    case 1: et1.setText("");
                            et1.requestFocus();
                            SharedPreferences sp = getActivity().getSharedPreferences("credit",0);
                            SharedPreferences.Editor editor = sp.edit();
                            editor.putString("name",et1.getText().toString());

                        break;
                    case 2: et2.setText("");
                            et2.requestFocus();
                            SharedPreferences sp1 = getActivity().getSharedPreferences("credit",0);
                            SharedPreferences.Editor editor1 = sp1.edit();
                            editor1.putString("subject",et2.getText().toString());

                        break;
                    case 3: et3.setText("");
                            et3.requestFocus();
                            SharedPreferences sp2 = getActivity().getSharedPreferences("credit",0);
                            SharedPreferences.Editor editor2 = sp2.edit();
                            editor2.putString("email",et3.getText().toString());

                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getActivity().getSharedPreferences("credit", 0);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("name", et1.getText().toString());
                editor.putString("subject", et2.getText().toString());
                editor.putString("email", et3.getText().toString());
                editor.commit();

                String value1 = sp.getString("name",null);
                Toast.makeText(getActivity(), ""+value1, Toast.LENGTH_SHORT).show();
                String value2 = sp.getString("subject",null);
                Toast.makeText(getActivity(), ""+value2, Toast.LENGTH_SHORT).show();
                String value3 = sp.getString("email",null);
                Toast.makeText(getActivity(), ""+value3, Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}