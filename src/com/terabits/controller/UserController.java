package com.terabits.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.terabits.meta.po.AdminPO;
import com.terabits.service.AdminService;
import com.terabits.service.UserService;
import com.terabits.utils.JWT;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Controller
public class UserController {
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user/recharge", method=RequestMethod.GET)
	public JSONObject user_recharge(@RequestParam(value="Authorization") String clientToken, 
		HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("status", 0);
		
		AdminPO adminPO = JWT.unsign(clientToken, AdminPO.class);
		if (adminPO == null) {
			return jsonObject;
		}
		if (!adminService.authConfirm(adminPO.getType(), "/user/recharge")) {
			return jsonObject;
		}
		String phoneString = request.getParameter("phone");
		String beginTimeString = request.getParameter("beginTime");
		String endTimeString = request.getParameter("endTime");
		if (beginTimeString.equals("")) {
			beginTimeString="2000-01-01 00:0:00";
		}
		if (endTimeString.equals("")) {
			endTimeString="2999-12-12 23:59:59";
		}
		JSONArray jsonArray= userService.getRecharges(beginTimeString, endTimeString, phoneString);
		jsonObject.put("status", 1);
		jsonObject.put("info", jsonArray);
		return jsonObject;
	}

	@RequestMapping(value="/user/consumption", method = RequestMethod.GET)
	public JSONObject user_consumption(@RequestParam(value="Authorization") String clientToken, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("status", 0);
		
		AdminPO adminPO = JWT.unsign(clientToken, AdminPO.class);
		if (adminPO == null) {
			return jsonObject;
		}
		if (!adminService.authConfirm(adminPO.getType(), "/user/consumption")) {
			return jsonObject;
		}
		String phoneString = request.getParameter("phone");
		String beginTimeString = request.getParameter("beginTime");
		String endTimeString = request.getParameter("endTime");
		if (beginTimeString.equals("")) {
			beginTimeString="2000-01-01 00:0:00";
		}
		if (endTimeString.equals("")) {
			endTimeString="2999-12-12 23:59:59";
		}
		JSONArray jsonArray = userService.getConsumptions(beginTimeString, endTimeString, phoneString);
		jsonObject.put("status", 1);
		jsonObject.put("info", jsonArray);
		return jsonObject;
				
	}
	
	@RequestMapping(value="/user/recharge", method = RequestMethod.POST)
	public JSONObject user_recharge_post(@RequestParam(value="Authorization") String clientToken,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("status", 0);
		AdminPO adminPO = JWT.unsign(clientToken, AdminPO.class);
		if (adminPO == null) { 
			return jsonObject;
		}
		if (!adminService.authConfirm(adminPO.getType(), "/user/recharge")) {
			return jsonObject;
		}
		String phoneString = request.getParameter("phone");
		String payment = request.getParameter("money");
		String comments = request.getParameter("comments");
		String adminname = adminPO.getName();
		
		Double paymentDouble = Double.valueOf(payment).doubleValue();
		int paymentint = Integer.parseInt(payment);
		if (paymentDouble != (double)paymentint) {
			System.out.println("«Î ‰»Î’˚ ˝");
			return jsonObject;			
		} else {					
			jsonObject.put("status", userService.insertPayment(phoneString, paymentint, comments, adminname));
			
			return jsonObject;
		}

	}

}
