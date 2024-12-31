package iih.ei.std.d.v1.en.visittimesstat.d;

import xap.mw.core.data.BaseDTO;

/**
 * 统计门急诊就诊人次入参 DTO数据 
 * 
 */
public class VisitTimesStatParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 统计日期
	 * @return String
	 */
	public String getDate() {
		return ((String) getAttrVal("Date"));
	}	
	/**
	 * 统计日期
	 * @param Date
	 */
	public void setDate(String Date) {
		setAttrVal("Date", Date);
	}
}