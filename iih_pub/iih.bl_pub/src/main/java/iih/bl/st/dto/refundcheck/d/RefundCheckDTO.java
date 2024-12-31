package iih.bl.st.dto.refundcheck.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检退费校验DTO DTO数据 
 * 
 */
public class RefundCheckDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体检编码
	 * @return String
	 */
	public String getPecode() {
		return ((String) getAttrVal("Pecode"));
	}
	/**
	 * 体检编码
	 * @param Pecode
	 */
	public void setPecode(String Pecode) {
		setAttrVal("Pecode", Pecode);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getSrvcode() {
		return ((String) getAttrVal("Srvcode"));
	}
	/**
	 * 服务编码
	 * @param Srvcode
	 */
	public void setSrvcode(String Srvcode) {
		setAttrVal("Srvcode", Srvcode);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getPatcode() {
		return ((String) getAttrVal("Patcode"));
	}
	/**
	 * 患者编码
	 * @param Patcode
	 */
	public void setPatcode(String Patcode) {
		setAttrVal("Patcode", Patcode);
	}
	/**
	 * 可退标识
	 * @return FBoolean
	 */
	public FBoolean getFg_canrefund() {
		return ((FBoolean) getAttrVal("Fg_canrefund"));
	}
	/**
	 * 可退标识
	 * @param Fg_canrefund
	 */
	public void setFg_canrefund(FBoolean Fg_canrefund) {
		setAttrVal("Fg_canrefund", Fg_canrefund);
	}
}