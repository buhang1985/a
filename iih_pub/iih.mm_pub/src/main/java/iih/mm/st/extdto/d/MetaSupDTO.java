package iih.mm.st.extdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 物品供应商 DTO数据 
 * 
 */
public class MetaSupDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 物品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}
	/**
	 * 物品名称
	 * @param Id_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 供应商
	 * @return String
	 */
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}
	/**
	 * 供应商
	 * @param Id_sup
	 */
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
	}
	/**
	 * 供应商名称
	 * @return String
	 */
	public String getName_sup() {
		return ((String) getAttrVal("Name_sup"));
	}
	/**
	 * 供应商名称
	 * @param Name_sup
	 */
	public void setName_sup(String Name_sup) {
		setAttrVal("Name_sup", Name_sup);
	}
}