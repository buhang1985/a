package iih.bl.comm.util;

import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;

import org.springframework.util.StringUtils;

import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/**
 * 费用消息帮助类
 * 
 * @author yankan
 *
 */
public class BlMsgUtils {
	/**
	 * 获取单方错误信息
	 * 
	 * @param orName
	 *            服务名称
	 * @return
	 */
	public static String getHpPsdErrorMsg(String orName, FArrayList2 mmList) {
		return orName + (getMmName(mmList)) + ":\r\n该中药饮片是单方药，需要自费！";
		// + IBdPpCodeTypeConst.CHECK_CIHP_SAVE_DES_CODE_SPLIT +
		// CiHpCheckFailResultEnum.SINGLEIDSRV;
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
	public static String getChronicOrSpecExcessMsg(String orName, FArrayList2 mmList, Integer limitDays, Integer orDays, String unit) {
		return orName + (getMmName(mmList)) + ":\r\n门诊开单" + unit + "数超过" + limitDays + unit + "，当前开单" + unit + "数为" + orDays + "，违反医保规定";
		// + IBdPpCodeTypeConst.CHECK_CIHP_SAVE_DES_CODE_SPLIT
		// + CiHpCheckFailResultEnum.GREATER_THAN_GET_OEP;
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
	public static String getDiffToMoveMsgExcessMsg(String orName, FArrayList2 mmList, Integer limitDays, Integer orDays, String unit) {
		return orName + (getMmName(mmList)) + ":\r\n门诊开单超过" + limitDays + unit + "(行动不便)，当前开单" + unit + "数为" + orDays + "，违反医保规定！";
		// + IBdPpCodeTypeConst.CHECK_CIHP_SAVE_DES_CODE_SPLIT
		// + CiHpCheckFailResultEnum.GREATER_THAN_GET_OEP;
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
	public static String getBillExcessMsg(String orName, FArrayList2 mmList, Integer limitDays, Integer orDays, String unit) {
		return orName + (getMmName(mmList)) + ":\r\n门诊开单超过" + limitDays + unit + "，当前开单" + unit + "数为" + orDays + "，违反医保规定！";
		// + IBdPpCodeTypeConst.CHECK_CIHP_SAVE_DES_CODE_SPLIT
		// + CiHpCheckFailResultEnum.GREATER_THAN_GET_OEP;
	}

	/**
	 * 门诊持有量限制
	 * 
	 * @param orName
	 * @param limitDays
	 * @param orDays
	 * @return
	 */
	public static String GetCheckOpHoldMsg(String orName, FArrayList2 mmList, Integer limitDays, Integer orDays) {
		return orName + (getMmName(mmList)) + ":\r\n历史持有量超过" + limitDays + "天，当前历史持有量天数为" + orDays + "，违反医保规定！";
		// + IBdPpCodeTypeConst.CHECK_CIHP_SAVE_DES_CODE_SPLIT
		// + CiHpCheckFailResultEnum.GREATER_THAN_OWN_OEP;
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
	public static String GetCheckEmPickMsg(String orName, FArrayList2 mmList, Integer limitDays, Integer orDays, String unit) {
		return orName + (getMmName(mmList)) + ":\r\n急诊开单" + unit + "数超过" + limitDays + unit + "，当前开单" + unit + "数为" + orDays + "，违反医保规定！";
		// + IBdPpCodeTypeConst.CHECK_CIHP_SAVE_DES_CODE_SPLIT
		// + CiHpCheckFailResultEnum.GREATER_THAN_GET_ER;
	}

	/**
	 * 放射类医嘱限制CT
	 * 
	 * @return
	 */
	public static String GetCheckRadiationMsg() {
		return "存在多条放射类医嘱，请注意分开安排执行时间！";
		// + IBdPpCodeTypeConst.CHECK_CIHP_SAVE_DES_CODE_SPLIT
		// + CiHpCheckFailResultEnum.RADIATION_CLASS_ORDER;
	}

	/**
	 * 重复开药限制
	 * 
	 * @param orName
	 * @return
	 */
	public static String GetCheckReBillMsg(String orName, FArrayList2 mmList) {
		return orName + (getMmName(mmList)) + ":\r\n违反每日限开1次的限制！";
		// + IBdPpCodeTypeConst.CHECK_CIHP_SAVE_DES_CODE_SPLIT
		// + CiHpCheckFailResultEnum.REPEAT_PRES_DRUG;
	}

	/**
	 * 删除诊断时，是否存在不合格数据
	 * 
	 * @param orName
	 * @return
	 */
	public static String GetCheckMsg(String orName, FArrayList2 mmList, Integer limitDays, Integer orDays) {
		return orName + (getMmName(mmList)) + ":\r\n开单天数超过" + limitDays + "天，当前开单天数为" + orDays + "，违反医保规定！";
	}

	/**
	 * 获取物品名称
	 * 
	 * @param mmList
	 * @return
	 */
	private static String getMmName(FArrayList2 mmList) {
		String mmName = "";
		if (mmList != null && mmList.size() != 0) {
			for (Object mmObj : mmList) {
				OrdSrvMmDO mmDO = (OrdSrvMmDO) mmObj;
				mmName = mmName + mmDO.getName_mm();
			}
		}
		if (!StringUtil.isEmpty(mmName)) {
			mmName = "(" + mmName + ")";
		}
		return mmName;
	}

	/**
	 * 获取服务的物品
	 * 
	 * @param idOrsrv
	 * @param mmList
	 * @return
	 */
	public static FArrayList2 getOrderMmList(String idOrSrv, String idSrv, FArrayList2 mmList) {
		FArrayList2 retList = new FArrayList2();
		if (!ListUtil.isEmpty(mmList)) {
			for (Object mmObj : mmList) {
				OrdSrvMmDO mmdo = (OrdSrvMmDO) mmObj;
				if (mmdo == null) {
					continue;
				}
				if (!StringUtil.isEmpty(idOrSrv) && idOrSrv.equals(mmdo.getId_orsrv())) {
					retList.add(mmdo);
				} else if (!StringUtil.isEmpty(idSrv) && idSrv.equals(mmdo.getId_srv())) {
					retList.add(mmdo);
				}
			}
		}
		return retList;
	}
	
	//出院核查提示信息 begin
	/**
	 * 检索床位费(只统计主床)是否划价详细提示信息
	 * 
	 * @param fg_Price 是否划价
	 * @return
	 */
	public static String GetCheckBedFeeMsg(FBoolean fg_Price) {
		return FBoolean.TRUE.equals(fg_Price)?"该床位费已划价":"该床位费未划价";
	}
	
	/**
	 * 检索床位费应收和实收是否一致提示信息
	 * @param name_srv 服务名称
	 * @param ysQuan 应收数量
	 * @param shQuan 实收数量
	 * @return
	 */
	public static String GetCheckBedQuanMsg(String name_srv,FDouble ysQuan,FDouble shQuan){
		String str=ysQuan.compareTo(shQuan)>0?"小于":"大于";
		return "\r\n服务("+ name_srv +"),应收数量："+ ysQuan +"，实际收费数量："+ shQuan +"  ，实际收费数量"+ str +"应收数量";
	}
	/**
	 * 检索护理费是否划价详细提示信息
	 * 
	 * @param fg_Price 是否划价
	 * @param srv_name 护理费名称
	 * @param dt_last_cg 护理费最后划价日期
	 * @param dt_end 医嘱停止时间
	 * @return
	 */
	public static String GetCheckNurseFeeMsg(FBoolean fg_Price,String srv_name,FDateTime dt_last_cg,FDateTime dt_end) {
		if (FBoolean.TRUE.equals(fg_Price)){
			return "护理费已经划价";
		}else{
			String message =getCheckNurseMsg(dt_last_cg,dt_end);
			//护理费名称不为空，护理费最后划价日期并且医嘱停止时间为空
			if(!StringUtils.isEmpty(srv_name)){
				if(StringUtils.isEmpty(message)){
					return "\r\n该护理费(" + srv_name + ")未做最后划价";
				}else{
					return "\r\n(" + srv_name + ")"+message;
				}
			}else{
				return message;
			}
		}	
	}
	/**
	 * 护理费提示信息
	 * @param dt_last_cg
	 * @param dt_end
	 * @return
	 */
	private static String getCheckNurseMsg(FDateTime dt_last_cg,FDateTime dt_end){
		if(dt_last_cg==null || dt_end==null){
			return "";
		}
		String str=dt_last_cg.compareTo(dt_end)>0?"大于":"小于";
		return "护理费的最后划价日期为："+ dt_last_cg +"，医嘱的停止时间为："+dt_end +"，实际收费数量"+str +"应收数量";
	}
	/**
	 * 护理费是否划价信息--护理天数大于实际住院天数
	 * @return
	 */
	public static String GetCheckNurseDaysMsg(){
		return "患者的护理费用天数大于实际住院天数！";
	}
	
	/**
	 * 检索持续性医嘱是否划价提示信息
	 * @param srv_name
	 * @param dt_last_cg
	 * @param dt_end
	 * @return
	 */
	public static String GetCheckPrnOrderMsg(String srv_name,FDateTime dt_last_cg,FDateTime dt_end){
		if(dt_last_cg==null || dt_end==null){
			return GetCheckPrnOrderUnPriceMsg(srv_name);
		}
		String str=dt_last_cg.compareTo(dt_end)>0?"大于":"小于";
		return "\r\n医嘱("+ srv_name +")的最后划价日期为："+ dt_last_cg +"，医嘱的停止时间为："+dt_end +"，实际收费数量"+str +"应收数量";
	}
	
	/*
	 *  检索持续性医嘱是否划价提示信息
	 */
	public static String GetCheckPrnOrderUnPriceMsg(String srv_name){
		return "该条持续性医嘱("+ srv_name +")未做最后划价";
	}
	
	/*
	 *  检索持续性医嘱是否划价提示信息
	 */
	public static String GetCheckPrnOrderSucessMsg(){
		return "持续性医嘱已做最后划价";
	}
	
	/**
	 * 检索固定收费包是否划价提示信息
	 * @param fg_price
	 * @return
	 */
	public static String GetCheckFixFeeMsg(FBoolean fg_price){
		return FBoolean.TRUE.equals(fg_price)?"固定收费已划价":"固定收费未划价";
	}
	
	/**
	 * 检索是否有总数为负的项目提示信息
	 * @param name_srv  服务名称
	 * @param quan 数量
	 * @return
	 */
	public static String GetCheckTotalFeeMsg(String name_srv,FDouble quan){
		return "\r\n服务("+ name_srv +"),总数为:"+ quan +",小于0";
	}
	
	/**
	 * 校验按时间收费的项目，不能超过在院时间提示信息
	 * @param name_srv 服务名称
	 * @param quan 小时数
	 * @return
	 */
	public static String GetCheckSrvDataMsg(String name_srv, FDouble quan, String time_type){
		if (time_type.equals("hour"))
			return "\r\n项目("+ name_srv +"),总小时数为:"+ quan +",大于在院时间";
		else if (time_type.equals("day"))
			return "\r\n项目("+ name_srv +"),总天数为:"+ quan +",大于在院时间";
		else if (time_type.equals("minutes"))
			return "\r\n项目("+ name_srv +"),总分钟数为:"+ quan +",大于在院时间";
		else
			return "\r\n项目("+ name_srv +"), ";
	}
	//出院核查提示信息 end
}
