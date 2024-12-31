package iih.mp.dg.dto.prints.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 摆药机摆药体 DTO数据 
 * 
 */
public class MachinePrepHeadDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 药品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}
	/**
	 * 药品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 剂量
	 * @return String
	 */
	public String getQuan() {
		return ((String) getAttrVal("Quan"));
	}
	/**
	 * 剂量
	 * @param Quan
	 */
	public void setQuan(String Quan) {
		setAttrVal("Quan", Quan);
	}
}