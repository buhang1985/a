package iih.pe.pwf.dto.pereportinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医技小结诊断建议详细信息 DTO数据 
 * 
 */
public class PeBriSummaryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 专科编码
	 * @return String
	 */
	public String getPeinfocode() {
		return ((String) getAttrVal("Peinfocode"));
	}
	/**
	 * 专科编码
	 * @param Peinfocode
	 */
	public void setPeinfocode(String Peinfocode) {
		setAttrVal("Peinfocode", Peinfocode);
	}
	/**
	 * 小结项编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 小结项编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 小结项名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 小结项名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 小结项备注
	 * @return String
	 */
	public String getMemo() {
		return ((String) getAttrVal("Memo"));
	}
	/**
	 * 小结项备注
	 * @param Memo
	 */
	public void setMemo(String Memo) {
		setAttrVal("Memo", Memo);
	}
	/**
	 * 小结诊断详细信息
	 * @return FArrayList2
	 */
	public FArrayList2 getBridiagnosis() {
		return ((FArrayList2) getAttrVal("Bridiagnosis"));
	}
	/**
	 * 小结诊断详细信息
	 * @param Bridiagnosis
	 */
	public void setBridiagnosis(FArrayList2 Bridiagnosis) {
		setAttrVal("Bridiagnosis", Bridiagnosis);
	}
	/**
	 * 小结建议详细信息
	 * @return FArrayList2
	 */
	public FArrayList2 getBriadvice() {
		return ((FArrayList2) getAttrVal("Briadvice"));
	}
	/**
	 * 小结建议详细信息
	 * @param Briadvice
	 */
	public void setBriadvice(FArrayList2 Briadvice) {
		setAttrVal("Briadvice", Briadvice);
	}
}