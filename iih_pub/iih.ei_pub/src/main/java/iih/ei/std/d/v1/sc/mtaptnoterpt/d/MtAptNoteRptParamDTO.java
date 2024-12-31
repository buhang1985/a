package iih.ei.std.d.v1.sc.mtaptnoterpt.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 取医技预约告知单入参 DTO数据 
 * 
 */
public class MtAptNoteRptParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 预约记录id
	 * @return String
	 */
	public String getId_apt() {
		return ((String) getAttrVal("Id_apt"));
	}	
	/**
	 * 预约记录id
	 * @param Id_apt
	 */
	public void setId_apt(String Id_apt) {
		setAttrVal("Id_apt", Id_apt);
	}
}