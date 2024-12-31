package iih.bl.hp.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 诊断统计信息 DTO数据 
 * 
 */
public class DiStatsDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 含有行动不便诊断
	 * @return FBoolean
	 */
	public FBoolean getFg_hasmovediff() {
		return ((FBoolean) getAttrVal("Fg_hasmovediff"));
	}
	/**
	 * 含有行动不便诊断
	 * @param Fg_hasmovediff
	 */
	public void setFg_hasmovediff(FBoolean Fg_hasmovediff) {
		setAttrVal("Fg_hasmovediff", Fg_hasmovediff);
	}
	/**
	 * 含有慢病
	 * @return FBoolean
	 */
	public FBoolean getFg_haschronic() {
		return ((FBoolean) getAttrVal("Fg_haschronic"));
	}
	/**
	 * 含有慢病
	 * @param Fg_haschronic
	 */
	public void setFg_haschronic(FBoolean Fg_haschronic) {
		setAttrVal("Fg_haschronic", Fg_haschronic);
	}
	/**
	 * 含有特病
	 * @return FBoolean
	 */
	public FBoolean getFg_haspec() {
		return ((FBoolean) getAttrVal("Fg_haspec"));
	}
	/**
	 * 含有特病
	 * @param Fg_haspec
	 */
	public void setFg_haspec(FBoolean Fg_haspec) {
		setAttrVal("Fg_haspec", Fg_haspec);
	}
}