package com.rotinom.remit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.rotinom.remit.dialogs.ChooseCrnActivity;

public class ParseHelper {
	
	static private ParseHelper instance_;
	static private List<ParseObject> crnCache_ = new ArrayList<ParseObject>();
	static private Map<String, ParseObject> crnMap_ = new HashMap<String, ParseObject>();
	
	private ParseHelper(Context context){
		
		// Initialize the parse.com subsystem
        Parse.initialize(
    		context, 
    		"KYO62SPM3uuI5lVr7dMWkIx8j9pkk0rInAMtYJnw", 
    		"HGu1gsWIEcqHajBsYRhGGQM0of387ZeMnoqwV3O7");
        
        ParseAnalytics.trackAppOpened(null);
		
		queryCrnCache();
	}
	
	public static ParseHelper instance(Context context){
		if(null == instance_){
			instance_ = new ParseHelper(context);
		}
		return instance_;
	}
	
	private void queryCrnCache(){
		
		// Create our query
		ParseQuery<ParseObject> query = ParseQuery.getQuery("CRN");
		query.orderByDescending("createdAt");
		
		// Execute the query
		query.findInBackground(new FindCallback<ParseObject>(){
			@Override
			public void done(List<ParseObject> objects, ParseException e) {
				for(ParseObject obj : objects){
					String crn = obj.getString("crn");
					crnMap_.put(crn,  obj);
					
					Log.d("ParseHelper", "Cached crn: " + crn);
				}
				setCrnCache(objects);
			}
		});
	}

	public static List<ParseObject> getCrnCache() {
		return crnCache_;
	}

	public static void setCrnCache(List<ParseObject> crnCache_) {
		ParseHelper.crnCache_ = crnCache_;
	}

	public static ParseObject getObjectByCrn(String crn){
		return crnMap_.get(crn);
	}
}
