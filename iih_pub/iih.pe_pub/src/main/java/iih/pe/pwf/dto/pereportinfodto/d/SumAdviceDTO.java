package iih.pe.pwf.dto.pereportinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 总检项目建议详细信息 DTO数据 
 * 
 */
public class SumAdviceDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 总检项目编码
	 * @return String
	 */
	public String getSummarycode() {
		return ((String) getAttrVal("Summarycode"));
	}
	/**
	 * 总检项目编码
	 * @param Summarycode
	 */
	public void setSummarycode(String Summarycode) {
		setAttrVal("Summarycode", Summarycode);
	}
	/**
	 * 建议序号
	 * @return Integer
	 */
	public Integer getSeqno() {
		return ((Integer) getAttrVal("Seqno"));
	}
	/**
	 * 建议序号
	 * @param Seqno
	 */
	public void setSeqno(Integer Seqno) {
		setAttrVal("Seqno", Seqno);
	}
	/**
	 * 建议编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 建议编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 建议名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 建议名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
}