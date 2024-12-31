package iih.mp.nr.testreportinfo.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 审核医生信息 DTO数据 
 * 
 */
public class ReviewDoctorInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 审核日期
	 * @return FDateTime
	 */
	public FDateTime getReviewdate() {
		return ((FDateTime) getAttrVal("Reviewdate"));
	}
	/**
	 * 审核日期
	 * @param Reviewdate
	 */
	public void setReviewdate(FDateTime Reviewdate) {
		setAttrVal("Reviewdate", Reviewdate);
	}
	/**
	 * 审核医生角色
	 * @return String
	 */
	public String getReviewerrole() {
		return ((String) getAttrVal("Reviewerrole"));
	}
	/**
	 * 审核医生角色
	 * @param Reviewerrole
	 */
	public void setReviewerrole(String Reviewerrole) {
		setAttrVal("Reviewerrole", Reviewerrole);
	}
	/**
	 * 审核医生编码
	 * @return String
	 */
	public String getReviewerid() {
		return ((String) getAttrVal("Reviewerid"));
	}
	/**
	 * 审核医生编码
	 * @param Reviewerid
	 */
	public void setReviewerid(String Reviewerid) {
		setAttrVal("Reviewerid", Reviewerid);
	}
	/**
	 * 审核医生名称
	 * @return String
	 */
	public String getReviewername() {
		return ((String) getAttrVal("Reviewername"));
	}
	/**
	 * 审核医生名称
	 * @param Reviewername
	 */
	public void setReviewername(String Reviewername) {
		setAttrVal("Reviewername", Reviewername);
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