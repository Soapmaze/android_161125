package com.example.soapmaze.chooseanimal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Choose_Animal extends AppCompatActivity {
    CheckBox chk_start;
    TextView txt_select;
    RadioGroup rd;
    RadioButton r_dog, r_cat, r_bunny;
    ImageView img_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__animal);
        rd = (RadioGroup)findViewById(R.id.radioAnimal);
        r_dog = (RadioButton)findViewById(R.id.radioDog);
        r_cat = (RadioButton)findViewById(R.id.radioCat);
        r_bunny = (RadioButton)findViewById(R.id.radioBunny);
        chk_start = (CheckBox)findViewById(R.id.chkbox_start);
        txt_select = (TextView)findViewById(R.id.txt_select);
        img_view = (ImageView)findViewById(R.id.imageView);
        txt_select.setVisibility(View.INVISIBLE);
        rd.setVisibility(View.INVISIBLE);
        img_view.setVisibility(View.INVISIBLE);

        /*if(r_dog.isChecked())
            img_view.setImageResource(R.drawable.dog);
        else if(r_cat.isChecked())
            img_view.setImageResource(R.drawable.cat);
        else if(r_bunny.isChecked())
            img_view.setImageResource(R.drawable.bunny);*/
        chk_start.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(chk_start.isChecked()) {
                    txt_select.setVisibility(View.VISIBLE);
                    rd.setVisibility(View.VISIBLE);
                }
                else {
                    txt_select.setVisibility(View.INVISIBLE);
                    rd.setVisibility(View.INVISIBLE);
                    img_view.setVisibility(View.INVISIBLE);
                }
            }
        });
        rd.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                img_view.setVisibility(View.VISIBLE);

                switch (i) {
                    case R.id.radioDog :
                        img_view.setImageResource(R.drawable.dog);
                        break;
                    case R.id.radioCat :
                        img_view.setImageResource(R.drawable.cat);
                        break;
                    case R.id.radioBunny :
                        img_view.setImageResource(R.drawable.bunny);
                        break;
                }
            }
        });
    }
}
