package iih.bl.cg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院记账对外查询dto DTO数据 
 * 
 */
public class BLCgIpOutQryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊主键
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊主键
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 结算主键
	 * @return String
	 */
	public String getId_stip() {
		return ((String) getAttrVal("Id_stip"));
	}
	/**
	 * 结算主键
	 * @param Id_stip
	 */
	public void setId_stip(String Id_stip) {
		setAttrVal("Id_stip", Id_stip);
	}
	/**
	 * 是否已结算
	 * @return String
	 */
	public String getFg_st() {
		return ((String) getAttrVal("Fg_st"));
	}
	/**
	 * 是否已结算
	 * @param Fg_st
	 */
	public void setFg_st(String Fg_st) {
		setAttrVal("Fg_st", Fg_st);
	}
	/**
	 * 医嘱主键集合
	 * @return FArrayList
	 */
	public FArrayList getId_ors() {
		return ((FArrayList) getAttrVal("Id_ors"));
	}
	/**
	 * 医嘱主键集合
	 * @param Id_ors
	 */
	public void setId_ors(FArrayList Id_ors) {
		setAttrVal("Id_ors", Id_ors);
	}
}