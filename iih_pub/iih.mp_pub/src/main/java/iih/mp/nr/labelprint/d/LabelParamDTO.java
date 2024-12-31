package iih.mp.nr.labelprint.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class LabelParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者就诊号
	 * @return String
	 */
	public String getId_ens() {
		return ((String) getAttrVal("Id_ens"));
	}
	/**
	 * 患者就诊号
	 * @param Id_ens
	 */
	public void setId_ens(String Id_ens) {
		setAttrVal("Id_ens", Id_ens);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_split_start() {
		return ((FDateTime) getAttrVal("Dt_split_start"));
	}
	/**
	 * 开始时间
	 * @param Dt_split_start
	 */
	public void setDt_split_start(FDateTime Dt_split_start) {
		setAttrVal("Dt_split_start", Dt_split_start);
	}
	/**
	 * 结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_split_end() {
		return ((FDateTime) getAttrVal("Dt_split_end"));
	}
	/**
	 * 结束时间
	 * @param Dt_split_end
	 */
	public void setDt_split_end(FDateTime Dt_split_end) {
		setAttrVal("Dt_split_end", Dt_split_end);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getId_routes() {
		return ((String) getAttrVal("Id_routes"));
	}
	/**
	 * 用法
	 * @param Id_routes
	 */
	public void setId_routes(String Id_routes) {
		setAttrVal("Id_routes", Id_routes);
	}
	/**
	 * 常临枚举
	 * @return String
	 */
	public String getEnum_long() {
		return ((String) getAttrVal("Enum_long"));
	}
	/**
	 * 常临枚举
	 * @param Enum_long
	 */
	public void setEnum_long(String Enum_long) {
		setAttrVal("Enum_long", Enum_long);
	}
	/**
	 * 打印枚举
	 * @return String
	 */
	public String getEnum_print() {
		return ((String) getAttrVal("Enum_print"));
	}
	/**
	 * 打印枚举
	 * @param Enum_print
	 */
	public void setEnum_print(String Enum_print) {
		setAttrVal("Enum_print", Enum_print);
	}
}