package iih.pi.reg.dto.piimport.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者第三方库导入数据 DTO数据 
 * 
 */
public class PiImportFromThirdDBDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getPatientid() {
		return ((String) getAttrVal("Patientid"));
	}
	/**
	 * 患者id
	 * @param Patientid
	 */
	public void setPatientid(String Patientid) {
		setAttrVal("Patientid", Patientid);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 患者姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 证件类型
	 * @return String
	 */
	public String getSd_idtp() {
		return ((String) getAttrVal("Sd_idtp"));
	}
	/**
	 * 证件类型
	 * @param Sd_idtp
	 */
	public void setSd_idtp(String Sd_idtp) {
		setAttrVal("Sd_idtp", Sd_idtp);
	}
	/**
	 * 身份证号/其他证件号
	 * @return String
	 */
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}
	/**
	 * 身份证号/其他证件号
	 * @param Id_code
	 */
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}
	/**
	 * 性别
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 电话
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}
	/**
	 * 电话
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	/**
	 * 婚姻
	 * @return String
	 */
	public String getSd_marry() {
		return ((String) getAttrVal("Sd_marry"));
	}
	/**
	 * 婚姻
	 * @param Sd_marry
	 */
	public void setSd_marry(String Sd_marry) {
		setAttrVal("Sd_marry", Sd_marry);
	}
	/**
	 * 国籍
	 * @return String
	 */
	public String getSd_country() {
		return ((String) getAttrVal("Sd_country"));
	}
	/**
	 * 国籍
	 * @param Sd_country
	 */
	public void setSd_country(String Sd_country) {
		setAttrVal("Sd_country", Sd_country);
	}
	/**
	 * 民族
	 * @return String
	 */
	public String getSd_nation() {
		return ((String) getAttrVal("Sd_nation"));
	}
	/**
	 * 民族
	 * @param Sd_nation
	 */
	public void setSd_nation(String Sd_nation) {
		setAttrVal("Sd_nation", Sd_nation);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 就诊卡号
	 * @return String
	 */
	public String getCardcode() {
		return ((String) getAttrVal("Cardcode"));
	}
	/**
	 * 就诊卡号
	 * @param Cardcode
	 */
	public void setCardcode(String Cardcode) {
		setAttrVal("Cardcode", Cardcode);
	}
	/**
	 * 健康卡号
	 * @return String
	 */
	public String getHealthno() {
		return ((String) getAttrVal("Healthno"));
	}
	/**
	 * 健康卡号
	 * @param Healthno
	 */
	public void setHealthno(String Healthno) {
		setAttrVal("Healthno", Healthno);
	}
	/**
	 * 现住址区县
	 * @return String
	 */
	public String getSd_adminarea_now() {
		return ((String) getAttrVal("Sd_adminarea_now"));
	}
	/**
	 * 现住址区县
	 * @param Sd_adminarea_now
	 */
	public void setSd_adminarea_now(String Sd_adminarea_now) {
		setAttrVal("Sd_adminarea_now", Sd_adminarea_now);
	}
	/**
	 * 现住址街道
	 * @return String
	 */
	public String getStreet_now() {
		return ((String) getAttrVal("Street_now"));
	}
	/**
	 * 现住址街道
	 * @param Street_now
	 */
	public void setStreet_now(String Street_now) {
		setAttrVal("Street_now", Street_now);
	}
	/**
	 * 出生地址区县
	 * @return String
	 */
	public String getSd_adminarea_birth() {
		return ((String) getAttrVal("Sd_adminarea_birth"));
	}
	/**
	 * 出生地址区县
	 * @param Sd_adminarea_birth
	 */
	public void setSd_adminarea_birth(String Sd_adminarea_birth) {
		setAttrVal("Sd_adminarea_birth", Sd_adminarea_birth);
	}
	/**
	 * 出生地址街道
	 * @return String
	 */
	public String getStreet_birth() {
		return ((String) getAttrVal("Street_birth"));
	}
	/**
	 * 出生地址街道
	 * @param Street_birth
	 */
	public void setStreet_birth(String Street_birth) {
		setAttrVal("Street_birth", Street_birth);
	}
	/**
	 * 联系人姓名
	 * @return String
	 */
	public String getName_cont() {
		return ((String) getAttrVal("Name_cont"));
	}
	/**
	 * 联系人姓名
	 * @param Name_cont
	 */
	public void setName_cont(String Name_cont) {
		setAttrVal("Name_cont", Name_cont);
	}
	/**
	 * 联系人关系
	 * @return String
	 */
	public String getSd_conttp() {
		return ((String) getAttrVal("Sd_conttp"));
	}
	/**
	 * 联系人关系
	 * @param Sd_conttp
	 */
	public void setSd_conttp(String Sd_conttp) {
		setAttrVal("Sd_conttp", Sd_conttp);
	}
	/**
	 * 联系人电话
	 * @return String
	 */
	public String getConttel() {
		return ((String) getAttrVal("Conttel"));
	}
	/**
	 * 联系人电话
	 * @param Conttel
	 */
	public void setConttel(String Conttel) {
		setAttrVal("Conttel", Conttel);
	}
	/**
	 * 卡内余额
	 * @return FDouble
	 */
	public FDouble getAmt_prepay() {
		return ((FDouble) getAttrVal("Amt_prepay"));
	}
	/**
	 * 卡内余额
	 * @param Amt_prepay
	 */
	public void setAmt_prepay(FDouble Amt_prepay) {
		setAttrVal("Amt_prepay", Amt_prepay);
	}
	/**
	 * 备用1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}
	/**
	 * 备用1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 备用2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}
	/**
	 * 备用2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 备用3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}
	/**
	 * 备用3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 备用4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}
	/**
	 * 备用4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 备用5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}
	/**
	 * 备用5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * 备用6
	 * @return String
	 */
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}
	/**
	 * 备用6
	 * @param Def6
	 */
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	/**
	 * 备用7
	 * @return String
	 */
	public String getDef7() {
		return ((String) getAttrVal("Def7"));
	}
	/**
	 * 备用7
	 * @param Def7
	 */
	public void setDef7(String Def7) {
		setAttrVal("Def7", Def7);
	}
	/**
	 * 备用8
	 * @return String
	 */
	public String getDef8() {
		return ((String) getAttrVal("Def8"));
	}
	/**
	 * 备用8
	 * @param Def8
	 */
	public void setDef8(String Def8) {
		setAttrVal("Def8", Def8);
	}
	/**
	 * 备用9
	 * @return String
	 */
	public String getDef9() {
		return ((String) getAttrVal("Def9"));
	}
	/**
	 * 备用9
	 * @param Def9
	 */
	public void setDef9(String Def9) {
		setAttrVal("Def9", Def9);
	}
	/**
	 * 备用10
	 * @return String
	 */
	public String getDef10() {
		return ((String) getAttrVal("Def10"));
	}
	/**
	 * 备用10
	 * @param Def10
	 */
	public void setDef10(String Def10) {
		setAttrVal("Def10", Def10);
	}
	/**
	 * 备用11
	 * @return String
	 */
	public String getDef11() {
		return ((String) getAttrVal("Def11"));
	}
	/**
	 * 备用11
	 * @param Def11
	 */
	public void setDef11(String Def11) {
		setAttrVal("Def11", Def11);
	}
	/**
	 * 备用12
	 * @return String
	 */
	public String getDef12() {
		return ((String) getAttrVal("Def12"));
	}
	/**
	 * 备用12
	 * @param Def12
	 */
	public void setDef12(String Def12) {
		setAttrVal("Def12", Def12);
	}
	/**
	 * 备用13
	 * @return String
	 */
	public String getDef13() {
		return ((String) getAttrVal("Def13"));
	}
	/**
	 * 备用13
	 * @param Def13
	 */
	public void setDef13(String Def13) {
		setAttrVal("Def13", Def13);
	}
	/**
	 * 备用14
	 * @return String
	 */
	public String getDef14() {
		return ((String) getAttrVal("Def14"));
	}
	/**
	 * 备用14
	 * @param Def14
	 */
	public void setDef14(String Def14) {
		setAttrVal("Def14", Def14);
	}
	/**
	 * 备用15
	 * @return String
	 */
	public String getDef15() {
		return ((String) getAttrVal("Def15"));
	}
	/**
	 * 备用15
	 * @param Def15
	 */
	public void setDef15(String Def15) {
		setAttrVal("Def15", Def15);
	}
	/**
	 * 备用16
	 * @return String
	 */
	public String getDef16() {
		return ((String) getAttrVal("Def16"));
	}
	/**
	 * 备用16
	 * @param Def16
	 */
	public void setDef16(String Def16) {
		setAttrVal("Def16", Def16);
	}
	/**
	 * 备用17
	 * @return String
	 */
	public String getDef17() {
		return ((String) getAttrVal("Def17"));
	}
	/**
	 * 备用17
	 * @param Def17
	 */
	public void setDef17(String Def17) {
		setAttrVal("Def17", Def17);
	}
	/**
	 * 备用18
	 * @return String
	 */
	public String getDef18() {
		return ((String) getAttrVal("Def18"));
	}
	/**
	 * 备用18
	 * @param Def18
	 */
	public void setDef18(String Def18) {
		setAttrVal("Def18", Def18);
	}
	/**
	 * 备用19
	 * @return String
	 */
	public String getDef19() {
		return ((String) getAttrVal("Def19"));
	}
	/**
	 * 备用19
	 * @param Def19
	 */
	public void setDef19(String Def19) {
		setAttrVal("Def19", Def19);
	}
	/**
	 * 备用20
	 * @return String
	 */
	public String getDef20() {
		return ((String) getAttrVal("Def20"));
	}
	/**
	 * 备用20
	 * @param Def20
	 */
	public void setDef20(String Def20) {
		setAttrVal("Def20", Def20);
	}
}