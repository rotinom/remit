package com.rotinom.remit;

import java.util.ArrayList;
import java.util.List;

import com.rotinom.remit.R;
import com.rotinom.remit.R.id;
import com.rotinom.remit.R.layout;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseAnalytics;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


/**
 * An activity representing a list of ChargeNumbers. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ChargeNumberDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link ChargeNumberListFragment} and the item details
 * (if present) is a {@link ChargeNumberDetailFragment}.
 * <p>
 * This activity also implements the required
 * {@link ChargeNumberListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class ChargeNumberListActivity extends FragmentActivity
        implements ChargeNumberListFragment.Callbacks {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chargenumber_list);
        

        

        

        if (findViewById(R.id.chargenumber_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((ChargeNumberListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.chargenumber_list))
                    .setActivateOnItemClick(true);
        }

        // TODO: If exposing deep links into your app, handle intents here.
    }

    /**
     * Callback method from {@link ChargeNumberListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(String id) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(ChargeNumberDetailFragment.ARG_ITEM_ID, id);
            ChargeNumberDetailFragment fragment = new ChargeNumberDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.chargenumber_detail_container, fragment)
                    .commit();

            
            
        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, ChargeNumberDetailActivity.class);
            detailIntent.putExtra(ChargeNumberDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }
    
}
