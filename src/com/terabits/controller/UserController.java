package com.terabits.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.terabits.meta.bo.PhoneAndTimeBo;
import com.terabits.meta.bo.PhonePaymentAndRemarkBo;
import com.terabits.meta.vo.ConsumptionVo;
import com.terabits.meta.vo.RechargeVo;
import com.terabits.service.UserService;
import com.terabits.utils.UserQueryTest;

import net.sf.json.JSONArray;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user/recharge", method=RequestMethod.GET)
	public String user_recharge(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String Authorization = request.getParameter("authorization");
		if (!Authorization.equals("token")) {
			System.out.println("未授权许可");
			return "0";
		} else {
			String phoneString = request.getParameter("phone");
			String beginTimeString = request.getParameter("beginTime");
			String endTimeString = request.getParameter("endTime");
			if (beginTimeString.equals("")) {
				beginTimeString="2000-01-01 00:0:00";
			}
			if (endTimeString.equals("")) {
				endTimeString="2999-12-12 23:59:59";
			}
			PhoneAndTimeBo phoneAndTimeBo = new PhoneAndTimeBo();
			phoneAndTimeBo.setBeginTime(beginTimeString);
			phoneAndTimeBo.setEndTime(endTimeString);
			phoneAndTimeBo.setPhone(phoneString);
			List<RechargeVo> rechargeVos = userService.getRecharges(phoneAndTimeBo);
//			JSONArray jsonArray = JSONArray.fromObject(rechargeVos);
//			response.getWriter().println(jsonArray);


			UserQueryTest userQueryTest = new UserQueryTest();
			userQueryTest.user_recharge_test(rechargeVos);
//			System.out.println(phoneAndTimeBo.getBeginTime()+"  "+phoneAndTimeBo.getEndTime()+"  "+phoneAndTimeBo.getPhone());
			System.out.println(rechargeVos.size());
			return "1";
		}
	}
	
	@RequestMapping(value="/user/consumption", method = RequestMethod.GET)
	public String user_consumption(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String Authorozation = request.getParameter("authorization");
		if (!Authorozation.equals("token")) {
			System.out.println("未授权许可");
			return "0";
		} else {
			String phoneString = request.getParameter("phone");
			String beginTimeString = request.getParameter("beginTime");
			String endTimeString = request.getParameter("endTime");
			if (beginTimeString.equals("")) {
				beginTimeString="2000-01-01 00:0:00";
			}
			if (endTimeString.equals("")) {
				endTimeString="2999-12-12 23:59:59";
			}
			PhoneAndTimeBo phoneAndTimeBo = new PhoneAndTimeBo();
			phoneAndTimeBo.setBeginTime(beginTimeString);
			phoneAndTimeBo.setEndTime(endTimeString);
			phoneAndTimeBo.setPhone(phoneString);
			List<ConsumptionVo> consumptionVos = new ArrayList<ConsumptionVo>();
			consumptionVos = userService.getConssumptions(phoneAndTimeBo);
//			JSONArray jsonArray = JSONArray.fromObject(consumptionVos);
//			response.getWriter().println(jsonArray);
			UserQueryTest userQueryTest = new UserQueryTest();
			userQueryTest.user_consumption_test(consumptionVos);
			System.out.println("Size of consumptionVos: "+consumptionVos.size());
			return "1";
		}
	}
	
	@RequestMapping(value="/user/recharge", method = RequestMethod.POST)
	public String user_recharge_post(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String Authorization = request.getParameter("authorization");
		if (!Authorization.equals("token")) {			
			System.out.println("未授权许可");
			return "0";
		}else {
			String phoneString = request.getParameter("phone");
			String payment = request.getParameter("money");
			String remarkString = request.getParameter("remark");
			Double paymentDouble = Double.valueOf(payment).doubleValue();
			int paymentint = Integer.parseInt(payment);
			if (paymentDouble != (double)paymentint) {
				System.out.println("请输入整数");
				return "0";
			} else {
				PhonePaymentAndRemarkBo phonePaymentAndRemarkBo = new PhonePaymentAndRemarkBo();
				phonePaymentAndRemarkBo.setPayment(paymentDouble);
				phonePaymentAndRemarkBo.setPhone(phoneString);
				phonePaymentAndRemarkBo.setRemark(remarkString);
				userService.getInsert(phonePaymentAndRemarkBo);
				userService.getUpdate(phonePaymentAndRemarkBo);
				
				return "1";
			}
		}
	}

}
