package iih.bd.mm.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 审计信息条目 DTO数据 
 * 
 */
public class AuditEntryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 字段名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 字段名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 修改前值
	 * @return FDouble
	 */
	public FDouble getOldvalue() {
		return ((FDouble) getAttrVal("Oldvalue"));
	}
	/**
	 * 修改前值
	 * @param Oldvalue
	 */
	public void setOldvalue(FDouble Oldvalue) {
		setAttrVal("Oldvalue", Oldvalue);
	}
	/**
	 * 修改后值
	 * @return FDouble
	 */
	public FDouble getNewvalue() {
		return ((FDouble) getAttrVal("Newvalue"));
	}
	/**
	 * 修改后值
	 * @param Newvalue
	 */
	public void setNewvalue(FDouble Newvalue) {
		setAttrVal("Newvalue", Newvalue);
	}
	/**
	 * 物品id
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品id
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
}