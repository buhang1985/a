package iih.mp.mb.dto.nmrdoc.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 移动文书历史记录Json DTO数据 
 * 
 */
public class NmrDocDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 文书记录ID
	 * @return String
	 */
	public String getId_doc() {
		return ((String) getAttrVal("Id_doc"));
	}
	/**
	 * 文书记录ID
	 * @param Id_doc
	 */
	public void setId_doc(String Id_doc) {
		setAttrVal("Id_doc", Id_doc);
	}
	/**
	 * 患者就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 患者就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 文书录入时间
	 * @return String
	 */
	public String getDt_oper() {
		return ((String) getAttrVal("Dt_oper"));
	}
	/**
	 * 文书录入时间
	 * @param Dt_oper
	 */
	public void setDt_oper(String Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
	}
}