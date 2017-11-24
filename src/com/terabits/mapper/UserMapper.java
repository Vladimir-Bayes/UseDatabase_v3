package com.terabits.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.terabits.meta.vo.ConsumptionVo;
import com.terabits.meta.vo.RechargeVo;

public interface UserMapper {
	
	/**
	 * @param beginTime
	 * @param endTime
	 * @param phone
	 * @return
	 * @throws Exception
	 */
	public List<RechargeVo> selectRecharge(@Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("phone") String phone) throws Exception;
	
	/**
	 * @param beginTime
	 * @param endTime
	 * @param phone
	 * @return
	 * @throws Exception
	 */
	public List<ConsumptionVo> selectConsumption(@Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("phone") String phone) throws Exception;
	
	/**
	 * @param deviceid
	 * @return
	 * @throws Exception
	 */
	public long selectSiteIdByDeviceId(@Param("deviceid") String deviceid) throws Exception;
	
	/**
	 * @param siteid
	 * @return
	 * @throws Exception
	 */
	public String selectMarkBySiteId(@Param("siteid") long siteid) throws Exception;
	
	/**
	 * @param phone
	 * @param paymeny
	 * @return
	 * @throws Exception
	 */
	public int insertPayment(@Param("phone") String phone, int paymeny) throws Exception;

}
