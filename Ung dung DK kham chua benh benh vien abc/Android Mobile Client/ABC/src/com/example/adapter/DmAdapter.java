package com.example.adapter;

import com.example.abc.DmActivity;
import com.example.abc.R;
import com.example.abc.TkActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DmAdapter extends BaseAdapter {

	private DmActivity context;
	private String[] items;
	LayoutInflater inflater;
	
	public DmAdapter (DmActivity context, String[] items){
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
            convertView = inflater.inflate(R.layout.item_danhmuc_thacmac, null);            
            ImageView iv = (ImageView) convertView.findViewById(R.id.imgDanhmuc);          
            TextView tv =(TextView) convertView.findViewById(R.id.txtTendanhmuc);
            tv.setText(items[position]);
            if (position==0){
            	  iv.setImageResource(R.drawable.thankinh);
            }else if(position==1){
            	  iv.setImageResource(R.drawable.timmach);
            }else if(position==2){
            	  iv.setImageResource(R.drawable.ranghammat);
            }else if(position==3){
            	  iv.setImageResource(R.drawable.dalieu);
            }else{
            	  iv.setImageResource(R.drawable.chinhhinh);
            }
        }
		
		return convertView;
	}

}
