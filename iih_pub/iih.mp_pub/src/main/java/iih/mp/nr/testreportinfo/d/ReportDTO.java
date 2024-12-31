package iih.mp.nr.testreportinfo.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 检验项信息 DTO数据 
 * 
 */
public class ReportDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 检验项编码
	 * @return String
	 */
	public String getLabitemcode() {
		return ((String) getAttrVal("Labitemcode"));
	}
	/**
	 * 检验项编码
	 * @param Labitemcode
	 */
	public void setLabitemcode(String Labitemcode) {
		setAttrVal("Labitemcode", Labitemcode);
	}
	/**
	 * 检验项名称
	 * @return String
	 */
	public String getLabitemname() {
		return ((String) getAttrVal("Labitemname"));
	}
	/**
	 * 检验项名称
	 * @param Labitemname
	 */
	public void setLabitemname(String Labitemname) {
		setAttrVal("Labitemname", Labitemname);
	}
	/**
	 * 检验子项信息
	 * @return FArrayList
	 */
	public FArrayList getSubiteminfo() {
		return ((FArrayList) getAttrVal("Subiteminfo"));
	}
	/**
	 * 检验子项信息
	 * @param Subiteminfo
	 */
	public void setSubiteminfo(FArrayList Subiteminfo) {
		setAttrVal("Subiteminfo", Subiteminfo);
	}
	/**
	 * 报告号
	 * @return String
	 */
	public String getReportno() {
		return ((String) getAttrVal("Reportno"));
	}
	/**
	 * 报告号
	 * @param Reportno
	 */
	public void setReportno(String Reportno) {
		setAttrVal("Reportno", Reportno);
	}
}