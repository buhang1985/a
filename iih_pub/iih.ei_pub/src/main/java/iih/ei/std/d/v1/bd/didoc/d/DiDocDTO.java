package iih.ei.std.d.v1.bd.didoc.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 诊断档案DTO DTO数据 
 * 
 */
public class DiDocDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 诊断标准编码
	 * @return String
	 */
	public String getCode_distd() {
		return ((String) getAttrVal("Code_distd"));
	}	
	/**
	 * 诊断标准编码
	 * @param Code_distd
	 */
	public void setCode_distd(String Code_distd) {
		setAttrVal("Code_distd", Code_distd);
	}
	/**
	 * 诊断标准名称
	 * @return String
	 */
	public String getName_distd() {
		return ((String) getAttrVal("Name_distd"));
	}	
	/**
	 * 诊断标准名称
	 * @param Name_distd
	 */
	public void setName_distd(String Name_distd) {
		setAttrVal("Name_distd", Name_distd);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标识
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
}