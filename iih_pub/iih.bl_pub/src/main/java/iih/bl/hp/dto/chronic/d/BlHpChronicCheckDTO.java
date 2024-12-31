package iih.bl.hp.dto.chronic.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 慢性病处方校验 DTO数据 
 * 
 */
public class BlHpChronicCheckDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 处方主键
	 * @return String
	 */
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}
	/**
	 * 处方主键
	 * @param Id_pres
	 */
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
	}
	/**
	 * 是否慢性病处方
	 * @return FBoolean
	 */
	public FBoolean getFg_chronic() {
		return ((FBoolean) getAttrVal("Fg_chronic"));
	}
	/**
	 * 是否慢性病处方
	 * @param Fg_chronic
	 */
	public void setFg_chronic(FBoolean Fg_chronic) {
		setAttrVal("Fg_chronic", Fg_chronic);
	}
	/**
	 * 是否付款
	 * @return FBoolean
	 */
	public FBoolean getFg_pay() {
		return ((FBoolean) getAttrVal("Fg_pay"));
	}
	/**
	 * 是否付款
	 * @param Fg_pay
	 */
	public void setFg_pay(FBoolean Fg_pay) {
		setAttrVal("Fg_pay", Fg_pay);
	}
}