package com.terabits.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.terabits.dao.UserDAO;
import com.terabits.mapper.UserMapper;
import com.terabits.meta.bo.PhoneAndTimeBo;
import com.terabits.meta.bo.PhonePaymentAndRemarkBo;
import com.terabits.meta.po.UserConsumptionPo;
import com.terabits.meta.po.UserRechargePo;
import com.terabits.utils.DBTools;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO{
	
	public List<UserRechargePo> selectRecharge(PhoneAndTimeBo phoneAndTimeBo) throws Exception {
		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<UserRechargePo> userRechargePos = new ArrayList<UserRechargePo>();
		try {
			userRechargePos = mapper.selectRecharge(phoneAndTimeBo);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return userRechargePos;
	}	
	
	public List<UserConsumptionPo> selectConsumption(PhoneAndTimeBo phoneAndTimeBo) throws Exception {
		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<UserConsumptionPo> userConsumptionPos = new ArrayList<UserConsumptionPo>();
		try {
			userConsumptionPos = mapper.selectConsumption(phoneAndTimeBo);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return userConsumptionPos;
	}
		
	public int insertPayment(PhonePaymentAndRemarkBo phonePaymentAndRemarkBo) throws Exception {
		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		try {
			mapper.insertPayment(phonePaymentAndRemarkBo);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	
	public int undateBalance(PhonePaymentAndRemarkBo phonePaymentAndRemarkBo) throws Exception {
		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		try {
			mapper.undateBalance(phonePaymentAndRemarkBo);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}


}
