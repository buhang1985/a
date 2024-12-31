package iih.mp.ne.transfusiondto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 输血历史记录 DTO数据 
 * 
 */
public class TransfusionRecordDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 输血记录主标识
	 * @return String
	 */
	public String getId_record() {
		return ((String) getAttrVal("Id_record"));
	}
	/**
	 * 输血记录主标识
	 * @param Id_record
	 */
	public void setId_record(String Id_record) {
		setAttrVal("Id_record", Id_record);
	}
	/**
	 * 输血名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 输血名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 输血记录父键
	 * @return String
	 */
	public String getId_parent() {
		return ((String) getAttrVal("Id_parent"));
	}
	/**
	 * 输血记录父键
	 * @param Id_parent
	 */
	public void setId_parent(String Id_parent) {
		setAttrVal("Id_parent", Id_parent);
	}
}