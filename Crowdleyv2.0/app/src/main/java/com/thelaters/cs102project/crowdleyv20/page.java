package com.thelaters.cs102project.crowdleyv20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/*
  This class creates the special page of places
  @authors Selim Ozcan and Mehmet Sanisoglu
  @date 12.05.17
 */
public class page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);


        Bundle bundle = getIntent().getExtras();

        String s = bundle.getString("name");

        TextView text = (TextView) findViewById(R.id.name1);
        text.setText(s);

        String p = bundle.getString("hours");
        TextView text2 = (TextView) findViewById(R.id.hours1);
        text2.setText(p);

        String st = bundle.getString("pop");
        TextView text3 = (TextView) findViewById(R.id.pop1);
        text3.setText(st);

        int pic = bundle.getInt("image");
        ImageView v = (ImageView) findViewById(R.id.imageView);
        v.setImageResource(pic);

    }

    public void onClick(View view){
        Intent pass = new Intent(this , MapsActivity.class);
        startActivity(pass);
    }


}
