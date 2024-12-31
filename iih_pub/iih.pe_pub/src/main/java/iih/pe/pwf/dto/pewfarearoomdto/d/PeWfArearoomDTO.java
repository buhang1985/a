package iih.pe.pwf.dto.pewfarearoomdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检导诊台诊间等候队列 DTO数据 
 * 
 */
public class PeWfArearoomDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体检诊间开关主键标识
	 * @return String
	 */
	public String getId_pewfrmswitch() {
		return ((String) getAttrVal("Id_pewfrmswitch"));
	}
	/**
	 * 体检诊间开关主键标识
	 * @param Id_pewfrmswitch
	 */
	public void setId_pewfrmswitch(String Id_pewfrmswitch) {
		setAttrVal("Id_pewfrmswitch", Id_pewfrmswitch);
	}
	/**
	 * 所属体检功能区
	 * @return String
	 */
	public String getId_pefuncarea() {
		return ((String) getAttrVal("Id_pefuncarea"));
	}
	/**
	 * 所属体检功能区
	 * @param Id_pefuncarea
	 */
	public void setId_pefuncarea(String Id_pefuncarea) {
		setAttrVal("Id_pefuncarea", Id_pefuncarea);
	}
	/**
	 * 所属体检科室
	 * @return String
	 */
	public String getId_pedeptset() {
		return ((String) getAttrVal("Id_pedeptset"));
	}
	/**
	 * 所属体检科室
	 * @param Id_pedeptset
	 */
	public void setId_pedeptset(String Id_pedeptset) {
		setAttrVal("Id_pedeptset", Id_pedeptset);
	}
	/**
	 * 体检诊间ID
	 * @return String
	 */
	public String getId_pediroom() {
		return ((String) getAttrVal("Id_pediroom"));
	}
	/**
	 * 体检诊间ID
	 * @param Id_pediroom
	 */
	public void setId_pediroom(String Id_pediroom) {
		setAttrVal("Id_pediroom", Id_pediroom);
	}
	/**
	 * 在检体检预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}
	/**
	 * 在检体检预约单ID
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	/**
	 * 在检体检客户ID
	 * @return String
	 */
	public String getId_pepsnbinfo() {
		return ((String) getAttrVal("Id_pepsnbinfo"));
	}
	/**
	 * 在检体检客户ID
	 * @param Id_pepsnbinfo
	 */
	public void setId_pepsnbinfo(String Id_pepsnbinfo) {
		setAttrVal("Id_pepsnbinfo", Id_pepsnbinfo);
	}
	/**
	 * 体检时间
	 * @return FDate
	 */
	public FDate getDt_pe() {
		return ((FDate) getAttrVal("Dt_pe"));
	}
	/**
	 * 体检时间
	 * @param Dt_pe
	 */
	public void setDt_pe(FDate Dt_pe) {
		setAttrVal("Dt_pe", Dt_pe);
	}
	/**
	 * 性别限制
	 * @return Integer
	 */
	public Integer getSexlimit() {
		return ((Integer) getAttrVal("Sexlimit"));
	}
	/**
	 * 性别限制
	 * @param Sexlimit
	 */
	public void setSexlimit(Integer Sexlimit) {
		setAttrVal("Sexlimit", Sexlimit);
	}
	/**
	 * 开关状态
	 * @return FBoolean
	 */
	public FBoolean getFg_open() {
		return ((FBoolean) getAttrVal("Fg_open"));
	}
	/**
	 * 开关状态
	 * @param Fg_open
	 */
	public void setFg_open(FBoolean Fg_open) {
		setAttrVal("Fg_open", Fg_open);
	}
	/**
	 * VIP标识
	 * @return String
	 */
	public String getFg_vip() {
		return ((String) getAttrVal("Fg_vip"));
	}
	/**
	 * VIP标识
	 * @param Fg_vip
	 */
	public void setFg_vip(String Fg_vip) {
		setAttrVal("Fg_vip", Fg_vip);
	}
	/**
	 * 护士
	 * @return String
	 */
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}
	/**
	 * 护士
	 * @param Id_nur
	 */
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	/**
	 * 医生
	 * @return String
	 */
	public String getId_doc() {
		return ((String) getAttrVal("Id_doc"));
	}
	/**
	 * 医生
	 * @param Id_doc
	 */
	public void setId_doc(String Id_doc) {
		setAttrVal("Id_doc", Id_doc);
	}
	/**
	 * 等候人数
	 * @return Integer
	 */
	public Integer getWaitings() {
		return ((Integer) getAttrVal("Waitings"));
	}
	/**
	 * 等候人数
	 * @param Waitings
	 */
	public void setWaitings(Integer Waitings) {
		setAttrVal("Waitings", Waitings);
	}
	/**
	 * 已检人数
	 * @return Integer
	 */
	public Integer getChecked() {
		return ((Integer) getAttrVal("Checked"));
	}
	/**
	 * 已检人数
	 * @param Checked
	 */
	public void setChecked(Integer Checked) {
		setAttrVal("Checked", Checked);
	}
	/**
	 * 未检人数
	 * @return Integer
	 */
	public Integer getUnchecked() {
		return ((Integer) getAttrVal("Unchecked"));
	}
	/**
	 * 未检人数
	 * @param Unchecked
	 */
	public void setUnchecked(Integer Unchecked) {
		setAttrVal("Unchecked", Unchecked);
	}
	/**
	 * 弃检人数
	 * @return Integer
	 */
	public Integer getGiveups() {
		return ((Integer) getAttrVal("Giveups"));
	}
	/**
	 * 弃检人数
	 * @param Giveups
	 */
	public void setGiveups(Integer Giveups) {
		setAttrVal("Giveups", Giveups);
	}
	/**
	 * 等候时间
	 * @return Integer
	 */
	public Integer getDu_wait() {
		return ((Integer) getAttrVal("Du_wait"));
	}
	/**
	 * 等候时间
	 * @param Du_wait
	 */
	public void setDu_wait(Integer Du_wait) {
		setAttrVal("Du_wait", Du_wait);
	}
	/**
	 * 护士姓名
	 * @return String
	 */
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}
	/**
	 * 护士姓名
	 * @param Name_nur
	 */
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	/**
	 * 医生姓名
	 * @return String
	 */
	public String getName_doc() {
		return ((String) getAttrVal("Name_doc"));
	}
	/**
	 * 医生姓名
	 * @param Name_doc
	 */
	public void setName_doc(String Name_doc) {
		setAttrVal("Name_doc", Name_doc);
	}
	/**
	 * 在检者性别
	 * @return String
	 */
	public String getSex_psn() {
		return ((String) getAttrVal("Sex_psn"));
	}
	/**
	 * 在检者性别
	 * @param Sex_psn
	 */
	public void setSex_psn(String Sex_psn) {
		setAttrVal("Sex_psn", Sex_psn);
	}
	/**
	 * 在检者姓名
	 * @return String
	 */
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}
	/**
	 * 在检者姓名
	 * @param Name_psn
	 */
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
	}
	/**
	 * 等候1
	 * @return String
	 */
	public String getWaitpsn1() {
		return ((String) getAttrVal("Waitpsn1"));
	}
	/**
	 * 等候1
	 * @param Waitpsn1
	 */
	public void setWaitpsn1(String Waitpsn1) {
		setAttrVal("Waitpsn1", Waitpsn1);
	}
	/**
	 * 等候2
	 * @return String
	 */
	public String getWaitpsn2() {
		return ((String) getAttrVal("Waitpsn2"));
	}
	/**
	 * 等候2
	 * @param Waitpsn2
	 */
	public void setWaitpsn2(String Waitpsn2) {
		setAttrVal("Waitpsn2", Waitpsn2);
	}
	/**
	 * 等候3
	 * @return String
	 */
	public String getWaitpsn3() {
		return ((String) getAttrVal("Waitpsn3"));
	}
	/**
	 * 等候3
	 * @param Waitpsn3
	 */
	public void setWaitpsn3(String Waitpsn3) {
		setAttrVal("Waitpsn3", Waitpsn3);
	}
	/**
	 * 等候4
	 * @return String
	 */
	public String getWaitpsn4() {
		return ((String) getAttrVal("Waitpsn4"));
	}
	/**
	 * 等候4
	 * @param Waitpsn4
	 */
	public void setWaitpsn4(String Waitpsn4) {
		setAttrVal("Waitpsn4", Waitpsn4);
	}
	/**
	 * 等候5
	 * @return String
	 */
	public String getWaitpsn5() {
		return ((String) getAttrVal("Waitpsn5"));
	}
	/**
	 * 等候5
	 * @param Waitpsn5
	 */
	public void setWaitpsn5(String Waitpsn5) {
		setAttrVal("Waitpsn5", Waitpsn5);
	}
	/**
	 * 等候6
	 * @return String
	 */
	public String getWaitpsn6() {
		return ((String) getAttrVal("Waitpsn6"));
	}
	/**
	 * 等候6
	 * @param Waitpsn6
	 */
	public void setWaitpsn6(String Waitpsn6) {
		setAttrVal("Waitpsn6", Waitpsn6);
	}
	/**
	 * 等候7
	 * @return String
	 */
	public String getWaitpsn7() {
		return ((String) getAttrVal("Waitpsn7"));
	}
	/**
	 * 等候7
	 * @param Waitpsn7
	 */
	public void setWaitpsn7(String Waitpsn7) {
		setAttrVal("Waitpsn7", Waitpsn7);
	}
	/**
	 * 等候8
	 * @return String
	 */
	public String getWaitpsn8() {
		return ((String) getAttrVal("Waitpsn8"));
	}
	/**
	 * 等候8
	 * @param Waitpsn8
	 */
	public void setWaitpsn8(String Waitpsn8) {
		setAttrVal("Waitpsn8", Waitpsn8);
	}
	/**
	 * 等候9
	 * @return String
	 */
	public String getWaitpsn9() {
		return ((String) getAttrVal("Waitpsn9"));
	}
	/**
	 * 等候9
	 * @param Waitpsn9
	 */
	public void setWaitpsn9(String Waitpsn9) {
		setAttrVal("Waitpsn9", Waitpsn9);
	}
	/**
	 * 等候10
	 * @return String
	 */
	public String getWaitpsn10() {
		return ((String) getAttrVal("Waitpsn10"));
	}
	/**
	 * 等候10
	 * @param Waitpsn10
	 */
	public void setWaitpsn10(String Waitpsn10) {
		setAttrVal("Waitpsn10", Waitpsn10);
	}
	/**
	 * 等候11
	 * @return String
	 */
	public String getWaitpsn11() {
		return ((String) getAttrVal("Waitpsn11"));
	}
	/**
	 * 等候11
	 * @param Waitpsn11
	 */
	public void setWaitpsn11(String Waitpsn11) {
		setAttrVal("Waitpsn11", Waitpsn11);
	}
	/**
	 * 等候12
	 * @return String
	 */
	public String getWaitpsn12() {
		return ((String) getAttrVal("Waitpsn12"));
	}
	/**
	 * 等候12
	 * @param Waitpsn12
	 */
	public void setWaitpsn12(String Waitpsn12) {
		setAttrVal("Waitpsn12", Waitpsn12);
	}
	/**
	 * 等候13
	 * @return String
	 */
	public String getWaitpsn13() {
		return ((String) getAttrVal("Waitpsn13"));
	}
	/**
	 * 等候13
	 * @param Waitpsn13
	 */
	public void setWaitpsn13(String Waitpsn13) {
		setAttrVal("Waitpsn13", Waitpsn13);
	}
	/**
	 * 等候14
	 * @return String
	 */
	public String getWaitpsn14() {
		return ((String) getAttrVal("Waitpsn14"));
	}
	/**
	 * 等候14
	 * @param Waitpsn14
	 */
	public void setWaitpsn14(String Waitpsn14) {
		setAttrVal("Waitpsn14", Waitpsn14);
	}
	/**
	 * 等候15
	 * @return String
	 */
	public String getWaitpsn15() {
		return ((String) getAttrVal("Waitpsn15"));
	}
	/**
	 * 等候15
	 * @param Waitpsn15
	 */
	public void setWaitpsn15(String Waitpsn15) {
		setAttrVal("Waitpsn15", Waitpsn15);
	}
	/**
	 * 等候16
	 * @return String
	 */
	public String getWaitpsn16() {
		return ((String) getAttrVal("Waitpsn16"));
	}
	/**
	 * 等候16
	 * @param Waitpsn16
	 */
	public void setWaitpsn16(String Waitpsn16) {
		setAttrVal("Waitpsn16", Waitpsn16);
	}
	/**
	 * 等候17
	 * @return String
	 */
	public String getWaitpsn17() {
		return ((String) getAttrVal("Waitpsn17"));
	}
	/**
	 * 等候17
	 * @param Waitpsn17
	 */
	public void setWaitpsn17(String Waitpsn17) {
		setAttrVal("Waitpsn17", Waitpsn17);
	}
	/**
	 * 等候18
	 * @return String
	 */
	public String getWaitpsn18() {
		return ((String) getAttrVal("Waitpsn18"));
	}
	/**
	 * 等候18
	 * @param Waitpsn18
	 */
	public void setWaitpsn18(String Waitpsn18) {
		setAttrVal("Waitpsn18", Waitpsn18);
	}
	/**
	 * 等候19
	 * @return String
	 */
	public String getWaitpsn19() {
		return ((String) getAttrVal("Waitpsn19"));
	}
	/**
	 * 等候19
	 * @param Waitpsn19
	 */
	public void setWaitpsn19(String Waitpsn19) {
		setAttrVal("Waitpsn19", Waitpsn19);
	}
	/**
	 * 等候20
	 * @return String
	 */
	public String getWaitpsn20() {
		return ((String) getAttrVal("Waitpsn20"));
	}
	/**
	 * 等候20
	 * @param Waitpsn20
	 */
	public void setWaitpsn20(String Waitpsn20) {
		setAttrVal("Waitpsn20", Waitpsn20);
	}
}