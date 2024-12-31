package iih.hp.cp.extdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 无效值按路径分组 DTO数据 
 * 
 */
public class HpCpInvalidDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 诊疗计划ID
	 * @return String
	 */
	public String getId_cp() {
		return ((String) getAttrVal("Id_cp"));
	}
	/**
	 * 诊疗计划ID
	 * @param Id_cp
	 */
	public void setId_cp(String Id_cp) {
		setAttrVal("Id_cp", Id_cp);
	}
	/**
	 * 无效元素数组
	 * @return FArrayList
	 */
	public FArrayList getArr_invalid_ele() {
		return ((FArrayList) getAttrVal("Arr_invalid_ele"));
	}
	/**
	 * 无效元素数组
	 * @param Arr_invalid_ele
	 */
	public void setArr_invalid_ele(FArrayList Arr_invalid_ele) {
		setAttrVal("Arr_invalid_ele", Arr_invalid_ele);
	}
}