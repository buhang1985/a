package iih.ei.std.d.v1.en.chlschstats.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;
import iih.ei.std.d.v1.en.chlschstats.d.ChlSchStatsDTO;

/**
 * 渠道预约统计信息出参 DTO数据 
 * 
 */
public class ChlSchStatsResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 预约渠道统计信息
	 * @return String
	 */
	public ChlSchStatsDTO getChlschstat() {
		return ((ChlSchStatsDTO) getAttrVal("Chlschstat"));
	}	
	/**
	 * 预约渠道统计信息
	 * @param Chlschstat
	 */
	public void setChlschstat(ChlSchStatsDTO Chlschstat) {
		setAttrVal("Chlschstat", Chlschstat);
	}
}