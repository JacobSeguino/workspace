package com.example.solsticecontact;

import java.util.ArrayList;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import objects.contactObj;
import objects.phoneObj;
import utility.constants;
import utility.contactParser;
import adapter.contactAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
public class MainActivity extends Activity {
	
	static ArrayList<contactObj> contact = new ArrayList<contactObj>();
	contactAdapter adapter;
	String url = constants.URL;
	ListView listView;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        
        RequestQueue queue = Volley.newRequestQueue(this);
        	
        JsonArrayRequest req = new JsonArrayRequest(url, new Response.Listener<JSONArray> () {
            @Override
            public void onResponse(JSONArray response) {
                contactParser.parseringContacts(response, contact);
                adapter = new contactAdapter(getApplicationContext(),contact);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parentView, View view,
							int position, long arg3) {
						Bundle bundle = new Bundle();
			    		phoneObj tempPhone = contact.get(position).getPhone();
			    		
			    		bundle.putString(constants.NAME, contact.get(position).getName());
			    		bundle.putInt(constants.EMPLOYEEID, contact.get(position).getEmployeeId());
			    		bundle.putString(constants.COMPANTY, contact.get(position).getCompany());
			    		bundle.putString(constants.DETAILSURL, contact.get(position).getDetailsURL());
			    		bundle.putString(constants.SMALLIMAGEURL, contact.get(position).getSmallImageURL());
			    		bundle.putString(constants.BIRTHDATE, contact.get(position).getBirthdate());
			    		bundle.putString(constants.HOMEP, tempPhone.getHomeP());
			    		bundle.putString(constants.MOBILEP, tempPhone.getMobileP());
			    		bundle.putString(constants.WORKP, tempPhone.getWorkP());
			    		
			    		Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
			    		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			    		intent.putExtras(bundle);
			    		
			    		startActivity(intent);
						
					}
                	
                });
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               
            }
        });
        queue.add(req);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
