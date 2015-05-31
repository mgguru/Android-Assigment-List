package com.example.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Khoa implements Parcelable{
	private String MaKhoa;
	private String TenKhoa;
	
	public Khoa(String maKhoa, String tenKhoa) {
		super();
		MaKhoa = maKhoa;
		TenKhoa = tenKhoa;
	}

	
	public String getMaKhoa() {
		return MaKhoa;
	}
	public void setMaKhoa(String maKhoa) {
		MaKhoa = maKhoa;
	}
	public String getTenKhoa() {
		return TenKhoa;
	}
	public void setTenKhoa(String tenKhoa) {
		TenKhoa = tenKhoa;
	}
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 1;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(MaKhoa);
		dest.writeString(TenKhoa);
	}
	
	public Khoa (Parcel source){
		MaKhoa=source.readString();
		TenKhoa = source.readString();
	}
	
	public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
		 
        @Override
        public Khoa createFromParcel(Parcel source) {
            // TODO Auto-generated method stub
            return new Khoa(source);
        }
 
        @Override
        public Khoa[] newArray(int size) {
            // TODO Auto-generated method stub
            return new Khoa[size];
        }
    };
}
