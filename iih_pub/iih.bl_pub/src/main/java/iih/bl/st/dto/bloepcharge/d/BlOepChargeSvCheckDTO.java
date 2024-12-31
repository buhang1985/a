package iih.bl.st.dto.bloepcharge.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 版本校验信息 DTO数据 
 * 
 */
public class BlOepChargeSvCheckDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 版本信息
	 * @return FDateTime
	 */
	public FDateTime getChecksv() {
		return ((FDateTime) getAttrVal("Checksv"));
	}
	/**
	 * 版本信息
	 * @param Checksv
	 */
	public void setChecksv(FDateTime Checksv) {
		setAttrVal("Checksv", Checksv);
	}
}