package com.terabits.service;

import java.util.List;

import com.terabits.meta.bo.PhoneAndTimeBo;
import com.terabits.meta.bo.PhonePaymentAndRemarkBo;
import com.terabits.meta.vo.ConsumptionVo;
import com.terabits.meta.vo.RechargeVo;

public interface UserService {
	
	public List<RechargeVo> getRecharges(PhoneAndTimeBo phoneAndTimeBo);
	
	public List<ConsumptionVo> getConssumptions(PhoneAndTimeBo phoneAndTimeBo);
	
	public int getInsert(PhonePaymentAndRemarkBo phonePaymentAndRemarkBo);
	
	public int getUpdate(PhonePaymentAndRemarkBo phonePaymentAndRemarkBo);

}
