package iih.mp.nr.testreportinfo.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 报告医生信息 DTO数据 
 * 
 */
public class ReportDoctorInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 报告日期
	 * @return FDateTime
	 */
	public FDateTime getReportdate() {
		return ((FDateTime) getAttrVal("Reportdate"));
	}
	/**
	 * 报告日期
	 * @param Reportdate
	 */
	public void setReportdate(FDateTime Reportdate) {
		setAttrVal("Reportdate", Reportdate);
	}
	/**
	 * 报告医生编码
	 * @return String
	 */
	public String getReporterid() {
		return ((String) getAttrVal("Reporterid"));
	}
	/**
	 * 报告医生编码
	 * @param Reporterid
	 */
	public void setReporterid(String Reporterid) {
		setAttrVal("Reporterid", Reporterid);
	}
	/**
	 * 报告医生名称
	 * @return String
	 */
	public String getReportername() {
		return ((String) getAttrVal("Reportername"));
	}
	/**
	 * 报告医生名称
	 * @param Reportername
	 */
	public void setReportername(String Reportername) {
		setAttrVal("Reportername", Reportername);
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