package com.terabits.service;

import net.sf.json.JSONArray;

public interface UserService {
	
	public JSONArray getRecharges(String beginTime, String endTime, String phone);

	public JSONArray getConsumptions(String beginTime, String endTime, String phone);
	
	public int insertPayment(String phone, int paymeny, String comments, String adminname);

}
