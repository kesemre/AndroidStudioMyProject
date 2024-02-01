package com.example.sixminutewalktest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sixminutewalktest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private Intent intent;
    private Button button;
    private TextView rangeT,ageT,weightT,lenghtT;
    protected int range,age,weight,lenght;
    public RadioGroup radioGroup;
    protected RadioButton malebutton,femaleButton;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        this.button = binding.CalcButton;
        this.rangeT = binding.Mesafe;
        this.ageT = binding.Age;
        this.weightT = binding.weight;
        this.lenghtT = binding.length;
        this.malebutton = binding.radioButton4;
        this.femaleButton = binding.radioButton3;
        this.radioGroup = binding.radioGroup;
        intent = new Intent(this, resultMenu.class);
    }
    public void result(View view){
        if(rangeT.getText().toString().equals("") || ageT.getText().toString().equals("")||weightT.getText().toString().equals("") ){
            Toast toast = Toast.makeText(this,"Lütfen bütün değerleri giriniz",Toast.LENGTH_LONG);
            toast.show();
        }
        else{
            range = Integer.valueOf(rangeT.getText().toString());
            age = Integer.valueOf(ageT.getText().toString());
            weight = Integer.valueOf(weightT.getText().toString());
            lenght = Integer.valueOf(lenghtT.getText().toString());
            intent.putExtra("mesafe",range);
            intent.putExtra("age",age);
            intent.putExtra("weight",weight);
            intent.putExtra("length",lenght);

            malebutton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    intent.putExtra("sex",true);
                }
            });
            femaleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    intent.putExtra("sex",false);
                }
            });

            startActivity(intent);
        }
    }
}