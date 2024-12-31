package iih.pe.pwf.dto.pereportinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 健康指导建议信息 DTO数据 
 * 
 */
public class HealthGuideDTO extends BaseDTO {
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
	 * 指导建议显示序号
	 * @return Integer
	 */
	public Integer getSeqno() {
		return ((Integer) getAttrVal("Seqno"));
	}
	/**
	 * 指导建议显示序号
	 * @param Seqno
	 */
	public void setSeqno(Integer Seqno) {
		setAttrVal("Seqno", Seqno);
	}
	/**
	 * 指导建议编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 指导建议编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 指导建议名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 指导建议名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 指导建议内容
	 * @return String
	 */
	public String getFullcontent() {
		return ((String) getAttrVal("Fullcontent"));
	}
	/**
	 * 指导建议内容
	 * @param Fullcontent
	 */
	public void setFullcontent(String Fullcontent) {
		setAttrVal("Fullcontent", Fullcontent);
	}
}