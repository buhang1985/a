package iih.mi.biz.dto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FDateTime;

/**
 * 对账查询入参 DTO数据 
 * 
 */
public class MIReclInputDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 业务周期号
	 * @return String
	 */
	public String getBusiness_code() {
		return ((String) getAttrVal("Business_code"));
	}
	/**
	 * 业务周期号
	 * @param Business_code
	 */
	public void setBusiness_code(String Business_code) {
		setAttrVal("Business_code", Business_code);
	}
	/**
	 * 开始日期
	 * @return FDateTime
	 */
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}
	/**
	 * 开始日期
	 * @param Dt_b
	 */
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 结束日期
	 * @return FDateTime
	 */
	public FDateTime getDt_e() {
		return ((FDateTime) getAttrVal("Dt_e"));
	}
	/**
	 * 结束日期
	 * @param Dt_e
	 */
	public void setDt_e(FDateTime Dt_e) {
		setAttrVal("Dt_e", Dt_e);
	}
	/**
	 * 签到日期
	 * @return FDateTime
	 */
	public FDateTime getDt_sign_in() {
		return ((FDateTime) getAttrVal("Dt_sign_in"));
	}
	/**
	 * 签到日期
	 * @param Dt_sign_in
	 */
	public void setDt_sign_in(FDateTime Dt_sign_in) {
		setAttrVal("Dt_sign_in", Dt_sign_in);
	}
	/**
	 * 签退日期
	 * @return FDateTime
	 */
	public FDateTime getDt_sign_out() {
		return ((FDateTime) getAttrVal("Dt_sign_out"));
	}
	/**
	 * 签退日期
	 * @param Dt_sign_out
	 */
	public void setDt_sign_out(FDateTime Dt_sign_out) {
		setAttrVal("Dt_sign_out", Dt_sign_out);
	}
	/**
	 * 操作人姓名
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}
	/**
	 * 操作人姓名
	 * @param Name_emp
	 */
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	/**
	 * 操作人主键
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 操作人主键
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 操作人编码
	 * @return String
	 */
	public String getCode_emp() {
		return ((String) getAttrVal("Code_emp"));
	}
	/**
	 * 操作人编码
	 * @param Code_emp
	 */
	public void setCode_emp(String Code_emp) {
		setAttrVal("Code_emp", Code_emp);
	}
	/**
	 * 对账类型(0:全部,1:住院,2:门诊)
	 * @return String
	 */
	public String getType_rec() {
		return ((String) getAttrVal("Type_rec"));
	}
	/**
	 * 对账类型(0:全部,1:住院,2:门诊)
	 * @param Type_rec
	 */
	public void setType_rec(String Type_rec) {
		setAttrVal("Type_rec", Type_rec);
	}
	/**
	 * 医保计划主键
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保计划主键
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 医保名称
	 * @return String
	 */
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}
	/**
	 * 医保名称
	 * @param Name_hp
	 */
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
	}
	/**
	 * 其他参数
	 * @return FMap2
	 */
	public FMap2 getOth_para() {
		return ((FMap2) getAttrVal("Oth_para"));
	}
	/**
	 * 其他参数
	 * @param Oth_para
	 */
	public void setOth_para(FMap2 Oth_para) {
		setAttrVal("Oth_para", Oth_para);
	}
	/**
	 * 查询方式(0:业务周期号，1：开始和结束日期)
	 * @return String
	 */
	public String getQrytype() {
		return ((String) getAttrVal("Qrytype"));
	}
	/**
	 * 查询方式(0:业务周期号，1：开始和结束日期)
	 * @param Qrytype
	 */
	public void setQrytype(String Qrytype) {
		setAttrVal("Qrytype", Qrytype);
	}
	/**
	 * 签到主键
	 * @return String
	 */
	public String getId_hpsignin() {
		return ((String) getAttrVal("Id_hpsignin"));
	}
	/**
	 * 签到主键
	 * @param Id_hpsignin
	 */
	public void setId_hpsignin(String Id_hpsignin) {
		setAttrVal("Id_hpsignin", Id_hpsignin);
	}
}