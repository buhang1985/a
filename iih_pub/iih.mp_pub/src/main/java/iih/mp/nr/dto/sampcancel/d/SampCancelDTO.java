package iih.mp.nr.dto.sampcancel.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 标本作废 DTO数据 
 * 
 */
public class SampCancelDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 标本关系
	 * @return String
	 */
	public String getId_labsampitmref() {
		return ((String) getAttrVal("Id_labsampitmref"));
	}
	/**
	 * 标本关系
	 * @param Id_labsampitmref
	 */
	public void setId_labsampitmref(String Id_labsampitmref) {
		setAttrVal("Id_labsampitmref", Id_labsampitmref);
	}
	/**
	 * 标本ID
	 * @return String
	 */
	public String getId_labsamp() {
		return ((String) getAttrVal("Id_labsamp"));
	}
	/**
	 * 标本ID
	 * @param Id_labsamp
	 */
	public void setId_labsamp(String Id_labsamp) {
		setAttrVal("Id_labsamp", Id_labsamp);
	}
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}
	/**
	 * 医嘱名称
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
}