package com.terabits.dao;

import java.util.List;


import com.terabits.meta.vo.ConsumptionVo;
import com.terabits.meta.vo.RechargeVo;

public interface UserDAO {

	public List<RechargeVo> selectRecharge(String beginTime, String endTime, String phone) throws Exception;

	public List<ConsumptionVo> selectConsumption(String beginTime, String endTime, String phone) throws Exception;
	
	public long selectSiteIdByDeviceId(String deviceid) throws Exception;
	
	public String selectMarkBySiteId(long siteid) throws Exception;
	
	public int insertPayment(String phone, int paymeny) throws Exception;

}
