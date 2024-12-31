package iih.bl.inc.blecincprint.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 获取当前纸质票号入参 DTO数据 
 * 
 */
public class BlEcIncCurPIncnoInDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 票据类型
	 * @return String
	 */
	public String getSd_incca() {
		return ((String) getAttrVal("Sd_incca"));
	}
	/**
	 * 票据类型
	 * @param Sd_incca
	 */
	public void setSd_incca(String Sd_incca) {
		setAttrVal("Sd_incca", Sd_incca);
	}
}