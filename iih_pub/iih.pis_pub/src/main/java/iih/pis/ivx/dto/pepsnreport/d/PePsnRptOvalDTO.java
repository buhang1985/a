package iih.pis.ivx.dto.pepsnreport.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检报告-总检内容 DTO数据 
 * 
 */
public class PePsnRptOvalDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体检总检ID
	 * @return String
	 */
	public String getId_pewfoval() {
		return ((String) getAttrVal("Id_pewfoval"));
	}
	/**
	 * 体检总检ID
	 * @param Id_pewfoval
	 */
	public void setId_pewfoval(String Id_pewfoval) {
		setAttrVal("Id_pewfoval", Id_pewfoval);
	}
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
	 * 诊断
	 * @return String
	 */
	public String getDiag() {
		return ((String) getAttrVal("Diag"));
	}
	/**
	 * 诊断
	 * @param Diag
	 */
	public void setDiag(String Diag) {
		setAttrVal("Diag", Diag);
	}
	/**
	 * 建议
	 * @return String
	 */
	public String getSugg() {
		return ((String) getAttrVal("Sugg"));
	}
	/**
	 * 建议
	 * @param Sugg
	 */
	public void setSugg(String Sugg) {
		setAttrVal("Sugg", Sugg);
	}
	/**
	 * 显示次序
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 显示次序
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
}