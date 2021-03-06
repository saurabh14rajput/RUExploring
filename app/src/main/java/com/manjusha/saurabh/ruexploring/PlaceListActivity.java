package com.manjusha.saurabh.ruexploring;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import io.branch.referral.Branch;
import io.branch.referral.BranchError;



/**
 * An activity representing a list of Places. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link PlaceDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p/>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link PlaceListFragment} and the item details
 * (if present) is a {@link PlaceDetailFragment}.
 * <p/>
 * This activity also implements the required
 * {@link PlaceListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class PlaceListActivity extends AppCompatActivity
        implements PlaceListFragment.Callbacks {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    public void onNewIntent(Intent intent) {
        this.setIntent(intent);


    }

    @Override
    public void onStart() {
        super.onStart();

        Branch branch = Branch.getInstance();
        //Branch branch = Branch.getInstance(getApplicationContext());
        branch.initSession(new Branch.BranchReferralInitListener() {
            @Override
            public void onInitFinished(JSONObject referringParams, BranchError error) {
                if (error == null) {
                    // params are the deep linked params associated with the link that the user clicked before showing up
                    String placeId="";
                    Log.d("BranchConfigTest", "deep link data: " + referringParams.toString());
                    try {
                        placeId = referringParams.get("placeId").toString();
                        Log.d("ID retrived from Json: ", placeId);

                        Intent detailIntent;
                        detailIntent = new Intent(getApplicationContext(), PlaceDetailActivity.class);
                        detailIntent.putExtra(PlaceDetailFragment.ARG_ITEM_ID, placeId);
                       // onNewIntent(detailIntent);
                        startActivity(detailIntent);
                        //intent.putExtra(PlaceDetailFragment.ARG_ITEM_ID, id);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            }
        }, this.getIntent().getData(), this);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Branch.getAutoInstance(this);
        setContentView(R.layout.activity_place_app_bar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        if (findViewById(R.id.place_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((PlaceListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.place_list))
                    .setActivateOnItemClick(true);
        }

        // TODO: If exposing deep links into your app, handle intents here.

    }


    /**
     * Callback method from {@link PlaceListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(String id) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(PlaceDetailFragment.ARG_ITEM_ID, id);
            PlaceDetailFragment fragment = new PlaceDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.place_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, PlaceDetailActivity.class);
            detailIntent.putExtra(PlaceDetailFragment.ARG_ITEM_ID, id);
            //Log.d("LINKON_pla", id);
            startActivity(detailIntent);
        }
    }
}
