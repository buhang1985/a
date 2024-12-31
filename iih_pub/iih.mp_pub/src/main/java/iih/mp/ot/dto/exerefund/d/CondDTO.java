package iih.mp.ot.dto.exerefund.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 查询条件 DTO数据 
 * 
 */
public class CondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 条件唯一标识
	 * @return String
	 */
	public String getId_cond() {
		return ((String) getAttrVal("Id_cond"));
	}
	/**
	 * 条件唯一标识
	 * @param Id_cond
	 */
	public void setId_cond(String Id_cond) {
		setAttrVal("Id_cond", Id_cond);
	}
	/**
	 * 开始日期
	 * @return FDate
	 */
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}
	/**
	 * 开始日期
	 * @param Dt_begin
	 */
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 结束日期
	 * @return FDate
	 */
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}
	/**
	 * 结束日期
	 * @param Dt_end
	 */
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 可退费标记
	 * @return FBoolean
	 */
	public FBoolean getFg_feertnable() {
		return ((FBoolean) getAttrVal("Fg_feertnable"));
	}
	/**
	 * 可退费标记
	 * @param Fg_feertnable
	 */
	public void setFg_feertnable(FBoolean Fg_feertnable) {
		setAttrVal("Fg_feertnable", Fg_feertnable);
	}
}