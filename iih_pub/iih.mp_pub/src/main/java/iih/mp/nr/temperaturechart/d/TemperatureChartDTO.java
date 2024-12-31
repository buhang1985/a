package iih.mp.nr.temperaturechart.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体温单数据源 DTO数据 
 * 
 */
public class TemperatureChartDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者基本信息
	 * @return FArrayList
	 */
	public FArrayList getPatinfo() {
		return ((FArrayList) getAttrVal("Patinfo"));
	}
	/**
	 * 患者基本信息
	 * @param Patinfo
	 */
	public void setPatinfo(FArrayList Patinfo) {
		setAttrVal("Patinfo", Patinfo);
	}
	/**
	 * 手术事件集合
	 * @return FArrayList
	 */
	public FArrayList getOperationlist() {
		return ((FArrayList) getAttrVal("Operationlist"));
	}
	/**
	 * 手术事件集合
	 * @param Operationlist
	 */
	public void setOperationlist(FArrayList Operationlist) {
		setAttrVal("Operationlist", Operationlist);
	}
	/**
	 * 体征数据集合
	 * @return FArrayList
	 */
	public FArrayList getSignslist() {
		return ((FArrayList) getAttrVal("Signslist"));
	}
	/**
	 * 体征数据集合
	 * @param Signslist
	 */
	public void setSignslist(FArrayList Signslist) {
		setAttrVal("Signslist", Signslist);
	}
	/**
	 * 配置文件
	 * @return String
	 */
	public String getCfgxml() {
		return ((String) getAttrVal("Cfgxml"));
	}
	/**
	 * 配置文件
	 * @param Cfgxml
	 */
	public void setCfgxml(String Cfgxml) {
		setAttrVal("Cfgxml", Cfgxml);
	}
	/**
	 * svg配置文件
	 * @return String
	 */
	public String getSvgxml() {
		return ((String) getAttrVal("Svgxml"));
	}
	/**
	 * svg配置文件
	 * @param Svgxml
	 */
	public void setSvgxml(String Svgxml) {
		setAttrVal("Svgxml", Svgxml);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}
	/**
	 * 开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 截止时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 截止时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
}