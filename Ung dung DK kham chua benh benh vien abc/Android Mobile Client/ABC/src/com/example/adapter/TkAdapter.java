package com.example.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.abc.MyApplication;
import com.example.abc.R;
import com.example.abc.TkActivity;
import com.example.entity.BacSi;

public class TkAdapter extends BaseAdapter {

	private TkActivity context;
	private List<BacSi> bacsiItems;
	private LayoutInflater inflater;
	ImageLoader imageLoader = MyApplication.getInstance().getImageLoader();

	public TkAdapter(TkActivity context, List<BacSi> bacsiItems) {
		this.context = context;
		this.bacsiItems = bacsiItems;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return bacsiItems.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return bacsiItems.get(position).getMaBS();
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		if (inflater == null)
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		if (convertView == null)
			convertView = inflater.inflate(R.layout.bacsi_item, null);

		if (imageLoader == null)
			imageLoader = MyApplication.getInstance().getImageLoader();
		NetworkImageView imgBacsi = (NetworkImageView) convertView
				.findViewById(R.id.imgBacsi);
		TextView txtTenbacsi = (TextView) convertView
				.findViewById(R.id.txtTenbacsi);
		TextView txtChuyenkhoa = (TextView) convertView
				.findViewById(R.id.txtChuyenkhoa);

		BacSi bs = bacsiItems.get(position);
		imgBacsi.setImageUrl(bs.getHinhAnh(), imageLoader);
		txtTenbacsi.setText(bs.getTenBS());
		txtChuyenkhoa.setText(bs.getMaKhoa());

		return convertView;
	}

}
