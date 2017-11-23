package com.terabits.utils;

import java.util.List;

//import com.terabits.meta.po.UserConsumptionPo;
//import com.terabits.meta.po.UserRechargePo;
import com.terabits.meta.vo.ConsumptionVo;
import com.terabits.meta.vo.RechargeVo;

public class UserQueryTest {
	
	public void user_recharge_test(List<RechargeVo> rechargeVos) {
		for (int i = 0; i < rechargeVos.size(); i++) {
			System.out.print(rechargeVos.get(i).getCreateTime());
			System.out.print("  ");
			System.out.print(rechargeVos.get(i).getPhone());
			System.out.print("  ");
			System.out.println(rechargeVos.get(i).getPayment());
		}
	}
	
	public void user_consumption_test(List<ConsumptionVo> consumptionVos) {
		for (int i = 0; i < consumptionVos.size(); i++) {
			System.out.print(consumptionVos.get(i).getPhone());
			System.out.print("  ");
			System.out.print(consumptionVos.get(i).getCreateTime());
			System.out.print("  ");
			System.out.print(consumptionVos.get(i).getMark());
			System.out.print("  ");
			System.out.println(consumptionVos.get(i).getConsumption());
		}
	}
	
	/*public void user_balance_test(List<UserRechargePo> userRechargePos, List<UserConsumptionPo> userConsumptionPos) {
		System.out.println("Recharge Records: ");
		for (int i = 0; i < userRechargePos.size(); i++) {
			System.out.print("  ");
			System.out.print(userRechargePos.get(i).getId());
			System.out.print("  ");
			System.out.print(userRechargePos.get(i).getName());
			System.out.print("  ");
			System.out.print(userRechargePos.get(i).getTel());
			System.out.print("  ");
			System.out.print(userRechargePos.get(i).getCreateTime());
			System.out.print("  ");
			System.out.print(userRechargePos.get(i).getPayment());
			System.out.print("  ");
			System.out.println(userRechargePos.get(i).getRemark());
		}
		System.out.println("Balance Records: ");
	}*/

}
