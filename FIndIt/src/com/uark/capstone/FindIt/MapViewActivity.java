package com.uark.capstone.FindIt;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import android.util.Log;

public class MapViewActivity extends MapActivity {

	//private GooglePlacesSearch googlePlacesSearch; // class that will search google places
	//private GooglePlacesList listOfGooglePlaces;
	private ArrayList<FindItPlace> findItPlacesList;
	
	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.mapview);
	    
	    MapView mapView = (MapView) findViewById(R.id.mapview);
	    mapView.setBuiltInZoomControls(true);
	    
	    List<Overlay> mapOverlays = mapView.getOverlays();
	    Drawable drawable = this.getResources().getDrawable(R.drawable.androidmarker);
	    FindItItemizedOverlay itemizedoverlay = new FindItItemizedOverlay(drawable, this);
	    
	    // TODO: add code to read from database the list of points of interest that fulfill users search
	    // criteria then load those to an array of overlay Items (the array in FindItItemizedOverlay)
	    
	    
	    //GetGooglePlaces googlePlaces = new GetGooglePlaces();
	    //googlePlaces.start();
	  
	    GetFindItPlaces findItPlaces = new GetFindItPlaces();
	    
	    try {
	    		findItPlacesList = findItPlaces.execute().get(); // connect to database in another thread and wait for response (places)
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   

	    
	    for(FindItPlace fip : findItPlacesList)
	    {
	    	int latitude = fip.GetLatitude();
	    	int longitude = fip.GetLongitude();
	    	String name = fip.GetName();
	    	String comment = fip.GetComments();
	    	
	    	GeoPoint point = new GeoPoint(latitude, longitude);
	    	
	    	OverlayItem overlayitem = new OverlayItem(point, name, comment);
	    	itemizedoverlay.addOverlay(overlayitem);
		    mapOverlays.add(itemizedoverlay);
	    }
	    
	    itemizedoverlay.Populate();
	    
	}
	
    
}
