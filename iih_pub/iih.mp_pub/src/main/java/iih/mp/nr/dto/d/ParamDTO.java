package iih.mp.nr.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 执行状态参数DTO DTO数据 
 * 
 */
public class ParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 医嘱类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 状态
	 * @return String
	 */
	public String getSd_orplcasta() {
		return ((String) getAttrVal("Sd_orplcasta"));
	}
	/**
	 * 状态
	 * @param Sd_orplcasta
	 */
	public void setSd_orplcasta(String Sd_orplcasta) {
		setAttrVal("Sd_orplcasta", Sd_orplcasta);
	}
}