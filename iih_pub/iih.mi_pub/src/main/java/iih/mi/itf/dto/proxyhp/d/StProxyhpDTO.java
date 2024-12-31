package iih.mi.itf.dto.proxyhp.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 代报结算信息 DTO数据 
 * 
 */
public class StProxyhpDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 代报结算主键
	 * @return String
	 */
	public String getId_st_proxyhp() {
		return ((String) getAttrVal("Id_st_proxyhp"));
	}
	/**
	 * 代报结算主键
	 * @param Id_st_proxyhp
	 */
	public void setId_st_proxyhp(String Id_st_proxyhp) {
		setAttrVal("Id_st_proxyhp", Id_st_proxyhp);
	}
	/**
	 * 代报结算号
	 * @return String
	 */
	public String getCode_st() {
		return ((String) getAttrVal("Code_st"));
	}
	/**
	 * 代报结算号
	 * @param Code_st
	 */
	public void setCode_st(String Code_st) {
		setAttrVal("Code_st", Code_st);
	}
	/**
	 * 代报结算方向
	 * @return String
	 */
	public String getEu_direct() {
		return ((String) getAttrVal("Eu_direct"));
	}
	/**
	 * 代报结算方向
	 * @param Eu_direct
	 */
	public void setEu_direct(String Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	/**
	 * 住院就诊id
	 * @return String
	 */
	public String getId_ent_tf() {
		return ((String) getAttrVal("Id_ent_tf"));
	}
	/**
	 * 住院就诊id
	 * @param Id_ent_tf
	 */
	public void setId_ent_tf(String Id_ent_tf) {
		setAttrVal("Id_ent_tf", Id_ent_tf);
	}
	/**
	 * 取消标志
	 * @return FBoolean
	 */
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}
	/**
	 * 取消标志
	 * @param Fg_canc
	 */
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
}