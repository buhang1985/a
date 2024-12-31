package iih.bl.cg.s.bp;

import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;

/**
 * 
 * @author yang.lu
 *
 */
public class GetPayCodeBP {
	/**
	 * 获取第三方支付对象对应编码
	 * @param code 录入支付code
	 * @param isIn 是否是接收
	 * @return
	 */
	public PriPmDO exec(String code, boolean isIn) {
		String sd_pm=code, id_pm = "", name_pm="";
		if (isIn) {
			switch (code) {
			case "1":// 支付宝
				sd_pm = IBdPripmCodeConst.CODE_PRI_PM_ALIPAY;
				id_pm = IBdPripmCodeConst.ID_PRI_PM_ALIPAY;
				name_pm = "支付宝";
				break;
			case "2":// 微信
				sd_pm = IBdPripmCodeConst.CODE_PRI_PM_WECHAT;
				id_pm = IBdPripmCodeConst.ID_PRI_PM_WECHAT;
				name_pm = "微信";
				break;
			case "3":// 预交金
				sd_pm = IBdPripmCodeConst.CODE_PRI_PM_PAY;
				id_pm = IBdPripmCodeConst.ID_PRI_PM_PAY;
				name_pm = "预交金";
				break;
			case "4":// 银行卡
				sd_pm = IBdPripmCodeConst.CODE_PRI_PM_CREDIT;
				id_pm = IBdPripmCodeConst.ID_PRI_PM_CREDIT;
				name_pm = "银行卡";
				break;
			case "6":// 医保个人账户
				sd_pm = IBdPripmCodeConst.CODE_PRI_PM_INSURPERSONALACCOUNT;
				id_pm = IBdPripmCodeConst.ID_PRI_PM_INSURPERSONALACCOUNT;
				name_pm = "医保个人账户";
				break;
			case "7"://民生银行
				sd_pm = IBdPripmCodeConst.CODE_PRI_PM_BANK_DIFF;
				id_pm = IBdPripmCodeConst.ID_PRI_PM_BANK_DIFF;
				name_pm="民生银行";
				break;
			}
		} else {

			switch (code) {
			case IBdPripmCodeConst.CODE_PRI_PM_ALIPAY:// 支付宝
				sd_pm = "1";
				id_pm = IBdPripmCodeConst.ID_PRI_PM_ALIPAY;
				name_pm = "支付宝";
				break;
			case IBdPripmCodeConst.CODE_PRI_PM_WECHAT:// 微信
				sd_pm = "2";
				id_pm = IBdPripmCodeConst.ID_PRI_PM_WECHAT;
				name_pm = "微信";
				break;
			case IBdPripmCodeConst.CODE_PRI_PM_PAY:// 预交金
				sd_pm = "3";
				id_pm = IBdPripmCodeConst.ID_PRI_PM_PAY;
				name_pm = "预交金";
				break;
			case IBdPripmCodeConst.CODE_PRI_PM_CREDIT:// 银行卡
				sd_pm = "4";
				id_pm = IBdPripmCodeConst.ID_PRI_PM_CREDIT;
				name_pm = "银行卡";
				break;
			case IBdPripmCodeConst.CODE_PRI_PM_INSURPERSONALACCOUNT:// 医保个人账户
				sd_pm = "6";
				id_pm = IBdPripmCodeConst.ID_PRI_PM_INSURPERSONALACCOUNT;
				name_pm = "医保个人账户";
				break;
			case IBdPripmCodeConst.CODE_PRI_PM_BANK_DIFF://民生银行
				sd_pm = "7";
				id_pm = IBdPripmCodeConst.ID_PRI_PM_BANK_DIFF;
				name_pm="民生银行";	
				break;
			}
		}
		PriPmDO retDo = new PriPmDO();
		retDo.setId_pm(id_pm);
		retDo.setSd_pmtp(sd_pm);
		retDo.setCode(sd_pm);
		retDo.setName(name_pm);
		return retDo;
	}
}
