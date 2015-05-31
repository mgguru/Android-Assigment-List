package com.example.adapter;

import com.example.abc.TkActivity;
import com.example.abc.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TkGridAdapter extends BaseAdapter {
	
	private TkActivity context;
	private String[] items;
	LayoutInflater inflater;
	
	public TkGridAdapter (TkActivity context, String[] items){
		this.context = context;
		this.items = items;
        inflater = (LayoutInflater) this.context.
        		getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return items.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return items[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
            convertView = inflater.inflate(R.layout.bacsi_item, null);            
            ImageView iv = (ImageView) convertView.findViewById(R.id.imgBacsi);
            iv.setImageResource(R.drawable.ic_launcher);
            TextView tv =(TextView) convertView.findViewById(R.id.txtTenbacsi);
            tv.setText(items[position]);
            TextView tv2 = (TextView) convertView.findViewById(R.id.txtChuyenkhoa);
            tv2.setText("Bác si");
        }
		
		return convertView;
	}
}

