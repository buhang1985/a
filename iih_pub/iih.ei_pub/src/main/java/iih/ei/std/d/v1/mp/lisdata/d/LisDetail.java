package iih.ei.std.d.v1.mp.lisdata.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 危急值回写检验项目明细 DTO数据 
 * 
 */
public class LisDetail extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 上报项目编码
	 * @return String
	 */
	public String getCode_rptitm() {
		return ((String) getAttrVal("Code_rptitm"));
	}	
	/**
	 * 上报项目编码
	 * @param Code_rptitm
	 */
	public void setCode_rptitm(String Code_rptitm) {
		setAttrVal("Code_rptitm", Code_rptitm);
	}
	/**
	 * 上报项目名称
	 * @return String
	 */
	public String getName_rptitm() {
		return ((String) getAttrVal("Name_rptitm"));
	}	
	/**
	 * 上报项目名称
	 * @param Name_rptitm
	 */
	public void setName_rptitm(String Name_rptitm) {
		setAttrVal("Name_rptitm", Name_rptitm);
	}
	/**
	 * 结果值
	 * @return String
	 */
	public String getVal_rstrptlab() {
		return ((String) getAttrVal("Val_rstrptlab"));
	}	
	/**
	 * 结果值
	 * @param Val_rstrptlab
	 */
	public void setVal_rstrptlab(String Val_rstrptlab) {
		setAttrVal("Val_rstrptlab", Val_rstrptlab);
	}
	/**
	 * 结果状态标志编码
	 * @return String
	 */
	public String getCode_deviate() {
		return ((String) getAttrVal("Code_deviate"));
	}	
	/**
	 * 结果状态标志编码
	 * @param Code_deviate
	 */
	public void setCode_deviate(String Code_deviate) {
		setAttrVal("Code_deviate", Code_deviate);
	}
	/**
	 * 结果状态标志名称
	 * @return String
	 */
	public String getName_deviate() {
		return ((String) getAttrVal("Name_deviate"));
	}	
	/**
	 * 结果状态标志名称
	 * @param Name_deviate
	 */
	public void setName_deviate(String Name_deviate) {
		setAttrVal("Name_deviate", Name_deviate);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}	
	/**
	 * 单位名称
	 * @param Name_unit
	 */
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
	}
	/**
	 * 参考值
	 * @return String
	 */
	public String getVal_reference() {
		return ((String) getAttrVal("Val_reference"));
	}	
	/**
	 * 参考值
	 * @param Val_reference
	 */
	public void setVal_reference(String Val_reference) {
		setAttrVal("Val_reference", Val_reference);
	}
	/**
	 * 上报描述
	 * @return String
	 */
	public String getDescriptions() {
		return ((String) getAttrVal("Descriptions"));
	}	
	/**
	 * 上报描述
	 * @param Descriptions
	 */
	public void setDescriptions(String Descriptions) {
		setAttrVal("Descriptions", Descriptions);
	}
}