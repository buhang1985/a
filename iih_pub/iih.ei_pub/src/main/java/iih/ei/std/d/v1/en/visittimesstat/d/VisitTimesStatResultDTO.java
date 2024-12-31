package iih.ei.std.d.v1.en.visittimesstat.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;

/**
 * 统计门急诊就诊人次出参 DTO数据 
 * 
 */
public class VisitTimesStatResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 门急诊就诊人次
	 * @return String
	 */
	public FArrayList getVisittimesstat() {
		return ((FArrayList) getAttrVal("Visittimesstat"));
	}	
	/**
	 * 门急诊就诊人次
	 * @param Visittimesstat
	 */
	public void setVisittimesstat(FArrayList Visittimesstat) {
		setAttrVal("Visittimesstat", Visittimesstat);
	}
}