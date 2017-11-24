package com.terabits.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.terabits.dao.LogDAO;
import com.terabits.dao.UserDAO;
import com.terabits.meta.vo.ConsumptionVo;
import com.terabits.meta.vo.RechargeVo;
import com.terabits.service.UserService;

import net.sf.json.JSONArray;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private LogDAO logDAO;
	
	public JSONArray getRecharges(String beginTime, String endTime, String phone){
		List<RechargeVo> rechargeVos = new ArrayList<RechargeVo>();

		try {
			rechargeVos = userDAO.selectRecharge(beginTime, endTime, phone);
			JSONArray jsonArray = JSONArray.fromObject(rechargeVos);
			return jsonArray;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public JSONArray getConsumptions(String beginTime, String endTime, String phone){
		List<ConsumptionVo> consumptionVos = new ArrayList<ConsumptionVo>();
		String deviceid="";
		String mark="";
		long siteid=0;
		try {
			consumptionVos = userDAO.selectConsumption(beginTime, endTime, phone);
			for (int i = 0; i < consumptionVos.size(); i++) {
				deviceid = consumptionVos.get(i).getStation();
				siteid = userDAO.selectSiteIdByDeviceId(deviceid);
				mark = userDAO.selectMarkBySiteId(siteid);				
				consumptionVos.get(i).setStation(mark);
			}			
			JSONArray jsonArray = JSONArray.fromObject(consumptionVos);
			return jsonArray;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public int insertPayment(String phone, int paymeny, String comments, String adminname){
		try {
			userDAO.insertPayment(phone, paymeny);
			int type = 6;
			logDAO.insertLogOfRecharge(adminname, type, comments);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 2;		
	}
}
