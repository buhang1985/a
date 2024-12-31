package iih.mi.itf2.dto.setownexpense.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 设置自费入参 DTO数据 
 * 
 */
public class SetOwnExpenseInParam extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 目录类型
	 * @return String
	 */
	public String getDirtype() {
		return ((String) getAttrVal("Dirtype"));
	}
	/**
	 * 目录类型
	 * @param Dirtype
	 */
	public void setDirtype(String Dirtype) {
		setAttrVal("Dirtype", Dirtype);
	}
	/**
	 * 目录设置自费入参集合
	 * @return FArrayList
	 */
	public FArrayList getDetail() {
		return ((FArrayList) getAttrVal("Detail"));
	}
	/**
	 * 目录设置自费入参集合
	 * @param Detail
	 */
	public void setDetail(FArrayList Detail) {
		setAttrVal("Detail", Detail);
	}
	/**
	 * 自费状态
	 * @return String
	 */
	public String getEu_status() {
		return ((String) getAttrVal("Eu_status"));
	}
	/**
	 * 自费状态
	 * @param Eu_status
	 */
	public void setEu_status(String Eu_status) {
		setAttrVal("Eu_status", Eu_status);
	}
}