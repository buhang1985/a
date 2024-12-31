package iih.bl.st.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 挂号接诊信息导出（首信医保） DTO数据 
 * 
 */
public class BlEntInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就（接）诊日期
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}
	/**
	 * 就（接）诊日期
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 医保交易流水号
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}
	/**
	 * 医保交易流水号
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	/**
	 * 接诊标志
	 * @return FBoolean
	 */
	public FBoolean getFg_acptvalid() {
		return ((FBoolean) getAttrVal("Fg_acptvalid"));
	}
	/**
	 * 接诊标志
	 * @param Fg_acptvalid
	 */
	public void setFg_acptvalid(FBoolean Fg_acptvalid) {
		setAttrVal("Fg_acptvalid", Fg_acptvalid);
	}
}