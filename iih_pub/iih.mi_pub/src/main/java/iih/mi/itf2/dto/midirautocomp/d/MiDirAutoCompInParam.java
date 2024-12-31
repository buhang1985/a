package iih.mi.itf2.dto.midirautocomp.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 目录自动对照入参 DTO数据 
 * 
 */
public class MiDirAutoCompInParam extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 对照类型
	 * @return String
	 */
	public String getComptype() {
		return ((String) getAttrVal("Comptype"));
	}
	/**
	 * 对照类型
	 * @param Comptype
	 */
	public void setComptype(String Comptype) {
		setAttrVal("Comptype", Comptype);
	}
}