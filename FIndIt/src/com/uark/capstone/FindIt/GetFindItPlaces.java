package com.uark.capstone.FindIt;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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

import android.os.AsyncTask;
//import AsyncTask;
import android.util.Log;

public class GetFindItPlaces extends AsyncTask<Void, Void, ArrayList<FindItPlace>> {

	private ArrayList<FindItPlace> findItPlaces;
	
	public GetFindItPlaces()
	{
		findItPlaces = new ArrayList<FindItPlace>();
	}
	
	@Override
	protected ArrayList<FindItPlace> doInBackground(Void... params) {
		String result = "";
    	//the year data to send
    	ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
    	String query = "SELECT latitude, longitude, category, name, comments FROM places";
    	nameValuePairs.add(new BasicNameValuePair("query",query));
    	InputStream is = null;
    	
    	try{
    	        HttpClient httpclient = new DefaultHttpClient();
    	        HttpPost httppost = new HttpPost("http://10.0.2.2/get_all_places.php");//("http://192.168.1.136/get_all_places.php");
    	        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
    	        HttpResponse response = httpclient.execute(httppost);
    	        HttpEntity entity = response.getEntity();
    	        is = entity.getContent();
    	}catch(Exception e){
    	        Log.e("mySQL", "Error in http connection "+e.toString());
    	}
    	//convert response to string
    	try{
    	        BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
    	        StringBuilder sb = new StringBuilder();
    	        String line = null;
    	        while ((line = reader.readLine()) != null) {
    	                sb.append(line + "\n");
    	        }
    	        is.close();
    	 
    	        result=sb.toString();
    	}catch(Exception e){
    	        Log.e("mySQL", "Error converting result "+e.toString());
    	}
    	 
    	//parse json data
    	try{
    		JSONObject jsonResponse = new JSONObject(new String(result));
    		
    	        JSONArray jArray = jsonResponse.getJSONArray("products");// products is the name returned from php new JSONArray(jsonResponse); 
    	        for(int i=0;i<jArray.length();i++){
    	                JSONObject json_data = jArray.getJSONObject(i);
    	                
    	                int lat = json_data.getInt("latitude");
    	                int lon = json_data.getInt("longitude");
    	                String cat = json_data.getString("category");
    	                String nam = json_data.getString("name");
    	                String com = json_data.getString("comments");
    	                
    	                Log.i("MySQL result ", "latitude: "+json_data.getInt("latitude")+", longitude: "
    	                		+ lon+ ", category: " + cat + ", name: " + nam + ", comments: " + com );
    	                
    	                FindItPlace fp = new FindItPlace(lat, lon, cat, nam, com);
    	                try{
    	                	
    	                	findItPlaces.add(fp);
    	                }
    	                catch (Exception e)
    	                {
    	                  Log.e("Adding to List", e.getMessage());	
    	                }
    	                //Log.i("mySQL result","ID"+json_data.getString("id")+
    	                  //      ", Name "+json_data.getString("name")
    	                       
    	                //);
    	                 
    	                //MACFromDb = json_data.getString("MAC_Add");
    	                //AppNameFromDb = json_data.getString("App_Name");
    	                //WWWAddressFromDb = json_data.getString("WWW_Add");
    	           	               
       	        }
    	}catch(JSONException e){
    	        Log.e("mySQL", "Error parsing data "+e.toString());
    	}
		return findItPlaces;
	}

    @Override
    protected void onPostExecute(ArrayList<FindItPlace> result) {
    }
}
