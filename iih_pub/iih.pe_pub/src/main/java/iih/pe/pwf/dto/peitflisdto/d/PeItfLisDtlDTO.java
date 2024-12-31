package iih.pe.pwf.dto.peitflisdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检检验报告结果dto DTO数据 
 * 
 */
public class PeItfLisDtlDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体检检验报告结果主键标识
	 * @return String
	 */
	public String getId_perstlisitm() {
		return ((String) getAttrVal("Id_perstlisitm"));
	}
	/**
	 * 体检检验报告结果主键标识
	 * @param Id_perstlisitm
	 */
	public void setId_perstlisitm(String Id_perstlisitm) {
		setAttrVal("Id_perstlisitm", Id_perstlisitm);
	}
	/**
	 * 体检检验报告ID
	 * @return String
	 */
	public String getId_perstlis() {
		return ((String) getAttrVal("Id_perstlis"));
	}
	/**
	 * 体检检验报告ID
	 * @param Id_perstlis
	 */
	public void setId_perstlis(String Id_perstlis) {
		setAttrVal("Id_perstlis", Id_perstlis);
	}
	/**
	 * 项目编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}
	/**
	 * 项目编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 项目名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 项目名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 检验结果
	 * @return String
	 */
	public String getVal_rstrptlab() {
		return ((String) getAttrVal("Val_rstrptlab"));
	}
	/**
	 * 检验结果
	 * @param Val_rstrptlab
	 */
	public void setVal_rstrptlab(String Val_rstrptlab) {
		setAttrVal("Val_rstrptlab", Val_rstrptlab);
	}
	/**
	 * 最小值
	 * @return String
	 */
	public String getVal_min() {
		return ((String) getAttrVal("Val_min"));
	}
	/**
	 * 最小值
	 * @param Val_min
	 */
	public void setVal_min(String Val_min) {
		setAttrVal("Val_min", Val_min);
	}
	/**
	 * 最大值
	 * @return String
	 */
	public String getVal_max() {
		return ((String) getAttrVal("Val_max"));
	}
	/**
	 * 最大值
	 * @param Val_max
	 */
	public void setVal_max(String Val_max) {
		setAttrVal("Val_max", Val_max);
	}
	/**
	 * 参考范围
	 * @return String
	 */
	public String getVal_reference() {
		return ((String) getAttrVal("Val_reference"));
	}
	/**
	 * 参考范围
	 * @param Val_reference
	 */
	public void setVal_reference(String Val_reference) {
		setAttrVal("Val_reference", Val_reference);
	}
	/**
	 * 单位编码
	 * @return String
	 */
	public String getCode_unit() {
		return ((String) getAttrVal("Code_unit"));
	}
	/**
	 * 单位编码
	 * @param Code_unit
	 */
	public void setCode_unit(String Code_unit) {
		setAttrVal("Code_unit", Code_unit);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}
	/**
	 * 单位
	 * @param Name_unit
	 */
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
	}
	/**
	 * 异常编码
	 * @return String
	 */
	public String getCode_deviate() {
		return ((String) getAttrVal("Code_deviate"));
	}
	/**
	 * 异常编码
	 * @param Code_deviate
	 */
	public void setCode_deviate(String Code_deviate) {
		setAttrVal("Code_deviate", Code_deviate);
	}
	/**
	 * 异常标识
	 * @return String
	 */
	public String getName_deviate() {
		return ((String) getAttrVal("Name_deviate"));
	}
	/**
	 * 异常标识
	 * @param Name_deviate
	 */
	public void setName_deviate(String Name_deviate) {
		setAttrVal("Name_deviate", Name_deviate);
	}
	/**
	 * 危急值标识
	 * @return String
	 */
	public String getFg_crisis() {
		return ((String) getAttrVal("Fg_crisis"));
	}
	/**
	 * 危急值标识
	 * @param Fg_crisis
	 */
	public void setFg_crisis(String Fg_crisis) {
		setAttrVal("Fg_crisis", Fg_crisis);
	}
	/**
	 * 打印次序
	 * @return Integer
	 */
	public Integer getPrintord() {
		return ((Integer) getAttrVal("Printord"));
	}
	/**
	 * 打印次序
	 * @param Printord
	 */
	public void setPrintord(Integer Printord) {
		setAttrVal("Printord", Printord);
	}
}