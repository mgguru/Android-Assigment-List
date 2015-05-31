package com.example.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class BacSi implements Parcelable {
	private String MaBS;
	private String TenBS;
	private int GioiTinh;
	private String ThongTinCaNhan;
	private String HinhAnh;
	private String MaKhoa;
	
	public BacSi(String maBS, String tenBS, int gioiTinh,
			String thongTinCaNhan, String hinhAnh, String maKhoa) {
		super();
		MaBS = maBS;
		TenBS = tenBS;
		GioiTinh = gioiTinh;
		ThongTinCaNhan = thongTinCaNhan;
		HinhAnh = hinhAnh;
		MaKhoa = maKhoa;
	}	
	public String getMaBS() {
		return MaBS;
	}
	public void setMaBS(String maBS) {
		MaBS = maBS;
	}
	public String getTenBS() {
		return TenBS;
	}
	public void setTenBS(String tenBS) {
		TenBS = tenBS;
	}
	public int getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(int gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public String getThongTinCaNhan() {
		return ThongTinCaNhan;
	}
	public void setThongTinCaNhan(String thongTinCaNhan) {
		ThongTinCaNhan = thongTinCaNhan;
	}
	public String getHinhAnh() {
		return HinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		HinhAnh = hinhAnh;
	}
	public String getMaKhoa() {
		return MaKhoa;
	}
	public void setMaKhoa(String maKhoa) {
		MaKhoa = maKhoa;
	}
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 1;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(MaBS);
		dest.writeString(TenBS);
		dest.writeInt(GioiTinh);
		dest.writeString(ThongTinCaNhan);
		dest.writeString(HinhAnh);
		dest.writeString(MaKhoa);		
		
	}
	
	public BacSi (Parcel source){
		MaBS=source.readString();
		TenBS = source.readString();
		GioiTinh = source.readInt();
		ThongTinCaNhan = source.readString();
		HinhAnh = source.readString();
		MaKhoa = source.readString();
	}
	
	public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
		 
        @Override
        public BacSi createFromParcel(Parcel source) {
            // TODO Auto-generated method stub
            return new BacSi(source);
        }
 
        @Override
        public BacSi[] newArray(int size) {
            // TODO Auto-generated method stub
            return new BacSi[size];
        }
    };
	
}
