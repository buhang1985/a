package iih.mp.nr.dto.executeinvalid.d;

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
	 * 开始时间
	 * @return FDate
	 */
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}
	/**
	 * 开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 结束时间
	 * @return FDate
	 */
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}
	/**
	 * 结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 唯一标识
	 * @return String
	 */
	public String getId_cond() {
		return ((String) getAttrVal("Id_cond"));
	}
	/**
	 * 唯一标识
	 * @param Id_cond
	 */
	public void setId_cond(String Id_cond) {
		setAttrVal("Id_cond", Id_cond);
	}
	/**
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
}