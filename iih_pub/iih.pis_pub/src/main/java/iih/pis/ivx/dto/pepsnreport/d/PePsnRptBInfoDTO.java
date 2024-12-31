package iih.pis.ivx.dto.pepsnreport.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检报告-基本资料 DTO数据 
 * 
 */
public class PePsnRptBInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体检预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}
	/**
	 * 体检预约单ID
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	/**
	 * 体检客户ID
	 * @return String
	 */
	public String getId_pepsnbinfo() {
		return ((String) getAttrVal("Id_pepsnbinfo"));
	}
	/**
	 * 体检客户ID
	 * @param Id_pepsnbinfo
	 */
	public void setId_pepsnbinfo(String Id_pepsnbinfo) {
		setAttrVal("Id_pepsnbinfo", Id_pepsnbinfo);
	}
	/**
	 * 体检唯一码
	 * @return String
	 */
	public String getPe_code() {
		return ((String) getAttrVal("Pe_code"));
	}
	/**
	 * 体检唯一码
	 * @param Pe_code
	 */
	public void setPe_code(String Pe_code) {
		setAttrVal("Pe_code", Pe_code);
	}
	/**
	 * 体检流程卡
	 * @return String
	 */
	public String getCardno() {
		return ((String) getAttrVal("Cardno"));
	}
	/**
	 * 体检流程卡
	 * @param Cardno
	 */
	public void setCardno(String Cardno) {
		setAttrVal("Cardno", Cardno);
	}
	/**
	 * 体检团体id
	 * @return String
	 */
	public String getId_pecorpbinfo() {
		return ((String) getAttrVal("Id_pecorpbinfo"));
	}
	/**
	 * 体检团体id
	 * @param Id_pecorpbinfo
	 */
	public void setId_pecorpbinfo(String Id_pecorpbinfo) {
		setAttrVal("Id_pecorpbinfo", Id_pecorpbinfo);
	}
	/**
	 * vip
	 * @return String
	 */
	public String getFg_vip() {
		return ((String) getAttrVal("Fg_vip"));
	}
	/**
	 * vip
	 * @param Fg_vip
	 */
	public void setFg_vip(String Fg_vip) {
		setAttrVal("Fg_vip", Fg_vip);
	}
	/**
	 * 体检登记备注
	 * @return String
	 */
	public String getRmk_pe() {
		return ((String) getAttrVal("Rmk_pe"));
	}
	/**
	 * 体检登记备注
	 * @param Rmk_pe
	 */
	public void setRmk_pe(String Rmk_pe) {
		setAttrVal("Rmk_pe", Rmk_pe);
	}
	/**
	 * 预约卡
	 * @return String
	 */
	public String getPorder() {
		return ((String) getAttrVal("Porder"));
	}
	/**
	 * 预约卡
	 * @param Porder
	 */
	public void setPorder(String Porder) {
		setAttrVal("Porder", Porder);
	}
	/**
	 * 体检时间
	 * @return String
	 */
	public String getDt_pe() {
		return ((String) getAttrVal("Dt_pe"));
	}
	/**
	 * 体检时间
	 * @param Dt_pe
	 */
	public void setDt_pe(String Dt_pe) {
		setAttrVal("Dt_pe", Dt_pe);
	}
	/**
	 * 体检者姓名
	 * @return String
	 */
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}
	/**
	 * 体检者姓名
	 * @param Name_psn
	 */
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
	}
	/**
	 * 出生日期
	 * @return String
	 */
	public String getDt_birth() {
		return ((String) getAttrVal("Dt_birth"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(String Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 移动电话
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}
	/**
	 * 移动电话
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	/**
	 * 照片
	 * @return String
	 */
	public String getPho() {
		return ((String) getAttrVal("Pho"));
	}
	/**
	 * 照片
	 * @param Pho
	 */
	public void setPho(String Pho) {
		setAttrVal("Pho", Pho);
	}
	/**
	 * 体检套餐名称
	 * @return String
	 */
	public String getName_set() {
		return ((String) getAttrVal("Name_set"));
	}
	/**
	 * 体检套餐名称
	 * @param Name_set
	 */
	public void setName_set(String Name_set) {
		setAttrVal("Name_set", Name_set);
	}
	/**
	 * 团体名称
	 * @return String
	 */
	public String getName_corp() {
		return ((String) getAttrVal("Name_corp"));
	}
	/**
	 * 团体名称
	 * @param Name_corp
	 */
	public void setName_corp(String Name_corp) {
		setAttrVal("Name_corp", Name_corp);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}
	/**
	 * 性别
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 尊称
	 * @return String
	 */
	public String getName_call() {
		return ((String) getAttrVal("Name_call"));
	}
	/**
	 * 尊称
	 * @param Name_call
	 */
	public void setName_call(String Name_call) {
		setAttrVal("Name_call", Name_call);
	}
	/**
	 * 体检次数
	 * @return String
	 */
	public String getPe_times() {
		return ((String) getAttrVal("Pe_times"));
	}
	/**
	 * 体检次数
	 * @param Pe_times
	 */
	public void setPe_times(String Pe_times) {
		setAttrVal("Pe_times", Pe_times);
	}
}