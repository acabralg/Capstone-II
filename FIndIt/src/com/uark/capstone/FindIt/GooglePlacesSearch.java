package com.uark.capstone.FindIt;



import org.apache.http.client.HttpResponseException;

import android.util.Log;
 
import com.google.api.client.googleapis.GoogleHeaders;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.http.json.JsonHttpParser;
import com.google.api.client.json.JsonFactory;
//import com.google.api.client.jackson.JacksonFactory;




import android.app.Activity;



@SuppressWarnings("deprecation")
public class GooglePlacesSearch {

	/*
	// Google API Key
	private static final String API_KEY = "AIzaSyCVZ5Svlw2JdE3_1ligLX0fgLA6X29g-qc";
	
	
	
	 private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
	 
	    
	 	    // Google Places search url's
	    private static final String PLACES_SEARCH_URL = "https://maps.googleapis.com/maps/api/place/search/json?";
	    //private static final String PLACES_TEXT_SEARCH_URL = "https://maps.googleapis.com/maps/api/place/search/json?";
	    //private static final String PLACES_DETAILS_URL = "https://maps.googleapis.com/maps/api/place/details/json?";
	 
	    private double _latitude;
	    private double _longitude;
	    private double _radius;
	 
     // search for places according to arguments and return list of places
     public GooglePlacesList search(double latitude, double longitude, double radius, String types)
	    	throws Exception {
	 
	        this._latitude = latitude;
	        this._longitude = longitude;
	        this._radius = radius;
	 
	        try {
	 
	            HttpRequestFactory httpRequestFactory = createRequestFactory(HTTP_TRANSPORT);
	            HttpRequest request = httpRequestFactory.buildGetRequest(new GenericUrl(PLACES_SEARCH_URL));
	            request.getUrl().put("key", API_KEY);
	            request.getUrl().put("location", _latitude + "," + _longitude);
	            request.getUrl().put("radius", _radius); // in meters
	            request.getUrl().put("sensor", "false");
	            if(types != null)
	                request.getUrl().put("types", types);
	 
	            GooglePlacesList list = request.execute().parseAs(GooglePlacesList.class);
	            // Check log cat for places response status
	            Log.d("Places Status", "" + list.status);
	            return list;
	 
	        } catch (HttpResponseException e) {
	        	Log.d("aarao FirstError", e.getMessage());
	            Log.e("Error:", e.getMessage());
	            return null;
	        }
	 
	    }
	 

	    @SuppressWarnings("deprecation")
	    public static HttpRequestFactory createRequestFactory(
	            final HttpTransport transport) {
	        return transport.createRequestFactory(new HttpRequestInitializer() {
	            public void initialize(HttpRequest request) {
	                GoogleHeaders headers = new GoogleHeaders();
	                headers.setApplicationName("AndroidHive-Places-Test");
	                request.setHeaders(headers);
	                JsonHttpParser parser = new JsonHttpParser(null); //(new JacksonFactory());
	                request.addParser(parser);
	            }
	        });
	    }
	*/
}
