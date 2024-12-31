package iih.bl.cg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class BlCgPriceDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者名称
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者名称
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 记账结束日期
	 * @return FDate
	 */
	public FDate getEnd_date() {
		return ((FDate) getAttrVal("End_date"));
	}
	/**
	 * 记账结束日期
	 * @param End_date
	 */
	public void setEnd_date(FDate End_date) {
		setAttrVal("End_date", End_date);
	}
}