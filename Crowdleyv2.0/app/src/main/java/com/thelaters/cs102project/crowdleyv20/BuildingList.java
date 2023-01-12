package com.thelaters.cs102project.crowdleyv20;
/*
  This class holds a list of buildings
  @authors Selim Ozcan and Mehmet Sanisoglu
  @date 12.05.17
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class BuildingList extends AppCompatActivity {

    //properties
    ImageButton map;
    PlaceContainer container = new PlaceContainer();
    Intent pass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building_list);
        init();
    }
    //to go back to map page if user clicks the map icon
    public void init() {
        map = (ImageButton) findViewById(R.id.imageButton2);
        map.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent buildingList = new Intent(BuildingList.this, MapsActivity.class);
                startActivity(buildingList);
            }
        });
    }
    //to be able to open the building pages when buttons clicked
    public void openPlace(View view) {


        Button bt = (Button) view;
        String s = bt.getText().toString();
        String name = "";
        String hours = "";
        String pop = "";

        MyPlace bu = new MyPlace();

        bu = container.compareBuilding(s);
        if (bu != null) {
            name = (((Building) bu).getBuildingName());
            hours = (((Building) bu).getOpenHours());
            pop = (((Building) bu).getPopulation()) + "";
        }

        Intent pass = new Intent(this, page.class);


        pass.putExtra("name", name);
        pass.putExtra("hours", hours);
        pass.putExtra("pop", pop);

        int[] images = {R.drawable.a, R.drawable.b, R.drawable.cafe_in,
                R.drawable.coffee_break, R.drawable.ea, R.drawable.ee, R.drawable.fc,
                R.drawable.ff, R.drawable.g, R.drawable.h, R.drawable.lib,
                R.drawable.ma, R.drawable.meteksan, R.drawable.sa, R.drawable.sb,
                R.drawable.speed, R.drawable.sports, R.drawable.v};

        Bundle bundle = new Bundle();
        bundle.putInt("image", images[container.getNumber()]);
        pass.putExtras(bundle);

        startActivity(pass);

    }

    public void returnMap(View view){
        pass2 = new Intent(this , MapsActivity.class);
        startActivity(pass2);
    }

}
