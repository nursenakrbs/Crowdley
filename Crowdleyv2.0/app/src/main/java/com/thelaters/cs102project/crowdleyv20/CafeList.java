package com.thelaters.cs102project.crowdleyv20;
/*
  This class holds a list of cafes
  @authors Selim Ozcan and Mehmet Sanisoglu
  @date 12.05.17
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class CafeList extends AppCompatActivity {

    //properties
    ImageButton map;
    PlaceContainer container = new PlaceContainer();

    //This method creates the GUI of the page with its xml code
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe_list);
    }

    // This method creates the list of places with their specialties

    public void openPlace(View view) {

        //properties
        Button bt = (Button) view;
        String s = bt.getText().toString();
        String name = "";
        String hours = "";
        String pop = "";
        Intent pass = new Intent(this, page.class);
        MyPlace bu = new MyPlace();

        //declaring the building properties
        bu = container.compareBuilding(s);
        if (bu != null) {
            name = (((Building) bu).getBuildingName());
            hours = (((Building) bu).getOpenHours());
            pop = (((Building) bu).getPopulation()) + "";
        }

        //passing the data to next activity
        pass.putExtra("name", name);
        pass.putExtra("hours", hours);
        pass.putExtra("pop", pop);

        //array for images of places
        int[] images = {R.drawable.a, R.drawable.b, R.drawable.cafe_in,
                R.drawable.coffee_break, R.drawable.ea, R.drawable.ee, R.drawable.fc,
                R.drawable.ff, R.drawable.g, R.drawable.h, R.drawable.lib,
                R.drawable.ma, R.drawable.meteksan, R.drawable.sa, R.drawable.sb,
                R.drawable.speed, R.drawable.sports, R.drawable.v};

        //passing data to different pages
        Bundle bundle = new Bundle();
        bundle.putInt("image", images[container.getNumber()]);
        pass.putExtras(bundle);

        //changing the page
        startActivity(pass);

    }

    public void returnMap(View view){
        Intent pass = new Intent(this , MapsActivity.class);
        startActivity(pass);
    }
}