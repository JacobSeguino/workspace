package utility;

import java.util.ArrayList;

import objects.contactObj;
import objects.phoneObj;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;

import utility.constants;

public class contactParser{
	
	public static void parseringContacts(JSONArray contact, ArrayList<contactObj> item){
		
		try{
			for(int i = 0; i < contact.length(); i++){
				contactObj con = new contactObj();
				JSONObject c = contact.getJSONObject(i);
				con.setName(c.optString(constants.NAME, "[Name]"));
				con.setEmployeeId(c.optInt(constants.EMPLOYEEID, 0));
				con.setCompany(c.optString(constants.COMPANTY, "[Company]" ));
				con.setDetailsURL(c.optString(constants.DETAILSURL, "[]" ));
				con.setSmallImageURL(c.optString(constants.SMALLIMAGEURL, null));
				con.setBirthdate(c.optString(constants.BIRTHDATE, "[Birthdate]"));
				
				phoneObj phone = new phoneObj();
				JSONObject p = c.getJSONObject(constants.PHONE);
				phone.setHomeP(p.optString(constants.HOMEP, "[Home]"));
				phone.setMobileP(p.optString(constants.MOBILEP, "[Mobile]"));
				if(phone.getMobileP().equalsIgnoreCase("")){
					phone.setMobileP("[Mobile]");
				}
				phone.setWorkP(p.optString(constants.WORKP, "[Work]"));
				con.setPhone(phone);
				
				item.add(con);
			}
			
		}catch(JSONException e){
			e.printStackTrace();
		}
		
	}
}


