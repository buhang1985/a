package iih.sc.sch.res.dto.d;

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
	 * 时间段
	 * @return String
	 */
	public String getTime() {
		return ((String) getAttrVal("Time"));
	}
	/**
	 * 时间段
	 * @param Time
	 */
	public void setTime(String Time) {
		setAttrVal("Time", Time);
	}
	/**
	 * 剩余号源
	 * @return String
	 */
	public String getRemain() {
		return ((String) getAttrVal("Remain"));
	}
	/**
	 * 剩余号源
	 * @param Remain
	 */
	public void setRemain(String Remain) {
		setAttrVal("Remain", Remain);
	}
	/**
	 * 总号数
	 * @return String
	 */
	public String getTotal() {
		return ((String) getAttrVal("Total"));
	}
	/**
	 * 总号数
	 * @param Total
	 */
	public void setTotal(String Total) {
		setAttrVal("Total", Total);
	}
}