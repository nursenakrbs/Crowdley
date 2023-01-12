package com.thelaters.cs102project.crowdleyv20;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Parcelable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

/*
  This class creates the map page and a menu that holds buttons
  @authors Melike Arslan, Sila Inci and Mehmet Sanisoglu, Selim Ozcan, Yavuz Tasci contributed
  @date 08.05.17
 */
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    //properties
    private GoogleMap mMap;
    private Button imageButton;
    private Button buildings;
    private Button cafes;
    private Button openAreas;
    private Button sportsCenters;
    private Button about;
    public PlaceContainer container = new PlaceContainer();
    LatLng[] array = new LatLng[18];
    FirebaseDatabase database;
    DatabaseReference myRef;
    DatabaseReference ref;
    Intent buildingList;
    Bundle bundle;
    int crowd;
    String keyB;


    //this method is to be able to create the menu that contains buttons of places when button is clicked.
    public void init() {
        buildings = (Button) findViewById(R.id.button3);
        buildings.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                 buildingList = new Intent(MapsActivity.this, BuildingList.class);

                startActivity(buildingList);
            }
        });

        cafes = (Button) findViewById(R.id.button4);
        cafes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent cafeList = new Intent(MapsActivity.this, CafeList.class);
                startActivity(cafeList);
            }
        });
        openAreas = (Button) findViewById(R.id.button5);
        openAreas.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent openAreasList = new Intent(MapsActivity.this, OpenAreasList.class);
                startActivity(openAreasList);
            }
        });
        sportsCenters = (Button) findViewById(R.id.button6);
        sportsCenters.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent sportsCentersList = new Intent(MapsActivity.this, SportsCentersList.class);
                startActivity(sportsCentersList);
            }
        });
        about = (Button) findViewById(R.id.button7);
        about.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent about = new Intent(MapsActivity.this, About.class);
                startActivity(about);
            }
        });
    }

    //This method opens the page itself
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        bundle = getIntent().getExtras();
        crowd = bundle.getInt( "crowd" );
        keyB = bundle.getString( "place" );
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        ref = database.getReference();
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {
                crowd = dataSnapshot.getValue( Integer.class );
                keyB = dataSnapshot.getKey();
                update();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                collectPop( (Map<String,Object>) dataSnapshot.getValue() );
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        buildings = (Button) findViewById(R.id.button3);
        cafes = (Button) findViewById(R.id.button4);
        openAreas = (Button) findViewById(R.id.button5);
        sportsCenters = (Button) findViewById(R.id.button6);
        about = (Button) findViewById(R.id.button7);

        imageButton = (Button) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                if(buildings.getVisibility() == View.GONE && cafes.getVisibility() == View.GONE
                        && openAreas.getVisibility() == View.GONE && sportsCenters.getVisibility() == View.GONE
                        && about.getVisibility() == View.GONE) {
                    buildings.setVisibility(View.VISIBLE);
                    cafes.setVisibility(View.VISIBLE);
                    openAreas.setVisibility(View.VISIBLE);
                    sportsCenters.setVisibility(View.VISIBLE);
                    about.setVisibility(View.VISIBLE);
                }
                else {
                    buildings.setVisibility(View.GONE);
                    cafes.setVisibility(View.GONE);
                    openAreas.setVisibility(View.GONE);
                    sportsCenters.setVisibility(View.GONE);
                    about.setVisibility(View.GONE);
                }
            }
        });
        init();
    }

    //We used google maps API and markers
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        LatLng saBuilding = new LatLng(39.867776, 32.748084);
        LatLng sbBuilding = new LatLng(39.868258, 32.748177);
        LatLng bBuilding = new LatLng(39.868713, 32.748102);
        LatLng ffBuilding = new LatLng(39.865798, 32.748837);
        LatLng sports = new LatLng(39.866703, 32.748297);
        LatLng speed = new LatLng(39.866313, 32.748306);
        LatLng meteksan = new LatLng(39.872474, 32.751302);
        LatLng vBuilding = new LatLng(39.867052, 32.750122);
        LatLng maBuilding = new LatLng(39.867365, 32.750252);
        LatLng hBuilding = new LatLng(39.868100, 32.749993);
        LatLng aBuilding = new LatLng(39.867882, 32.749507);
        LatLng coffeebreak = new LatLng(39.868199, 32.749130);
        LatLng library = new LatLng(39.870332, 32.749543);
        // LatLng yemekhane = new LatLng(39.870518, 32.750643);
        LatLng eaBuilding = new LatLng(39.871242, 32.750053);
        LatLng eeBuilding = new LatLng(39.872120, 32.750884);
        LatLng cafe_in = new LatLng(39.869961, 32.750573);
        LatLng fcBuilding = new LatLng(39.866407, 32.749260);
        LatLng gBuilding = new LatLng(39.868681, 32.749901);

        array[0] = aBuilding;
        array[1] = bBuilding;
        array[2] = cafe_in;
        array[3] = coffeebreak;
        array[4] = eaBuilding;
        array[5] = eeBuilding;
        array[6] = fcBuilding;
        array[7] = ffBuilding;
        array[8] = gBuilding;
        array[9] = hBuilding;
        array[10] = library;
        array[11] = maBuilding;
        array[12] = meteksan;
        array[13] = saBuilding;
        array[14] = sbBuilding;
        array[15] = speed;
        array[16] = sports;
        array[17] = vBuilding;


        update();


        final LatLngBounds BILKENT = new LatLngBounds(
                new LatLng(39.865973, 32.747098), new LatLng(39.871368, 32.750472));


        mMap.setLatLngBoundsForCameraTarget(BILKENT);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        goToLocationZoom(39.867762, 32.748891, 17.0f);
        mMap.setMinZoomPreference(16.5f);
    }


    private void goToLocationZoom(double lat, double lng, float zoom) {
        LatLng ll = new LatLng(lat, lng);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ll, zoom));
    }


    public void update() {



        container.compareBuilding( keyB ).setPopulation( crowd );


        for (int i = 0; i < 18; i++) {

            double crowd = container.getPlace(i).getCrowdedness();
            MarkerOptions options = new MarkerOptions();

            if (crowd <= 5) {
                options.title(container.getPlace(i).getBuildingName())
                        .position(array[i])
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
                mMap.addMarker(options);
            } else if (crowd > 5 && crowd <= 10) {

                options.title(container.getPlace(i).getBuildingName())
                        .position(array[i])
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
                mMap.addMarker(options);
            } else if (crowd > 10 && crowd <= 15) {
                options.title(container.getPlace(i).getBuildingName())
                        .position(array[i])
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
                mMap.addMarker(options);
            } else if (crowd > 15) {
                options.title(container.getPlace(i).getBuildingName())
                        .position(array[i])
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                mMap.addMarker(options);
            }
        }

        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                View v = getLayoutInflater().inflate(R.layout.info_window, null);
                TextView tvName = (TextView) v.findViewById(R.id.tv_name);
                TextView tvPop = (TextView) v.findViewById(R.id.tv_pop);
                TextView tvHours = (TextView) v.findViewById(R.id.tv_hours);

                tvName.setText(marker.getTitle());
                tvPop.setText("Population : " + container.compareBuilding(marker.getTitle()).getPopulation() + "");
                tvHours.setText("Opening Hours : " + container.compareBuilding(marker.getTitle()).getOpenHours());

                return v;
            }
        });
    }

    private void collectPop(Map<String,Object> population) {

        //iterate through each user, ignoring their UID
        for (Map.Entry<String, Object> entry : population.entrySet()){
            //Get phone field and append to list
            if( container.compareBuilding( entry.getKey() ) != null ) {
                container.compareBuilding(entry.getKey()).setPopulation( Integer.parseInt( entry.getValue().toString() ) );
                update();
            }
        }
    }

}