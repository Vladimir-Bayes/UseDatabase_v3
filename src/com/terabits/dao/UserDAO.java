package com.terabits.dao;

import java.util.List;

import com.terabits.meta.bo.PhoneAndTimeBo;
import com.terabits.meta.bo.PhonePaymentAndRemarkBo;
import com.terabits.meta.po.UserConsumptionPo;
import com.terabits.meta.po.UserRechargePo;

public interface UserDAO {
	/**
	 * @param phoneAndTimeBo
	 * @return
	 * @throws Exception
	 */
	public List<UserRechargePo> selectRecharge(PhoneAndTimeBo phoneAndTimeBo) throws Exception;
	
	/**
	 * @param phoneAndTimeBo
	 * @return
	 * @throws Exception
	 */
	public List<UserConsumptionPo> selectConsumption(PhoneAndTimeBo phoneAndTimeBo) throws Exception;
	
	/**
	 * @param phonePaymentAndRemarkBo
	 * @return
	 * @throws Exception
	 */
	public int insertPayment(PhonePaymentAndRemarkBo phonePaymentAndRemarkBo) throws Exception;
	
	/**
	 * @param phonePaymentAndRemarkBo
	 * @return
	 * @throws Exception
	 */
	public int undateBalance(PhonePaymentAndRemarkBo phonePaymentAndRemarkBo) throws Exception;

}
