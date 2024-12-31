package iih.ci.mb.bp;

import java.util.ArrayList;
import java.util.List;

import iih.mp.nr.dto.orderview.d.OrStatusDTO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;

public class CalOrderStatusBp {

	/**
	 * 医嘱状态列表
	 */
	private static List<OrStatusDTO> listStatus;

	/**
	 * 设置医嘱状态
	 * 
	 * @param params
	 */
	public void setOrStatus(BaseDTO[] params) {
		if (listStatus == null) {
			initStatusList();
		}
		if (params != null && params.length > 0) {
			for (BaseDTO param : params) {
				String code_entp = getEffictiveStr(param.getAttrVal("Code_entp"));
				String sd_su_or = getEffictiveStr(param.getAttrVal("Sd_su_or"));
				String sd_su_mp = getEffictiveStr(param.getAttrVal("Sd_su_mp"));
				FBoolean fg_stop = getEffictiveBool(param.getAttrVal("Fg_stop"));
				String sd_status = getOrStatus(code_entp, sd_su_or, sd_su_mp, fg_stop);
				if (StringUtil.isEmptyWithTrim(sd_status)) {
					param.setAttrVal("Sd_status", "11");
				} else {
					param.setAttrVal("Sd_status", sd_status);
				}
			}
		}
	}

	/**
	 * 实例化基础状态
	 */
	public void initStatusList() {

		listStatus = new ArrayList<OrStatusDTO>();

		// 门诊状态
		listStatus.add(initStatus("00", "0", "", null, "0"));// 开立
		listStatus.add(initStatus("00", "10", "", null, "10"));// 签署
		listStatus.add(initStatus("00", "10", "1", FBoolean.FALSE, "21"));// 执行中
		listStatus.add(initStatus("00", "10", "1", FBoolean.TRUE, "23"));// 执行中+预停

		listStatus.add(initStatus("00", "50", "0", FBoolean.FALSE, "50"));// 确认+停止
		listStatus.add(initStatus("00", "50", "0", FBoolean.FALSE, "51"));// 执行中+停止

		listStatus.add(initStatus("00", "60", "20", null, "60"));// 完成
		listStatus.add(initStatus("00", "60", "21", null, "61"));// 取消
		listStatus.add(initStatus("00", "60", "22", null, "62"));// 不执行

		listStatus.add(initStatus("00", "70", "", null, "70"));// 作废
		listStatus.add(initStatus("00", "80", "", null, "80"));// 已作废

		// 住院状态
		listStatus.add(initStatus("10", "0", "", null, "0"));// 开立
		listStatus.add(initStatus("10", "10", "", null, "10"));// 签署
		listStatus.add(initStatus("10", "10", "1", FBoolean.FALSE, "21"));// 执行中
		listStatus.add(initStatus("10", "10", "1", FBoolean.TRUE, "23"));// 执行中+预停

		listStatus.add(initStatus("10", "20", "0", null, "20"));// 确认
		listStatus.add(initStatus("10", "20", "0", FBoolean.FALSE, "20"));// 确认
		listStatus.add(initStatus("10", "20", "0", FBoolean.TRUE, "22"));// 确认-预停
		listStatus.add(initStatus("10", "20", "1", FBoolean.FALSE, "21"));// 执行中
		listStatus.add(initStatus("10", "20", "1", FBoolean.TRUE, "23"));// 执行中+预停

		listStatus.add(initStatus("10", "50", "0", FBoolean.TRUE, "50"));// 确认+停止
		listStatus.add(initStatus("10", "50", "1", FBoolean.TRUE, "51"));// 执行中+停止

		listStatus.add(initStatus("10", "60", "20", null, "60"));// 完成
		listStatus.add(initStatus("10", "60", "21", null, "61"));// 取消
		listStatus.add(initStatus("10", "60", "22", null, "62"));// 不执行

		listStatus.add(initStatus("10", "70", "", null, "70"));// 作废
		listStatus.add(initStatus("10", "80", "", null, "80"));// 已作废
	}

	/**
	 * 实例化状态
	 * 
	 * @param code_entp
	 * @param sd_su_or
	 * @param sd_su_mp
	 * @param fg_stop
	 * @param sd_status
	 * @return
	 */
	private OrStatusDTO initStatus(String code_entp, String sd_su_or, String sd_su_mp, FBoolean fg_stop, String sd_status) {
		OrStatusDTO rtn = new OrStatusDTO();
		rtn.setCode_entp(code_entp);
		rtn.setSd_su_or(sd_su_or);
		rtn.setSd_su_mp(sd_su_mp);
		rtn.setFg_stop(fg_stop);
		rtn.setSd_status(sd_status);
		return rtn;
	}

	/**
	 * 计算医嘱显示状态
	 * 
	 * @param code_entp
	 * @param sd_su_or
	 * @param sd_su_mp
	 * @param fg_param_stop
	 * @return
	 */
	public String getOrStatus(String code_entp, String sd_su_or, String sd_su_mp, FBoolean fg_param_stop) {
		for (OrStatusDTO status : listStatus) {
			boolean fg_code_entp = isStrEqual(status.getCode_entp(), code_entp);
			if (!fg_code_entp) {
				continue;
			}
			boolean fg_sd_su_or = isStrEqual(status.getSd_su_or(), sd_su_or);
			if (!fg_sd_su_or) {
				continue;
			}
			boolean fg_sd_su_mp = isStrEqual(status.getSd_su_mp(), sd_su_mp);
			if (!fg_sd_su_mp) {
				continue;
			}
			boolean fg_stop = isFBooleanEqual(status.getFg_stop(), fg_param_stop);
			if (!fg_stop) {
				continue;
			}
			return status.getSd_status();
		}
		return null;
	}

	/**
	 * 获取有效字符串
	 * 
	 * @param obj
	 * @return
	 */
	private String getEffictiveStr(Object obj) {
		if (obj == null) {
			return null;
		} else if (obj instanceof String) {
			return obj.toString();
		}
		return null;
	}

	/**
	 * 获取有效字符串
	 * 
	 * @param obj
	 * @return
	 */
	private FBoolean getEffictiveBool(Object obj) {
		if (obj == null) {
			return null;
		} else if (obj instanceof FBoolean) {
			return new FBoolean(obj.toString());
		}
		return null;
	}

	/**
	 * 字符串是否相等
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	private boolean isStrEqual(String str1, String str2) {
		if (StringUtil.isEmptyWithTrim(str1)) {
			return true;
		}
		if (StringUtil.isEmptyWithTrim(str2)) {
			return false;
		}
		return str1.equals(str2);
	}

	/**
	 * FBoolean是否相等
	 * 
	 * @param fg1
	 * @param fg2
	 * @return
	 */
	private boolean isFBooleanEqual(FBoolean fg1, FBoolean fg2) {
		if (fg1==null || fg2 == null) 
			return true;

		if (fg1 != null && fg2 != null)
			return fg1.equals(fg2);
		return false;
	}
}
