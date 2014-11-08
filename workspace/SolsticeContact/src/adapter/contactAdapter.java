package adapter;

import java.util.ArrayList;

import objects.contactObj;
import objects.phoneObj;
import utility.MyVolley;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.example.solsticecontact.R;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class contactAdapter extends BaseAdapter{
	
	Context context;
	ArrayList<contactObj> contactList = new ArrayList<contactObj>();
	phoneObj PO = new phoneObj();
	String url;
	
	public contactAdapter(Context c, ArrayList<contactObj> co){
		this.context = c;
		this.contactList = co;		
	}
	@Override
	public int getCount() {
		return contactList.size();
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	View child;
	TextView name;
	TextView number;
	ImageView image;
	
	
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		child = li.inflate(R.layout.list_item, null);
		name = (TextView) child.findViewById(R.id.Name1);
		number = (TextView) child.findViewById(R.id.Phone1);
		image = (ImageView) child.findViewById(R.id.ContactImage);
		
//		ImageLoader imageLoader = MyVolley.getImageLoader();
//        imageLoader.get(url, 
//                       ImageLoader.getImageListener(image, 
//                                                     R.drawable.ic_launcher, 
//                                                     R.drawable.ic_launcher));
//		
		url = ""+contactList.get(arg0).getSmallImageURL();
		
		Picasso.with(context).load(url).placeholder(R.drawable.ic_launcher).into(image);
		
		//queue.add(ir);

		name.setText(""+contactList.get(arg0).getName());
		PO = contactList.get(arg0).getPhone();
		number.setText(""+PO.getWorkP());
		return child;
	}
	
}