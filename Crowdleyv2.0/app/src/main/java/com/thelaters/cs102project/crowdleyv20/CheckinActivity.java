package com.thelaters.cs102project.crowdleyv20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
/*
  This class creates the check in page and let user check in a place by using a database
  @authors Nursena Kurubas and Yavuzselim Tasci
  @date 09.05.17
 */
public class CheckinActivity extends AppCompatActivity {

    //properties
    String place;
    int time;
    int crowd;
    FirebaseDatabase database;
    DatabaseReference myRef;
    Intent map;

    //this method creates the page
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkin);

        // Write a message to the database
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        map = new Intent( this, MapsActivity.class );

        //creating time buttons
        final Button button8 = (Button) findViewById(R.id.button9);
        final Button button7 = (Button) findViewById(R.id.button10);
        final Button button6 = (Button) findViewById(R.id.button8);
        final Button button3 = (Button) findViewById(R.id.button7);

        //creating search bar and questions
        final SearchView search = (SearchView) findViewById(R.id.searchView);
        final TextView text = (TextView) findViewById(R.id.textView5);

        //creating check-in buttons and adding them to an arraylist
        final Button aBuilding = (Button) findViewById(R.id.aBui);
        final Button hBuilding = (Button) findViewById(R.id.hBui);
        final Button eeBuilding = (Button) findViewById(R.id.eeBui);
        final Button eaBuilding = (Button) findViewById(R.id.eaBui);
        final Button fBuildings = (Button) findViewById(R.id.fBui);
        final Button gstmfBuilding = (Button) findViewById(R.id.gstmfBui);
        final Button saBuilding = (Button) findViewById(R.id.saBui);
        final Button gBuilding = (Button) findViewById(R.id.gBui);
        final Button cafeIn = (Button) findViewById(R.id.cafeIn);
        final Button sbBuilding = (Button) findViewById(R.id.sbBui);
        final Button mainLibrary = (Button) findViewById(R.id.libraryMain);
        final Button speedCafe = (Button) findViewById(R.id.speedCafe);
        final Button vBuilding = (Button) findViewById(R.id.vBui);
        final Button coffeeBreak = (Button) findViewById(R.id.coffeeBreak);
        final Button sportsMain = (Button) findViewById(R.id.sportsMain);
        final Button meteksan = (Button) findViewById(R.id.meteksanMarket);
        final Button bBuilding = (Button) findViewById(R.id.bBui);

        final ArrayList<Button> buttons = new ArrayList<Button>();
        buttons.add(meteksan);
        buttons.add(bBuilding);
        buttons.add(coffeeBreak);
        buttons.add(cafeIn);
        buttons.add(saBuilding);
        buttons.add(sbBuilding);
        buttons.add(fBuildings);
        buttons.add(gBuilding);
        buttons.add(mainLibrary);
        buttons.add(speedCafe);
        buttons.add(sportsMain);
        buttons.add(vBuilding);
        buttons.add(aBuilding);
        buttons.add(gstmfBuilding);
        buttons.add(hBuilding);
        buttons.add(eaBuilding);
        buttons.add(eeBuilding);

        /*
           These click listeners includes all buttons click listeners and they all do same work:
           changing place string to button's name and use them at database
           changing the visibility of second part of check in
           setting all unselected buttons' visibility to gone and keyboard gone when a button clicked
         */
        bBuilding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                place = "B Building";
                button3.setVisibility(View.VISIBLE);
                button6.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
                button8.setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);
                for(int i = 0; i < buttons.size(); i++){
                    buttons.get(i).setVisibility(View.GONE);
                }
                bBuilding.setVisibility(View.VISIBLE);
                search.clearFocus();

                // Read from the database
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        crowd = dataSnapshot.child( place ).getValue( Integer.class );
                        //Log.d(TAG, "Value is: " + value);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("Failed to read value.", error.toException());
                    }
                });


            }
        });
        hBuilding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                place = "H Building";
                button3.setVisibility(View.VISIBLE);
                button6.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
                button8.setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);
                for(int i = 0; i < buttons.size(); i++){
                    buttons.get(i).setVisibility(View.GONE);
                }
                hBuilding.setVisibility(View.VISIBLE);
                search.clearFocus();
                // Read from the database
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        crowd = dataSnapshot.child( place ).getValue( Integer.class );
                        //Log.d(TAG, "Value is: " + value);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("Failed to read value.", error.toException());
                    }
                });


            }
        });
        aBuilding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                place = "A Building";
                button3.setVisibility(View.VISIBLE);
                button6.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
                button8.setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);
                for(int i = 0; i < buttons.size(); i++){
                    buttons.get(i).setVisibility(View.GONE);
                }
                aBuilding.setVisibility(View.VISIBLE);
                search.clearFocus();
                // Read from the database
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        crowd = dataSnapshot.child( place ).getValue( Integer.class );
                        //Log.d(TAG, "Value is: " + value);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("Failed to read value.", error.toException());
                    }
                });


            }
        });
        eeBuilding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                place = "EE Building";
                button3.setVisibility(View.VISIBLE);
                button6.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
                button8.setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);
                for(int i = 0; i < buttons.size(); i++){
                    buttons.get(i).setVisibility(View.GONE);
                }
                eeBuilding.setVisibility(View.VISIBLE);
                search.clearFocus();
                // Read from the database
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.{
                        crowd = dataSnapshot.child( place ).getValue( Integer.class );
                        //Log.d(TAG, "Value is: " + value);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("Failed to read value.", error.toException());
                    }
                });

            }
        });
        eaBuilding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                place = "EA Building";
                button3.setVisibility(View.VISIBLE);
                button6.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
                button8.setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);
                for(int i = 0; i < buttons.size(); i++){
                    buttons.get(i).setVisibility(View.GONE);
                }
                eaBuilding.setVisibility(View.VISIBLE);
                search.clearFocus();
                // Read from the database
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        crowd = dataSnapshot.child( place ).getValue( Integer.class );
                        //Log.d(TAG, "Value is: " + value);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("Failed to read value.", error.toException());
                    }
                });

            }
        });
        fBuildings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                place = "FC Building";
                button3.setVisibility(View.VISIBLE);
                button6.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
                button8.setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);
                for(int i = 0; i < buttons.size(); i++){
                    buttons.get(i).setVisibility(View.GONE);
                }
                fBuildings.setVisibility(View.VISIBLE);
                search.clearFocus();
                // Read from the database
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        crowd = dataSnapshot.child( place ).getValue( Integer.class );
                        //Log.d(TAG, "Value is: " + value);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("Failed to read value.", error.toException());
                    }
                });

            }
        });
        gstmfBuilding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                place = "FF Building";
                button3.setVisibility(View.VISIBLE);
                button6.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
                button8.setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);
                for(int i = 0; i < buttons.size(); i++){
                    buttons.get(i).setVisibility(View.GONE);
                }
                gstmfBuilding.setVisibility(View.VISIBLE);
                search.clearFocus();
                // Read from the database
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        crowd = dataSnapshot.child( place ).getValue( Integer.class );
                        //Log.d(TAG, "Value is: " + value);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("Failed to read value.", error.toException());
                    }
                });

            }
        });
        saBuilding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                place = "SA Building";
                button3.setVisibility(View.VISIBLE);
                button6.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
                button8.setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);
                for(int i = 0; i < buttons.size(); i++){
                    buttons.get(i).setVisibility(View.GONE);
                }
                saBuilding.setVisibility(View.VISIBLE);
                search.clearFocus();
                // Read from the database
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        crowd = dataSnapshot.child( place ).getValue( Integer.class );
                        //Log.d(TAG, "Value is: " + value);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("Failed to read value.", error.toException());
                    }
                });

            }
        });
        sbBuilding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                place = "SB Building";
                button3.setVisibility(View.VISIBLE);
                button6.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
                button8.setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);
                for(int i = 0; i < buttons.size(); i++){
                    buttons.get(i).setVisibility(View.GONE);
                }
                sbBuilding.setVisibility(View.VISIBLE);
                search.clearFocus();
                // Read from the database
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        crowd = dataSnapshot.child( place ).getValue( Integer.class );
                        //Log.d(TAG, "Value is: " + value);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("Failed to read value.", error.toException());
                    }
                });

            }
        });
        gBuilding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                place = "G Building";
                button3.setVisibility(View.VISIBLE);
                button6.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
                button8.setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);
                for(int i = 0; i < buttons.size(); i++){
                    buttons.get(i).setVisibility(View.GONE);
                }
                gBuilding.setVisibility(View.VISIBLE);
                search.clearFocus();
                // Read from the database
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        crowd = dataSnapshot.child( place ).getValue( Integer.class );
                        //Log.d(TAG, "Value is: " + value);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("Failed to read value.", error.toException());
                    }
                });

            }
        });
        vBuilding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                place = "V Building";
                button3.setVisibility(View.VISIBLE);
                button6.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
                button8.setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);
                for(int i = 0; i < buttons.size(); i++){
                    buttons.get(i).setVisibility(View.GONE);
                }
                vBuilding.setVisibility(View.VISIBLE);
                search.clearFocus();
                // Read from the database
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        crowd = dataSnapshot.child( place ).getValue( Integer.class );
                        //Log.d(TAG, "Value is: " + value);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("Failed to read value.", error.toException());
                    }
                });

            }
        });
        coffeeBreak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                place = "Coffee Break";
                button3.setVisibility(View.VISIBLE);
                button6.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
                button8.setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);
                for(int i = 0; i < buttons.size(); i++){
                    buttons.get(i).setVisibility(View.GONE);
                }
                coffeeBreak.setVisibility(View.VISIBLE);
                search.clearFocus();
                // Read from the database
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        crowd = dataSnapshot.child( place ).getValue( Integer.class );
                        //Log.d(TAG, "Value is: " + value);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("Failed to read value.", error.toException());
                    }
                });

            }
        });
        cafeIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                place = "Cafe In";
                button3.setVisibility(View.VISIBLE);
                button6.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
                button8.setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);
                for(int i = 0; i < buttons.size(); i++){
                    buttons.get(i).setVisibility(View.GONE);
                }
                cafeIn.setVisibility(View.VISIBLE);
                search.clearFocus();
                // Read from the database
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        crowd = dataSnapshot.child( place ).getValue( Integer.class );
                        //Log.d(TAG, "Value is: " + value);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("Failed to read value.", error.toException());
                    }
                });

            }
        });
        speedCafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                place = "Speed Cafe";
                button3.setVisibility(View.VISIBLE);
                button6.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
                button8.setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);
                for(int i = 0; i < buttons.size(); i++){
                    buttons.get(i).setVisibility(View.GONE);
                }
                speedCafe.setVisibility(View.VISIBLE);
                search.clearFocus();
                // Read from the database
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        crowd = dataSnapshot.child( place ).getValue( Integer.class );
                        //Log.d(TAG, "Value is: " + value);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("Failed to read value.", error.toException());
                    }
                });

            }
        });
        sportsMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                place = "Sports Hall";
                button3.setVisibility(View.VISIBLE);
                button6.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
                button8.setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);
                for(int i = 0; i < buttons.size(); i++){
                    buttons.get(i).setVisibility(View.GONE);
                }
                sportsMain.setVisibility(View.VISIBLE);
                search.clearFocus();
                // Read from the database
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        crowd = dataSnapshot.child( place ).getValue( Integer.class );
                        //Log.d(TAG, "Value is: " + value);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("Failed to read value.", error.toException());
                    }
                });

            }
        });
        mainLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                place = "Library";
                button3.setVisibility(View.VISIBLE);
                button6.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
                button8.setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);
                for(int i = 0; i < buttons.size(); i++){
                    buttons.get(i).setVisibility(View.GONE);
                }
                mainLibrary.setVisibility(View.VISIBLE);
                search.clearFocus();
                // Read from the database
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        crowd = dataSnapshot.child( place ).getValue( Integer.class );
                        //Log.d(TAG, "Value is: " + value);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("Failed to read value.", error.toException());
                    }
                });

            }
        });
        meteksan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                place = "Meteksan Market";
                button3.setVisibility(View.VISIBLE);
                button6.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
                button8.setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);
                for(int i = 0; i < buttons.size(); i++){
                    buttons.get(i).setVisibility(View.GONE);
                }
                meteksan.setVisibility(View.VISIBLE);
                search.clearFocus();
                // Read from the database
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        crowd = dataSnapshot.child( place ).getValue( Integer.class );
                        //Log.d(TAG, "Value is: " + value);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("Failed to read value.", error.toException());
                    }
                });

            }
        });

        // This part includes the work of search bar

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //if user submits the text the buttons that has that text in it will be shown
            @Override
            public boolean onQueryTextSubmit(String query) {

                for (int i = 0; i < buttons.size(); i++) {
                    if ( ( buttons.get(i).getText().toString().toLowerCase()).indexOf(query.toLowerCase()) == 0)
                        buttons.get(i).setVisibility(View.VISIBLE);
                    else
                        buttons.get(i).setVisibility(View.GONE);
                }
                return false;
            }
            //when user starts to type the buttons will be gone
            @Override
            public boolean onQueryTextChange(String newText) {

                for (int i = 0; i < buttons.size(); i++) {
                    if ((buttons.get(i).getText().toString().toLowerCase()).indexOf(newText.toLowerCase()) == 0)
                        buttons.get(i).setVisibility(View.VISIBLE);
                    else
                        buttons.get(i).setVisibility(View.GONE);
                }
                return false;
            }


        });


        //Choosing time during check-in

        //DONE button will be visible when time is chosen
        final Button btnDone = (Button) findViewById(R.id.done);

        //setting what happens when time buttons clicked
        //Choose time to add place to database and only make the chosen time button visible

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time = 15;
                button8.setVisibility(View.GONE);
                button6.setVisibility(View.GONE);
                button7.setVisibility(View.GONE);
                btnDone.setVisibility(View.VISIBLE);


            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time = 30;
                button8.setVisibility(View.GONE);
                button3.setVisibility(View.GONE);
                button7.setVisibility(View.GONE);
                btnDone.setVisibility(View.VISIBLE);

            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time = 120;
                button8.setVisibility(View.GONE);
                button3.setVisibility(View.GONE);
                button6.setVisibility(View.GONE);
                btnDone.setVisibility(View.VISIBLE);

            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time = 90;
                button7.setVisibility(View.GONE);
                button3.setVisibility(View.GONE);
                button6.setVisibility(View.GONE);
                btnDone.setVisibility(View.VISIBLE);


            }
        });

        //After choosing time DONE button will be visible and if user click this button, user will be added to database for chosen time and at chosen place
        //Next activity will start
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v ){
                crowd = crowd + 1;
                myRef.child( place ).setValue( crowd );
                map.putExtra("place", place );
                map.putExtra( "crowd", crowd );
                startActivity( map );
            }
        });

    }

}