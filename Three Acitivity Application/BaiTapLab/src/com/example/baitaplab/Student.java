package com.example.baitaplab;

public class Student {

	private String MSSV;
	public String getMSSV() {
		return MSSV;
	}
	public void setMSSV(String mSSV) {
		MSSV = mSSV;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public int getDiem() {
		return Diem;
	}
	public void setDiem(int diem) {
		Diem = diem;
	}
	private String HoTen;
	private int Diem;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getMSSV() + ", " + this.getHoTen() + ", " + this.getDiem();
	}
	
	
}
