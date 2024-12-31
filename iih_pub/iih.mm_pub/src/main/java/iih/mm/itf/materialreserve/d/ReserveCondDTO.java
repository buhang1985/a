package iih.mm.itf.materialreserve.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 药品预留信息查询条件 DTO数据 
 * 
 */
public class ReserveCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 预留开始时间
	 * @return FDate
	 */
	public FDate getDt_reserve_begin() {
		return ((FDate) getAttrVal("Dt_reserve_begin"));
	}
	/**
	 * 预留开始时间
	 * @param Dt_reserve_begin
	 */
	public void setDt_reserve_begin(FDate Dt_reserve_begin) {
		setAttrVal("Dt_reserve_begin", Dt_reserve_begin);
	}
	/**
	 * 预留结束时间
	 * @return FDate
	 */
	public FDate getDt_reserve_end() {
		return ((FDate) getAttrVal("Dt_reserve_end"));
	}
	/**
	 * 预留结束时间
	 * @param Dt_reserve_end
	 */
	public void setDt_reserve_end(FDate Dt_reserve_end) {
		setAttrVal("Dt_reserve_end", Dt_reserve_end);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 预留状态
	 * @return Integer
	 */
	public Integer getEn_opertype() {
		return ((Integer) getAttrVal("En_opertype"));
	}
	/**
	 * 预留状态
	 * @param En_opertype
	 */
	public void setEn_opertype(Integer En_opertype) {
		setAttrVal("En_opertype", En_opertype);
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
	 * 结存主键
	 * @return String
	 */
	public String getId_bl() {
		return ((String) getAttrVal("Id_bl"));
	}
	/**
	 * 结存主键
	 * @param Id_bl
	 */
	public void setId_bl(String Id_bl) {
		setAttrVal("Id_bl", Id_bl);
	}
	/**
	 * 药品主键
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 药品主键
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
}