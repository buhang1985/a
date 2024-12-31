package iih.pe.pwf.dto.pereportinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 专科检查和医技检查项目信息 DTO数据 
 * 
 */
public class OtherInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	/**
	 * 显示序号
	 * @return Integer
	 */
	public Integer getSeqno() {
		return ((Integer) getAttrVal("Seqno"));
	}
	/**
	 * 显示序号
	 * @param Seqno
	 */
	public void setSeqno(Integer Seqno) {
		setAttrVal("Seqno", Seqno);
	}
	/**
	 * 专科编码
	 * @return String
	 */
	public String getOtherinfocode() {
		return ((String) getAttrVal("Otherinfocode"));
	}
	/**
	 * 专科编码
	 * @param Otherinfocode
	 */
	public void setOtherinfocode(String Otherinfocode) {
		setAttrVal("Otherinfocode", Otherinfocode);
	}
	/**
	 * 专科名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 专科名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 小结建议完整内容
	 * @return String
	 */
	public String getFullcontent() {
		return ((String) getAttrVal("Fullcontent"));
	}
	/**
	 * 小结建议完整内容
	 * @param Fullcontent
	 */
	public void setFullcontent(String Fullcontent) {
		setAttrVal("Fullcontent", Fullcontent);
	}
	/**
	 * 医生编码(报告人)
	 * @return String
	 */
	public String getRptdoccode() {
		return ((String) getAttrVal("Rptdoccode"));
	}
	/**
	 * 医生编码(报告人)
	 * @param Rptdoccode
	 */
	public void setRptdoccode(String Rptdoccode) {
		setAttrVal("Rptdoccode", Rptdoccode);
	}
	/**
	 * 医生名称
	 * @return String
	 */
	public String getRptdocname() {
		return ((String) getAttrVal("Rptdocname"));
	}
	/**
	 * 医生名称
	 * @param Rptdocname
	 */
	public void setRptdocname(String Rptdocname) {
		setAttrVal("Rptdocname", Rptdocname);
	}
	/**
	 * 审核人编码
	 * @return String
	 */
	public String getRvdoccode() {
		return ((String) getAttrVal("Rvdoccode"));
	}
	/**
	 * 审核人编码
	 * @param Rvdoccode
	 */
	public void setRvdoccode(String Rvdoccode) {
		setAttrVal("Rvdoccode", Rvdoccode);
	}
	/**
	 * 审核人名称
	 * @return String
	 */
	public String getRvdocname() {
		return ((String) getAttrVal("Rvdocname"));
	}
	/**
	 * 审核人名称
	 * @param Rvdocname
	 */
	public void setRvdocname(String Rvdocname) {
		setAttrVal("Rvdocname", Rvdocname);
	}
	/**
	 * 检查项目详细信息
	 * @return FArrayList2
	 */
	public FArrayList2 getCkitem() {
		return ((FArrayList2) getAttrVal("Ckitem"));
	}
	/**
	 * 检查项目详细信息
	 * @param Ckitem
	 */
	public void setCkitem(FArrayList2 Ckitem) {
		setAttrVal("Ckitem", Ckitem);
	}
	/**
	 * 小结诊断建议详细信息
	 * @return FArrayList2
	 */
	public FArrayList2 getBrisummary() {
		return ((FArrayList2) getAttrVal("Brisummary"));
	}
	/**
	 * 小结诊断建议详细信息
	 * @param Brisummary
	 */
	public void setBrisummary(FArrayList2 Brisummary) {
		setAttrVal("Brisummary", Brisummary);
	}
	/**
	 * 图像信息(整个科室提供的图像信息)
	 * @return FArrayList2
	 */
	public FArrayList2 getImagecontent() {
		return ((FArrayList2) getAttrVal("Imagecontent"));
	}
	/**
	 * 图像信息(整个科室提供的图像信息)
	 * @param Imagecontent
	 */
	public void setImagecontent(FArrayList2 Imagecontent) {
		setAttrVal("Imagecontent", Imagecontent);
	}
}