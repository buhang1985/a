package iih.en.pv.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 出院其他校验结果DTO DTO数据 
 * 
 */
public class LvCheckOtherResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 问题类型
	 * @return String
	 */
	public String getProblem_type() {
		return ((String) getAttrVal("Problem_type"));
	}
	/**
	 * 问题类型
	 * @param Problem_type
	 */
	public void setProblem_type(String Problem_type) {
		setAttrVal("Problem_type", Problem_type);
	}
	/**
	 * 问题描述
	 * @return String
	 */
	public String getDesc() {
		return ((String) getAttrVal("Desc"));
	}
	/**
	 * 问题描述
	 * @param Desc
	 */
	public void setDesc(String Desc) {
		setAttrVal("Desc", Desc);
	}
}