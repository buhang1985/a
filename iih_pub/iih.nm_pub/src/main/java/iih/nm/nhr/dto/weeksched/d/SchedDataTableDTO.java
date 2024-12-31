package iih.nm.nhr.dto.weeksched.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 周排班表格数据 DTO数据 
 * 
 */
public class SchedDataTableDTO extends BaseDTO {
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
	 * 周信息
	 * @return FArrayList
	 */
	public FArrayList getSchedweeklist() {
		return ((FArrayList) getAttrVal("Schedweeklist"));
	}
	/**
	 * 周信息
	 * @param Schedweeklist
	 */
	public void setSchedweeklist(FArrayList Schedweeklist) {
		setAttrVal("Schedweeklist", Schedweeklist);
	}
	/**
	 * 表格分组数据
	 * @return FArrayList
	 */
	public FArrayList getGrpdatalist() {
		return ((FArrayList) getAttrVal("Grpdatalist"));
	}
	/**
	 * 表格分组数据
	 * @param Grpdatalist
	 */
	public void setGrpdatalist(FArrayList Grpdatalist) {
		setAttrVal("Grpdatalist", Grpdatalist);
	}
}