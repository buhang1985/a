package iih.mp.dg.dto.backdrugdisp.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 摆药查询条件 DTO数据 
 * 
 */
public class MpPrepDispCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 收费日期开始
	 * @return FDateTime
	 */
	public FDateTime getDt_charge_begin() {
		return ((FDateTime) getAttrVal("Dt_charge_begin"));
	}
	/**
	 * 收费日期开始
	 * @param Dt_charge_begin
	 */
	public void setDt_charge_begin(FDateTime Dt_charge_begin) {
		setAttrVal("Dt_charge_begin", Dt_charge_begin);
	}
	/**
	 * 收费日期结束
	 * @return FDateTime
	 */
	public FDateTime getDt_charge_end() {
		return ((FDateTime) getAttrVal("Dt_charge_end"));
	}
	/**
	 * 收费日期结束
	 * @param Dt_charge_end
	 */
	public void setDt_charge_end(FDateTime Dt_charge_end) {
		setAttrVal("Dt_charge_end", Dt_charge_end);
	}
	/**
	 * 是否自动打印
	 * @return FBoolean
	 */
	public FBoolean getFg_autoprint() {
		return ((FBoolean) getAttrVal("Fg_autoprint"));
	}
	/**
	 * 是否自动打印
	 * @param Fg_autoprint
	 */
	public void setFg_autoprint(FBoolean Fg_autoprint) {
		setAttrVal("Fg_autoprint", Fg_autoprint);
	}
	/**
	 * 窗口ID
	 * @return String
	 */
	public String getId_site() {
		return ((String) getAttrVal("Id_site"));
	}
	/**
	 * 窗口ID
	 * @param Id_site
	 */
	public void setId_site(String Id_site) {
		setAttrVal("Id_site", Id_site);
	}
	/**
	 * 窗口名称
	 * @return String
	 */
	public String getName_site() {
		return ((String) getAttrVal("Name_site"));
	}
	/**
	 * 窗口名称
	 * @param Name_site
	 */
	public void setName_site(String Name_site) {
		setAttrVal("Name_site", Name_site);
	}
	/**
	 * 配药人
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 配药人
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 配药人名称
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}
	/**
	 * 配药人名称
	 * @param Name_emp
	 */
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	/**
	 * 病人卡号
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 病人卡号
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 查询摆药状态
	 * @return Integer
	 */
	public Integer getStatus_by() {
		return ((Integer) getAttrVal("Status_by"));
	}
	/**
	 * 查询摆药状态
	 * @param Status_by
	 */
	public void setStatus_by(Integer Status_by) {
		setAttrVal("Status_by", Status_by);
	}
}