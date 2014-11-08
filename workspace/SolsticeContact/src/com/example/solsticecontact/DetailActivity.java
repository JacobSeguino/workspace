package com.example.solsticecontact;

import objects.addressObj;
import objects.detailObj;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import utility.constants;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends Activity {

	detailObj det;
	addressObj address;
	String url;
	ImageView contactImage;
	TextView name;
	TextView company;
	TextView homeP;
	TextView workP;
	TextView mobileP;
	
	TextView street;
	TextView city;
	TextView state;
	TextView country;
	TextView zip;
	
	TextView birthday;
	
	TextView email;
	
	TextView web;
	
	ImageView favorite;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.contact);
		
		contactImage = (ImageView) findViewById(R.id.ContactImage);
		
		name = (TextView) findViewById(R.id.Name1);
		company = (TextView) findViewById(R.id.company);
		homeP = (TextView) findViewById(R.id.homeP);
		workP = (TextView) findViewById(R.id.workP);
		mobileP = (TextView) findViewById(R.id.mobileP);
		
		street = (TextView) findViewById(R.id.street);
		city = (TextView) findViewById(R.id.city);
		state = (TextView) findViewById(R.id.state);
		country = (TextView) findViewById(R.id.country);
		zip = (TextView) findViewById(R.id.zip);
		
		birthday = (TextView) findViewById(R.id.birthday);
		
		email = (TextView) findViewById(R.id.email);
		
		web = (TextView) findViewById(R.id.web);
		
		favorite = (ImageView) findViewById(R.id.favoirte);
		
		Bundle bundle = getIntent().getExtras();
		
		 RequestQueue queue = Volley.newRequestQueue(this);
		 
		 String url = bundle.getString(constants.DETAILSURL);
		 
		 JsonObjectRequest jsObjectRequest = new JsonObjectRequest(0, url, null, new Response.Listener<JSONObject>() {
			 
		        @Override
		        public void onResponse(JSONObject r) {
		            // TODO Auto-generated method stub
		           // txtDisplay.setText("Response => "+response.toString());
		          // findViewById(R.id.progressBar1).setVisibility(View.GONE);
		        	try{
		        		det = new detailObj();
		        		
			        	det.setEmployeeId(r.optInt(constants.EMPLOYEEID, 0));
			        	det.setFavorite(r.optBoolean(constants.FAVORITE, false));
			        	det.setLargeImageURL(r.optString(constants.LARGEIMAGEURL, null));
			        	det.setEmail(r.optString(constants.EMAIL, "[Email]"));
			        	det.setWebsite(r.optString(constants.WEBSITE, "[website]"));
			        	
			        	address = new addressObj();
			        	JSONObject a = r.getJSONObject(constants.ADDRESS);
			        	address.setStreet(a.optString(constants.STREET, "[Street]"));
			        	address.setCity(a.optString(constants.CITY, "[City]"));
			        	address.setState(a.optString(constants.STATE, "[State]"));
			        	address.setCountry(a.optString(constants.COUNTRY, "[Country]"));
			        	address.setZip(a.optString(constants.ZIP,"[Zip]"));
			        	address.setLatitude(a.optString(constants.LATITUDE, "[Latitude]"));
			        	address.setLongitude(a.optString(constants.LONGITUDE, "[Longitude]"));
			        	
			        	det.setAddress(address);
		        	
			        	showDetails();
			        	
		        	}catch(JSONException e){
		        		e.printStackTrace();
		        	}
		        }
		    }, new Response.ErrorListener() {
		 
		        @Override
		        public void onErrorResponse(VolleyError error) {
		        // TODO Auto-generated method stub
		 
		        }
		    });
		 queue.add(jsObjectRequest);
		 
		
		name.setText(bundle.getString(constants.NAME));
		company.setText(bundle.getString(constants.COMPANTY));
		homeP.setText(bundle.getString(constants.HOMEP));
		workP.setText(bundle.getString(constants.WORKP));
		mobileP.setText(bundle.getString(constants.MOBILEP));
		birthday.setText(bundle.getString(constants.BIRTHDATE));
	}

	private void showDetails() {
		url = det.getLargeImageURL();
		street.setText(address.getStreet());
		city.setText(address.getCity());
		state.setText(", "+address.getState());
		country.setText(address.getCountry());
		zip.setText(" "+address.getZip());
		email.setText(det.getEmail());
		web.setText(det.getWebsite());
		if(det.isFavorite()){
			favorite.setVisibility(View.VISIBLE);
		}
		Picasso.with(this).load(url).placeholder(R.drawable.ic_launcher).into(contactImage);
	}
}
