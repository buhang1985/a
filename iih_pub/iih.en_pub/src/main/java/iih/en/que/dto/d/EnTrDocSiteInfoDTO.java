package iih.en.que.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门急诊医生站信息DTO DTO数据 
 * 
 */
public class EnTrDocSiteInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 诊台id
	 * @return String
	 */
	public String getId_quesite() {
		return ((String) getAttrVal("Id_quesite"));
	}
	/**
	 * 诊台id
	 * @param Id_quesite
	 */
	public void setId_quesite(String Id_quesite) {
		setAttrVal("Id_quesite", Id_quesite);
	}
	/**
	 * 队列id
	 * @return FArrayList
	 */
	public FArrayList getId_ques() {
		return ((FArrayList) getAttrVal("Id_ques"));
	}
	/**
	 * 队列id
	 * @param Id_ques
	 */
	public void setId_ques(FArrayList Id_ques) {
		setAttrVal("Id_ques", Id_ques);
	}
	/**
	 * 午别id
	 * @return String
	 */
	public String getId_dayslot() {
		return ((String) getAttrVal("Id_dayslot"));
	}
	/**
	 * 午别id
	 * @param Id_dayslot
	 */
	public void setId_dayslot(String Id_dayslot) {
		setAttrVal("Id_dayslot", Id_dayslot);
	}
	/**
	 * 日期
	 * @return FDate
	 */
	public FDate getDate() {
		return ((FDate) getAttrVal("Date"));
	}
	/**
	 * 日期
	 * @param Date
	 */
	public void setDate(FDate Date) {
		setAttrVal("Date", Date);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 医生id
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 医生id
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 科室id
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 科室id
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 分诊台id
	 * @return String
	 */
	public String getId_queben() {
		return ((String) getAttrVal("Id_queben"));
	}
	/**
	 * 分诊台id
	 * @param Id_queben
	 */
	public void setId_queben(String Id_queben) {
		setAttrVal("Id_queben", Id_queben);
	}
}