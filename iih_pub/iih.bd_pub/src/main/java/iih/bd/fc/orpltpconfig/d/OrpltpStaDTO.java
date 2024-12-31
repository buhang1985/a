package iih.bd.fc.orpltpconfig.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱闭环状态配置 DTO数据 
 * 
 */
public class OrpltpStaDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 闭环状态
	 * @return String
	 */
	public String getId_orpltpsta() {
		return ((String) getAttrVal("Id_orpltpsta"));
	}
	/**
	 * 闭环状态
	 * @param Id_orpltpsta
	 */
	public void setId_orpltpsta(String Id_orpltpsta) {
		setAttrVal("Id_orpltpsta", Id_orpltpsta);
	}
	/**
	 * 功能对照
	 * @return FArrayList
	 */
	public FArrayList getArray_func() {
		return ((FArrayList) getAttrVal("Array_func"));
	}
	/**
	 * 功能对照
	 * @param Array_func
	 */
	public void setArray_func(FArrayList Array_func) {
		setAttrVal("Array_func", Array_func);
	}
	/**
	 * 状态对照
	 * @return FArrayList
	 */
	public FArrayList getArray_stamap() {
		return ((FArrayList) getAttrVal("Array_stamap"));
	}
	/**
	 * 状态对照
	 * @param Array_stamap
	 */
	public void setArray_stamap(FArrayList Array_stamap) {
		setAttrVal("Array_stamap", Array_stamap);
	}
	/**
	 * 闭环状态DO
	 * @return FArrayList
	 */
	public FArrayList getArray_sta() {
		return ((FArrayList) getAttrVal("Array_sta"));
	}
	/**
	 * 闭环状态DO
	 * @param Array_sta
	 */
	public void setArray_sta(FArrayList Array_sta) {
		setAttrVal("Array_sta", Array_sta);
	}
}