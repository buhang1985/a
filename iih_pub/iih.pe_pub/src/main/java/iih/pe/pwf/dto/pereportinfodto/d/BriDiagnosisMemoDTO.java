package iih.pe.pwf.dto.pereportinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 小结诊断备注详细信息 DTO数据 
 * 
 */
public class BriDiagnosisMemoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getBridiagnosiscode() {
		return ((String) getAttrVal("Bridiagnosiscode"));
	}
	/**
	 * 诊断编码
	 * @param Bridiagnosiscode
	 */
	public void setBridiagnosiscode(String Bridiagnosiscode) {
		setAttrVal("Bridiagnosiscode", Bridiagnosiscode);
	}
	/**
	 * 备注项序号
	 * @return Integer
	 */
	public Integer getSeqno() {
		return ((Integer) getAttrVal("Seqno"));
	}
	/**
	 * 备注项序号
	 * @param Seqno
	 */
	public void setSeqno(Integer Seqno) {
		setAttrVal("Seqno", Seqno);
	}
	/**
	 * 备注项编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 备注项编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 备注项名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 备注项名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 备注项标题
	 * @return String
	 */
	public String getTitle() {
		return ((String) getAttrVal("Title"));
	}
	/**
	 * 备注项标题
	 * @param Title
	 */
	public void setTitle(String Title) {
		setAttrVal("Title", Title);
	}
	/**
	 * 备注项结果
	 * @return String
	 */
	public String getValue() {
		return ((String) getAttrVal("Value"));
	}
	/**
	 * 备注项结果
	 * @param Value
	 */
	public void setValue(String Value) {
		setAttrVal("Value", Value);
	}
	/**
	 * 备注项单位
	 * @return String
	 */
	public String getUnit() {
		return ((String) getAttrVal("Unit"));
	}
	/**
	 * 备注项单位
	 * @param Unit
	 */
	public void setUnit(String Unit) {
		setAttrVal("Unit", Unit);
	}
}