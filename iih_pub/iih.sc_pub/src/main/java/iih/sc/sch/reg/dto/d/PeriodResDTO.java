package iih.sc.sch.reg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 时段资源DTO DTO数据 
 * 
 */
public class PeriodResDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 排班
	 * @return String
	 */
	public String getId_sch() {
		return ((String) getAttrVal("Id_sch"));
	}
	/**
	 * 排班
	 * @param Id_sch
	 */
	public void setId_sch(String Id_sch) {
		setAttrVal("Id_sch", Id_sch);
	}
	/**
	 * 号段id
	 * @return String
	 */
	public String getId_ticks() {
		return ((String) getAttrVal("Id_ticks"));
	}
	/**
	 * 号段id
	 * @param Id_ticks
	 */
	public void setId_ticks(String Id_ticks) {
		setAttrVal("Id_ticks", Id_ticks);
	}
	/**
	 * 时间段
	 * @return String
	 */
	public String getPeriod() {
		return ((String) getAttrVal("Period"));
	}
	/**
	 * 时间段
	 * @param Period
	 */
	public void setPeriod(String Period) {
		setAttrVal("Period", Period);
	}
	/**
	 * 剩余号源
	 * @return Integer
	 */
	public Integer getRemain() {
		return ((Integer) getAttrVal("Remain"));
	}
	/**
	 * 剩余号源
	 * @param Remain
	 */
	public void setRemain(Integer Remain) {
		setAttrVal("Remain", Remain);
	}
	/**
	 * 总号数
	 * @return Integer
	 */
	public Integer getTotal() {
		return ((Integer) getAttrVal("Total"));
	}
	/**
	 * 总号数
	 * @param Total
	 */
	public void setTotal(Integer Total) {
		setAttrVal("Total", Total);
	}
}