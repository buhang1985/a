package iih.mp.nr.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 就诊域接口参数 DTO数据 
 * 
 */
public class EnServiceParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	/**
	 * 开始时间
	 * @return String
	 */
	public String getDt_bg() {
		return ((String) getAttrVal("Dt_bg"));
	}
	/**
	 * 开始时间
	 * @param Dt_bg
	 */
	public void setDt_bg(String Dt_bg) {
		setAttrVal("Dt_bg", Dt_bg);
	}
	/**
	 * 结束时间
	 * @return String
	 */
	public String getDt_end() {
		return ((String) getAttrVal("Dt_end"));
	}
	/**
	 * 结束时间
	 * @param Dt_end
	 */
	public void setDt_end(String Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 医技标识
	 * @return String
	 */
	public String getFg_tech() {
		return ((String) getAttrVal("Fg_tech"));
	}
	/**
	 * 医技标识
	 * @param Fg_tech
	 */
	public void setFg_tech(String Fg_tech) {
		setAttrVal("Fg_tech", Fg_tech);
	}
}