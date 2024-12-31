package iih.pis.ivx.dto.pepsnreport.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检报告-一般项目 DTO数据 
 * 
 */
public class PePsnRptGenDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 个人预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}
	/**
	 * 个人预约单ID
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	/**
	 * 体检项目ID
	 * @return String
	 */
	public String getId_pesrvitem() {
		return ((String) getAttrVal("Id_pesrvitem"));
	}
	/**
	 * 体检项目ID
	 * @param Id_pesrvitem
	 */
	public void setId_pesrvitem(String Id_pesrvitem) {
		setAttrVal("Id_pesrvitem", Id_pesrvitem);
	}
	/**
	 * 结果
	 * @return String
	 */
	public String getRst() {
		return ((String) getAttrVal("Rst"));
	}
	/**
	 * 结果
	 * @param Rst
	 */
	public void setRst(String Rst) {
		setAttrVal("Rst", Rst);
	}
	/**
	 * 计量单位
	 * @return String
	 */
	public String getUnit() {
		return ((String) getAttrVal("Unit"));
	}
	/**
	 * 计量单位
	 * @param Unit
	 */
	public void setUnit(String Unit) {
		setAttrVal("Unit", Unit);
	}
	/**
	 * 参考范围
	 * @return String
	 */
	public String getPref() {
		return ((String) getAttrVal("Pref"));
	}
	/**
	 * 参考范围
	 * @param Pref
	 */
	public void setPref(String Pref) {
		setAttrVal("Pref", Pref);
	}
	/**
	 * 异常标识符号
	 * @return String
	 */
	public String getMark() {
		return ((String) getAttrVal("Mark"));
	}
	/**
	 * 异常标识符号
	 * @param Mark
	 */
	public void setMark(String Mark) {
		setAttrVal("Mark", Mark);
	}
	/**
	 * 异常标识
	 * @return String
	 */
	public String getFgabn() {
		return ((String) getAttrVal("Fgabn"));
	}
	/**
	 * 异常标识
	 * @param Fgabn
	 */
	public void setFgabn(String Fgabn) {
		setAttrVal("Fgabn", Fgabn);
	}
	/**
	 * 阳性标识
	 * @return String
	 */
	public String getFgposi() {
		return ((String) getAttrVal("Fgposi"));
	}
	/**
	 * 阳性标识
	 * @param Fgposi
	 */
	public void setFgposi(String Fgposi) {
		setAttrVal("Fgposi", Fgposi);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getPname() {
		return ((String) getAttrVal("Pname"));
	}
	/**
	 * 名称
	 * @param Pname
	 */
	public void setPname(String Pname) {
		setAttrVal("Pname", Pname);
	}
	/**
	 * 英文名
	 * @return String
	 */
	public String getPename() {
		return ((String) getAttrVal("Pename"));
	}
	/**
	 * 英文名
	 * @param Pename
	 */
	public void setPename(String Pename) {
		setAttrVal("Pename", Pename);
	}
	/**
	 * 缩写
	 * @return String
	 */
	public String getShortname() {
		return ((String) getAttrVal("Shortname"));
	}
	/**
	 * 缩写
	 * @param Shortname
	 */
	public void setShortname(String Shortname) {
		setAttrVal("Shortname", Shortname);
	}
}