package iih.bl.pay.blcontrolciorder.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 欠费控制是否可开立医嘱（费用）出参 DTO数据 
 * 
 */
public class ArrearsControlOrderOutParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱主键
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 医嘱主键
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 该医嘱是否允许开单
	 * @return FBoolean
	 */
	public FBoolean getFg_open() {
		return ((FBoolean) getAttrVal("Fg_open"));
	}	
	/**
	 * 该医嘱是否允许开单
	 * @param Fg_open
	 */
	public void setFg_open(FBoolean Fg_open) {
		setAttrVal("Fg_open", Fg_open);
	}
	/**
	 * 医嘱下收费项目集合
	 * @return String
	 */
	public FArrayList getCiorlist() {
		return ((FArrayList) getAttrVal("Ciorlist"));
	}	
	/**
	 * 医嘱下收费项目集合
	 * @param Ciorlist
	 */
	public void setCiorlist(FArrayList Ciorlist) {
		setAttrVal("Ciorlist", Ciorlist);
	}
}