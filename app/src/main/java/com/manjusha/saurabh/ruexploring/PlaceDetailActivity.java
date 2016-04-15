package com.manjusha.saurabh.ruexploring;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

import com.manjusha.saurabh.ruexploring.dummy.DummyContent;

import static com.manjusha.saurabh.ruexploring.R.*;

/**
 * An activity representing a single Place detail screen. This
 * activity is only used on handset devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link PlaceListActivity}.
 * <p/>
 * This activity is mostly just a 'shell' activity containing nothing
 * more than a {@link PlaceDetailFragment}.
 */
public class PlaceDetailActivity extends AppCompatActivity {
    double lattitude;
    double longitude;
    String uriUber;
    String uriMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_place_detail);
        Toolbar toolbar = (Toolbar) findViewById(id.detail_toolbar);
        setSupportActionBar(toolbar);
        String id = getIntent().getStringExtra(PlaceDetailFragment.ARG_ITEM_ID);
        lattitude =DummyContent.ITEMS.get(Integer.parseInt(id)).getLatitude();
        longitude =DummyContent.ITEMS.get(Integer.parseInt(id)).getLongitude();
        uriUber = makeUriUber(id);
        uriMap= makeUriMap(id);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "UBER deep linking coming soon!", Snackbar.LENGTH_LONG)
                  //      .setAction("Action", null).show();
                try {
                    PackageManager pm = getPackageManager();
                    pm.getPackageInfo("com.ubercab", PackageManager.GET_ACTIVITIES);
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(uriUber));
                    startActivity(intent);
                } catch (PackageManager.NameNotFoundException e) {
                    // No Uber app! Open mobile website.
                    String url = "https://m.uber.com/sign-up?client_id=Yhml9abrOFNKA3i-sky_LFWgXPBVh7gC";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }

            }
        });

        FloatingActionButton map = (FloatingActionButton) findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "UBER deep linking coming soon!", Snackbar.LENGTH_LONG)
                //      .setAction("Action", null).show();
                try {

                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                            Uri.parse(uriMap));
                    startActivity(intent);
                } catch (Exception e) {
                    // No Uber app! Open mobile website.
                    String url = "https://m.uber.com/sign-up?client_id=Yhml9abrOFNKA3i-sky_LFWgXPBVh7gC";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }

            }
        });

        // Show the Up button in the action bar.//this is the back button on top of the detail fragment
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            Log.d("LINKON", PlaceDetailFragment.ARG_ITEM_ID);
            arguments.putString(PlaceDetailFragment.ARG_ITEM_ID,
                    getIntent().getStringExtra(PlaceDetailFragment.ARG_ITEM_ID));
            PlaceDetailFragment fragment = new PlaceDetailFragment();
            fragment.setArguments(arguments);
            //Log.d("LINKON",getIntent().getStringExtra(PlaceDetailFragment.ARG_ITEM_ID));
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.place_detail_container, fragment)
                    .commit();
        }

    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. Use NavUtils to allow users
            // to navigate up one level in the application structure. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            NavUtils.navigateUpTo(this, new Intent(this, PlaceListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public String makeUriUber(String id){

        Uri.Builder builder = new Uri.Builder();
        //String myUrl="";
        builder.scheme("uber://")
                        .appendQueryParameter("client_id", "Yhml9abrOFNKA3i-sky_LFWgXPBVh7gC")
                        .appendQueryParameter("action", "setPickup")
                        .appendQueryParameter("pickup","my_location")
                        .appendQueryParameter("dropoff[latitude]", Double.toString((DummyContent.ITEMS.get(Integer.parseInt(id)).latitude)))
                        .appendQueryParameter("dropoff[longitude]",Double.toString((DummyContent.ITEMS.get(Integer.parseInt(id)).longitude)))
                        .appendQueryParameter("dropoff[nickname]",DummyContent.ITEMS.get(Integer.parseInt(id)).content)
                        .appendQueryParameter("dropoff[formatted_address]", DummyContent.ITEMS.get(Integer.parseInt(id)).address);
                                //myUrl= "uber://?client_id=YOUR_CLIENT_ID&action=setPickup&pickup=my_location&dropoff[latitude]=40.500201&dropoff[longitude]=-74.445859&dropoff[nickname]=Zimmerli%20art%20museum&dropoff[formatted_address]=Voorhees%20Hall%2C%2071%20Hamilton%20St%20New%20Brunswick%2C%20NJ%2008901";


                //return "uber://?client_id=YOUR_CLIENT_ID&action=setPickup&pickup=my_location&dropoff[latitude]=40.525421&dropoff[longitude]=-74.437181&dropoff[nickname]=Rutgers%20Cinema&dropoff[formatted_address]=105%20Joyce%20Kilmer%20Ave%2C%20Piscataway%20Township%2C%20NJ%2008854"


        String myUrl = builder.build().toString();
        Log.d("URI:", myUrl);
        return myUrl;
    }
    public String makeUriMap(String id){

        Uri.Builder builder = new Uri.Builder();
        //String myUrl="";
        builder.scheme("http")
                .authority("maps.google.com")
                .appendEncodedPath("maps")
                .appendQueryParameter("daddr", Double.toString((DummyContent.ITEMS.get(Integer.parseInt(id)).latitude))+","+Double.toString((DummyContent.ITEMS.get(Integer.parseInt(id)).longitude))+"(Zimmerli Art Museum)");
        //myUrl= "uber://?client_id=YOUR_CLIENT_ID&action=setPickup&pickup=my_location&dropoff[latitude]=40.500201&dropoff[longitude]=-74.445859&dropoff[nickname]=Zimmerli%20art%20museum&dropoff[formatted_address]=Voorhees%20Hall%2C%2071%20Hamilton%20St%20New%20Brunswick%2C%20NJ%2008901";
       // http://maps.google.com/maps?daddr=40.483853,-74.438940(Zimmerli Art Museum)"
        String myUrl = builder.build().toString();
        Log.d("MAP URI:", myUrl);
        return myUrl;

        //return "uber://?client_id=YOUR_CLIENT_ID&action=setPickup&pickup=my_location&dropoff[latitude]=40.525421&dropoff[longitude]=-74.437181&dropoff[nickname]=Rutgers%20Cinema&dropoff[formatted_address]=105%20Joyce%20Kilmer%20Ave%2C%20Piscataway%20Township%2C%20NJ%2008854"

    }

}

