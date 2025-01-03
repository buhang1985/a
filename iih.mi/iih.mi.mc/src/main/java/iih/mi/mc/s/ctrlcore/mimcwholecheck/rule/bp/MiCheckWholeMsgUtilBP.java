package iih.mi.mc.s.ctrlcore.mimcwholecheck.rule.bp;

import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;

public class MiCheckWholeMsgUtilBP {

	/**
	 * 获取单方错误信息
	 * 
	 * @param orName
	 *            服务名称
	 * @return
	 */
	public static String getSinglePresErrorMsg(String orName, String mmName) {
		return orName +  (getMmName(mmName))  + ":\r\n该中药饮片是单方药，需要自费！";
	}

	/**
	 * 获取慢病或特病超量限制消息
	 * 
	 * @param orName
	 *            医嘱名称
	 * @param limitDays
	 *            显示天数
	 * @param orDays
	 *            开立天数
	 * @param unit
	 *            单位
	 * @return
	 */
	public static String getChronicOrSpecExcessMsg(String orName, String mmName, FDouble limitDays, Integer orDays, String unit) {
		return orName +  (getMmName(mmName)) + ":\r\n门诊开单使用" + unit + "数超过" + limitDays + unit + "，当前开单使用" + unit + "数为" + orDays + "，违反医保规定";
	}
	
	/**
	 * 获取慢病或特病超量(使用)限制消息
	 * @description:
	 * @author:hanjq  2020年7月8日
	 * @param orName
	 * @param mmName
	 * @param limitDays
	 * @param orDays
	 * @param unit
	 * @return
	 */
	public static String getChronicOrDosageExcessMsg(String orName, String mmName, Integer limitDays, Integer orDays, String unit) {
		return orName +  (getMmName(mmName)) + ":\r\n门诊开单使用" + unit + "数超过" + limitDays + unit + "，当前开单使用" + unit + "数为" + orDays + "，违反医保规定";
	}
	
	/**
	 * 获取慢病或特病超量限制消息（总量控制下）
	 * 
	 * @param orName
	 *            医嘱名称
	 * @param limitDays
	 *            显示天数
	 * @param orDays
	 *            开立天数
	 * @param unit
	 *            单位
	 * @return
	 */
	public static String getSpecExcessMsg(String orName, String mmName, FDouble limitDays, String limitUnit ,FDouble orDays, String unit,FDouble exceQuan) {
//		String msg= orName +  (getMmName(mmName)) + ":\r\n限制数量为" + limitDays + limitUnit + "，当前开单数量为" + orDays + unit + ",";
//		if(FDoubleUtils.isMoreThanOne(hisQuan)){
//			msg += "\r\n历史已开单数量为"+ hisQuan + unit +",";
//		}
//		msg +="违反医保规定";
		String msg= orName +  (getMmName(mmName)) + ":\r\n        限制数量为：" + limitDays + limitUnit + "\r\n        已开(含本次)：" + orDays + unit + ""
				+"\r\n        超出量："+ exceQuan +unit;
		return msg;
	}

	/**
	 * 获取行动不便超量限制消息
	 * 
	 * @param orName
	 *            医嘱名称
	 * @param limitDays
	 *            显示天数
	 * @param orDays
	 *            开立天数
	 * @param unit
	 *            单位
	 * @return
	 */
	public static String getDiffToMoveMsgExcessMsg(String orName,  String mmName, Integer limitDays, Integer orDays, String unit) {
		return orName +  (getMmName(mmName)) + ":\r\n门诊开单超过" + limitDays + unit + "(行动不便)，当前开单" + unit + "数为" + orDays + "，违反医保规定！";
	}
	
	/**
	 * 获取行动不便超量(使用)限制消息
	 * @description:
	 * @author:hanjq  2020年7月8日
	 * @param orName
	 * @param mmName
	 * @param limitDays
	 * @param orDays
	 * @param unit
	 * @return
	 */
	public static String getDiffToMoveDosageMsgExcessMsg(String orName,  String mmName, Integer limitDays, Integer orDays, String unit) {
		return orName +  (getMmName(mmName)) + ":\r\n门诊开单超过" + limitDays + unit + "(行动不便)，当前开单使用" + unit + "数为" + orDays + "，违反医保规定！";
	}

	/**
	 * 获取门诊开立超量限制消息
	 * 
	 * @param orName
	 *            医嘱名称
	 * @param limitDays
	 *            显示天数
	 * @param orDays
	 *            开立天数
	 * @param unit
	 *            单位
	 * @return
	 */
	public static String getBillExcessMsg(String orName, String mmName, Integer limitDays, Integer orDays, String unit) {
		return orName + (getMmName(mmName))  + ":\r\n门诊开单超过" + limitDays + unit + "，当前开单" + unit + "数为" + orDays + "，违反医保规定！";
	}
	
	/**
	 * 获取门诊开立超量(使用)限制消息
	 * @description:
	 * @author:hanjq  2020年7月8日
	 * @param orName
	 * @param mmName
	 * @param limitDays
	 * @param orDays
	 * @param unit
	 * @return
	 */
	public static String getBillDosageExcessMsg(String orName, String mmName, Integer limitDays, Integer orDays, String unit) {
		return orName + (getMmName(mmName))  + ":\r\n门诊开单超过" + limitDays + unit + "，当前开单使用" + unit + "数为" + orDays + "，违反医保规定！";
	}

	/**
	 * 门诊持有量限制
	 * 
	 * @param orName
	 * @param limitDays
	 * @param orDays
	 * @return
	 */
	public static String GetCheckOpHoldMsg(String orName, String mmName, Integer limitDays, Integer orDays) {
		return orName + (getMmName(mmName)) + ":\r\n历史持有量超过" + limitDays + "天，当前历史持有量天数为" + orDays + "，违反医保规定！";
	}

	/**
	 * 门诊持有量限制详细提示信息
	 * 
	 * @param orName
	 * @param limitDays
	 * @param orDays
	 * @return
	 */
	public static String GetCheckOpHoldDetailsMsg(String kdDate, String deptname, String doctor, Integer orDays) {
		return "\r\n该患者在" + kdDate + "在" + deptname + doctor + "医生处已开过此药用药" + orDays + "天;";
	}

	/**
	 * 急诊领量 限制
	 * 
	 * @param orName
	 * @param limitDays
	 * @param orDays
	 * @param unit
	 *            单位
	 * @return
	 */
	public static String GetCheckEmPickMsg(String orName, String mmName, Integer limitDays, Integer orDays, String unit) {
		return orName + (getMmName(mmName)) + ":\r\n急诊开单" + unit + "数超过" + limitDays + unit + "，当前开单" + unit + "数为" + orDays + "，违反医保规定！";
	}

	/**
	 * 放射类医嘱限制CT
	 * 
	 * @return
	 */
	public static String GetCheckRadiationMsg() {
		return "存在多条放射类医嘱，请注意分开安排执行时间！";
	}

	/**
	 * 重复开药限制
	 * 
	 * @param orName
	 * @return
	 */
	public static String GetCheckReBillMsg(String orName, String mmName) {
		return orName + (getMmName(mmName)) + ":\r\n违反每日限开1次的限制！";
	}

	/**
	 * 删除诊断时，是否存在不合格数据
	 * 
	 * @param orName
	 * @return
	 */
	public static String GetCheckMsg(String orName, String mmName, Integer limitDays, Integer orDays) {
		return orName + (getMmName(mmName)) + ":\r\n开单天数超过" + limitDays + "天，当前开单天数为" + orDays + "，违反医保规定！";
	}
	
	/**
	 * 获取物品名称
	 * 
	 * @param mmList
	 * @return
	 */
	private static String getMmName(String mmName) {
		return !StringUtil.isEmpty(mmName)?mmName = "(" + mmName + ")":"";
	}
}
