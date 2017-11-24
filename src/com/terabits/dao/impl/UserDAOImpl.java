package com.terabits.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.terabits.dao.UserDAO;
import com.terabits.mapper.UserMapper;
import com.terabits.meta.vo.ConsumptionVo;
import com.terabits.meta.vo.RechargeVo;
import com.terabits.utils.DBTools;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO{
	
	public List<RechargeVo> selectRecharge(String beginTime, String endTime, String phone) throws Exception {
		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<RechargeVo> rechargeVos = new ArrayList<RechargeVo>();
		try {
			rechargeVos = mapper.selectRecharge(beginTime, endTime, phone);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return rechargeVos;
	}	
	
	public List<ConsumptionVo> selectConsumption(String beginTime, String endTime, String phone) throws Exception {
		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<ConsumptionVo> consumptionVos = new ArrayList<ConsumptionVo>();
		try {
			consumptionVos = mapper.selectConsumption(beginTime, endTime, phone);
			session.commit();						
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return consumptionVos;
	}
	
	public long selectSiteIdByDeviceId(String deviceid) throws Exception {
		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		long siteid=0;
		try {
			siteid = mapper.selectSiteIdByDeviceId(deviceid);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return siteid;
	}
	
	public String selectMarkBySiteId(long siteid) throws Exception {
		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		String mark="";
		try {
			mark = mapper.selectMarkBySiteId(siteid);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return mark;
	}
		
	public int insertPayment(String phone, int paymeny) throws Exception {
		SqlSession session = DBTools.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		try {
			mapper.insertPayment(phone, paymeny);
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
