package com.example.taruc.lab32inputcontrols;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;
    private double basicPremium;
    private double a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Link UI to program
        spinnerAge = (Spinner) findViewById(R.id.spinnerAge);
        spinnerAge.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.age, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setAdapter(adapter);


        radioGroupGender =(RadioGroup)findViewById(R.id.radioGroupGender);
        radioButtonMale = (RadioButton) findViewById(R.id.radioButtonMale);
        radioButtonFemale = (RadioButton) findViewById(R.id.radioButtonFemale);




        checkBoxSmoker = (CheckBox) findViewById(R.id.checkBoxSmoker);
        textViewPremium = (TextView) findViewById(R.id.textViewPremium);


    }
    public void calculate(View view){
        int ageIndex = spinnerAge.getSelectedItemPosition();

        //Identify radio button selected by user
        int gender = radioGroupGender.getCheckedRadioButtonId();
        boolean smoker = checkBoxSmoker.isChecked();

        if(ageIndex==0){
            textViewPremium.setText(getResources().getString(R.string.premium)+" "+basicPremium);
        }
        else if(ageIndex==1){
            textViewPremium.setText(getResources().getString(R.string.premium)+" "+basicPremium);
        }
        else if(gender == R.id.radioButtonMale && ageIndex==2){
            textViewPremium.setText(getResources().getString(R.string.premium)+" "+(basicPremium+50));
        }
        else if(gender == R.id.radioButtonMale && ageIndex==3 && smoker)
            textViewPremium.setText(getResources().getString(R.string.premium)+" "+(basicPremium+100+100));
        else if(gender == R.id.radioButtonMale && ageIndex==4 && smoker)
            textViewPremium.setText(getResources().getString(R.string.premium)+" "+(basicPremium+100+120));
        else if(gender == R.id.radioButtonMale && ageIndex==5 && smoker)
            textViewPremium.setText(getResources().getString(R.string.premium)+" "+(basicPremium+50+150));
        else if(gender == R.id.radioButtonMale && ageIndex==6 && smoker)
            textViewPremium.setText(getResources().getString(R.string.premium)+" "+(basicPremium+250));
        else if(gender == R.id.radioButtonMale && ageIndex==7 && smoker)
            textViewPremium.setText(getResources().getString(R.string.premium)+" "+(basicPremium+250));
    }
    public void reset(View view){
        spinnerAge.setSelection(0);
        checkBoxSmoker.setChecked(false);
        radioButtonFemale.setChecked(false);
        radioButtonMale.setChecked(false);
        textViewPremium.setText(getResources().getString(R.string.premium));
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //TODO: calculate basic premium according to age group
        switch (position) {
            case 0:
                basicPremium = 50;
                break;
            case 1:
                basicPremium = 55;
                break;
            case 2:
                basicPremium = 60;
                break;
            case 3:
                basicPremium = 70;
                break;
            case 4:
                basicPremium = 120;
                break;
            case 5:
                basicPremium = 160;
                break;
            case 6:
                basicPremium = 200;
                break;
            case 7:
                basicPremium = 250;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
