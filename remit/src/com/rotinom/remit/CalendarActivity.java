package com.rotinom.remit;

import com.weber.remit.R;
import com.weber.remit.R.layout;
import com.weber.remit.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.CalendarView;

public class CalendarActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendar);
		
        CalendarView cv = (CalendarView)findViewById(R.id.calendar_view);
        cv.setShownWeekCount(1);
        cv.setShowWeekNumber(false);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calendar, menu);
		return true;
	}

}
