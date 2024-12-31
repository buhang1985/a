package  iih.nm.nom.dto;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDouble;

/**
 * 护理质量管理月数据 DTO数据 
 * 
 */
public class NomQualityMonthDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 质量管理月数据Id
	 * @return String
	 */
	public String getId_nomquality_mon() {
		return ((String) getAttrVal("Id_nomquality_mon"));
	}
	/**
	 * 质量管理月数据Id
	 * @param Id_nomquality_mon
	 */
	public void setId_nomquality_mon(String Id_nomquality_mon) {
		setAttrVal("Id_nomquality_mon", Id_nomquality_mon);
	}
	/**
	 * 月份值
	 * @return Integer
	 */
	public String getDt_month() {
		return ((String) getAttrVal("Dt_month"));
	}
	/**
	 * 月份值
	 * @param Dt_month
	 */
	public void setDt_month(String Dt_month) {
		setAttrVal("Dt_month", Dt_month);
	}
	/**
	 * 目标值
	 * @return FDouble
	 */
	public FDouble getTarget_value() {
		return ((FDouble) getAttrVal("Target_value"));
	}
	/**
	 * 目标值
	 * @param Target_value
	 */
	public void setTarget_value(FDouble Target_value) {
		setAttrVal("Target_value", Target_value);
	}
	/**
	 * 预警值
	 * @return FDouble
	 */
	public FDouble getWarn_value() {
		return ((FDouble) getAttrVal("Warn_value"));
	}
	/**
	 * 预警值
	 * @param Warn_value
	 */
	public void setWarn_value(FDouble Warn_value) {
		setAttrVal("Warn_value", Warn_value);
	}
	/**
	 * 实际值
	 * @return FDouble
	 */
	public FDouble getActaul_value() {
		return ((FDouble) getAttrVal("Actaul_value"));
	}
	/**
	 * 实际值
	 * @param Actaul_value
	 */
	public void setActaul_value(FDouble Actaul_value) {
		setAttrVal("Actaul_value", Actaul_value);
	}
}