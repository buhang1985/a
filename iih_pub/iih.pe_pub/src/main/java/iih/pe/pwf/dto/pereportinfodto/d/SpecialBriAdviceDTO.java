package iih.pe.pwf.dto.pereportinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 专科小结建议详细信息 DTO数据 
 * 
 */
public class SpecialBriAdviceDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 小结项编码
	 * @return String
	 */
	public String getSpecialbrisummarycode() {
		return ((String) getAttrVal("Specialbrisummarycode"));
	}
	/**
	 * 小结项编码
	 * @param Specialbrisummarycode
	 */
	public void setSpecialbrisummarycode(String Specialbrisummarycode) {
		setAttrVal("Specialbrisummarycode", Specialbrisummarycode);
	}
	/**
	 * 建议序号
	 * @return String
	 */
	public String getSeqno() {
		return ((String) getAttrVal("Seqno"));
	}
	/**
	 * 建议序号
	 * @param Seqno
	 */
	public void setSeqno(String Seqno) {
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