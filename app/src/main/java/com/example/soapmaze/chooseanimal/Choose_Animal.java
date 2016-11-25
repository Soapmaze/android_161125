package com.example.soapmaze.chooseanimal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class Choose_Animal extends AppCompatActivity {
    Switch switch_start;
    TextView txt_select;
    RadioGroup rd;
    RadioButton r_jellybean, r_kitkat, r_lollipop;
    ImageView img_view;
    Button btn_quit, btn_reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__animal);
        rd = (RadioGroup)findViewById(R.id.radioAndroid);
        r_jellybean = (RadioButton)findViewById(R.id.radioJellybean);
        r_kitkat = (RadioButton)findViewById(R.id.radioKitkat);
        r_lollipop = (RadioButton)findViewById(R.id.radioLollipop);
        switch_start = (Switch)findViewById(R.id.switch_start);
        txt_select = (TextView)findViewById(R.id.txt_select);
        img_view = (ImageView)findViewById(R.id.imageView);
        btn_quit = (Button)findViewById(R.id.btn_quit);
        btn_reset = (Button)findViewById(R.id.btn_reset);
        txt_select.setVisibility(View.INVISIBLE);
        rd.setVisibility(View.INVISIBLE);
        img_view.setVisibility(View.INVISIBLE);
        btn_quit.setVisibility(View.INVISIBLE);
        btn_reset.setVisibility(View.INVISIBLE);

        /*if(r_dog.isChecked())
            img_view.setImageResource(R.drawable.dog);
        else if(r_cat.isChecked())
            img_view.setImageResource(R.drawable.cat);
        else if(r_bunny.isChecked())
            img_view.setImageResource(R.drawable.bunny);*/
        switch_start.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(switch_start.isChecked()) {
                    txt_select.setVisibility(View.VISIBLE);
                    rd.setVisibility(View.VISIBLE);
                }
                else {
                    txt_select.setVisibility(View.INVISIBLE);
                    rd.setVisibility(View.INVISIBLE);
                    img_view.setVisibility(View.INVISIBLE);
                    btn_quit.setVisibility(View.INVISIBLE);
                    btn_reset.setVisibility(View.INVISIBLE);
                }
            }
        });
        rd.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                img_view.setVisibility(View.VISIBLE);

                switch (i) {
                    case R.id.radioJellybean :
                        img_view.setImageResource(R.drawable.jellybean);
                        btn_quit.setVisibility(View.VISIBLE);
                        btn_reset.setVisibility(View.VISIBLE);
                        break;
                    case R.id.radioKitkat :
                        img_view.setImageResource(R.drawable.kitkat);
                        btn_quit.setVisibility(View.VISIBLE);
                        btn_reset.setVisibility(View.VISIBLE);
                        break;
                    case R.id.radioLollipop :
                        img_view.setImageResource(R.drawable.lollipop);
                        btn_quit.setVisibility(View.VISIBLE);
                        btn_reset.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
        btn_quit.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
                finish();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });

        btn_reset.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch_start.setChecked(false);
            }
        });
    }
}
