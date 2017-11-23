package com.terabits.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.terabits.dao.UserDAO;
import com.terabits.meta.bo.PhoneAndTimeBo;
import com.terabits.meta.bo.PhonePaymentAndRemarkBo;
import com.terabits.meta.po.UserConsumptionPo;
import com.terabits.meta.po.UserRechargePo;
import com.terabits.meta.vo.ConsumptionVo;
import com.terabits.meta.vo.RechargeVo;
import com.terabits.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public List<RechargeVo> getRecharges(PhoneAndTimeBo phoneAndTimeBo){
		List<RechargeVo> rechargeVos = new ArrayList<RechargeVo>();
		
		List<UserRechargePo> userRechargePos = new ArrayList<UserRechargePo>();
		try {
			userRechargePos = userDAO.selectRecharge(phoneAndTimeBo);
			for (int i = 0; i < userRechargePos.size(); i++) {
				RechargeVo rechargeVo = new RechargeVo();
				rechargeVo.setCreateTime(userRechargePos.get(i).getCreateTime());
				rechargeVo.setPhone(userRechargePos.get(i).getTel());
				rechargeVo.setPayment(userRechargePos.get(i).getPayment());
				rechargeVos.add(rechargeVo);    //忘记add了，,怪不得list都是空的,也没有任何异常信息
			}
			return rechargeVos;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public List<ConsumptionVo> getConssumptions(PhoneAndTimeBo phoneAndTimeBo){
		List<ConsumptionVo> consumptionVos = new ArrayList<ConsumptionVo>();
		
		List<UserConsumptionPo> userConsumptionPos = new ArrayList<UserConsumptionPo>();
		try {
			userConsumptionPos = userDAO.selectConsumption(phoneAndTimeBo);
			for (int i = 0; i < userConsumptionPos.size(); i++) {
				ConsumptionVo consumptionVo = new ConsumptionVo();
				consumptionVo.setPhone(userConsumptionPos.get(i).getTel());
				consumptionVo.setCreateTime(userConsumptionPos.get(i).getCreateTime());
				consumptionVo.setMark(userConsumptionPos.get(i).getMark());
				consumptionVo.setConsumption(userConsumptionPos.get(i).getConsumption());
				consumptionVos.add(consumptionVo);
			}
			return consumptionVos;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public int getInsert(PhonePaymentAndRemarkBo phonePaymentAndRemarkBo) {
		try {
			userDAO.insertPayment(phonePaymentAndRemarkBo);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;		
	}
	
	public int getUpdate(PhonePaymentAndRemarkBo phonePaymentAndRemarkBo) {
		try {
			userDAO.undateBalance(phonePaymentAndRemarkBo);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;		
	}
}
