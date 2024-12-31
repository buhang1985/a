package iih.mp.nr.dto.orgrnt.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱生成参数 DTO数据 
 * 
 */
public class OrGrntParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 病区
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 病区
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 就诊ID串
	 * @return String
	 */
	public String getId_ents() {
		return ((String) getAttrVal("Id_ents"));
	}
	/**
	 * 就诊ID串
	 * @param Id_ents
	 */
	public void setId_ents(String Id_ents) {
		setAttrVal("Id_ents", Id_ents);
	}
	/**
	 * 医嘱ID串
	 * @return String
	 */
	public String getId_ors() {
		return ((String) getAttrVal("Id_ors"));
	}
	/**
	 * 医嘱ID串
	 * @param Id_ors
	 */
	public void setId_ors(String Id_ors) {
		setAttrVal("Id_ors", Id_ors);
	}
	/**
	 * 长临标志
	 * @return FBoolean
	 */
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}
	/**
	 * 长临标志
	 * @param Fg_long
	 */
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	/**
	 * 服务类型串
	 * @return String
	 */
	public String getSd_srvtps() {
		return ((String) getAttrVal("Sd_srvtps"));
	}
	/**
	 * 服务类型串
	 * @param Sd_srvtps
	 */
	public void setSd_srvtps(String Sd_srvtps) {
		setAttrVal("Sd_srvtps", Sd_srvtps);
	}
	/**
	 * 用法串
	 * @return String
	 */
	public String getId_routes() {
		return ((String) getAttrVal("Id_routes"));
	}
	/**
	 * 用法串
	 * @param Id_routes
	 */
	public void setId_routes(String Id_routes) {
		setAttrVal("Id_routes", Id_routes);
	}
	/**
	 * 药品拆分截止时间
	 * @return FDateTime
	 */
	public FDateTime getDt_drug_end() {
		return ((FDateTime) getAttrVal("Dt_drug_end"));
	}
	/**
	 * 药品拆分截止时间
	 * @param Dt_drug_end
	 */
	public void setDt_drug_end(FDateTime Dt_drug_end) {
		setAttrVal("Dt_drug_end", Dt_drug_end);
	}
	/**
	 * 非药品拆分截止时间
	 * @return FDateTime
	 */
	public FDateTime getDt_oth_end() {
		return ((FDateTime) getAttrVal("Dt_oth_end"));
	}
	/**
	 * 非药品拆分截止时间
	 * @param Dt_oth_end
	 */
	public void setDt_oth_end(FDateTime Dt_oth_end) {
		setAttrVal("Dt_oth_end", Dt_oth_end);
	}
	/**
	 * 记账截止时间
	 * @return FDateTime
	 */
	public FDateTime getDt_charge() {
		return ((FDateTime) getAttrVal("Dt_charge"));
	}
	/**
	 * 记账截止时间
	 * @param Dt_charge
	 */
	public void setDt_charge(FDateTime Dt_charge) {
		setAttrVal("Dt_charge", Dt_charge);
	}
}