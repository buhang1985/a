package iih.hr.hsc.dto.scheddto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 排班表 DTO数据 
 * 
 */
public class SchedTableDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 表头显示文本
	 * @return String
	 */
	public String getTitle() {
		return ((String) getAttrVal("Title"));
	}
	/**
	 * 表头显示文本
	 * @param Title
	 */
	public void setTitle(String Title) {
		setAttrVal("Title", Title);
	}
	/**
	 * 排班周信息
	 * @return FArrayList
	 */
	public FArrayList getSchedweeklist() {
		return ((FArrayList) getAttrVal("Schedweeklist"));
	}
	/**
	 * 排班周信息
	 * @param Schedweeklist
	 */
	public void setSchedweeklist(FArrayList Schedweeklist) {
		setAttrVal("Schedweeklist", Schedweeklist);
	}
	/**
	 * 排班行数据
	 * @return FArrayList
	 */
	public FArrayList getRowlist() {
		return ((FArrayList) getAttrVal("Rowlist"));
	}
	/**
	 * 排班行数据
	 * @param Rowlist
	 */
	public void setRowlist(FArrayList Rowlist) {
		setAttrVal("Rowlist", Rowlist);
	}
}