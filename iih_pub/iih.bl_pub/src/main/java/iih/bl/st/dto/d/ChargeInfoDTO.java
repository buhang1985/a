package iih.bl.st.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 找零信息DTO DTO数据 
 * 
 */
public class ChargeInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 支付方式ID
	 * @return String
	 */
	public String getId_pm() {
		return ((String) getAttrVal("Id_pm"));
	}
	/**
	 * 支付方式ID
	 * @param Id_pm
	 */
	public void setId_pm(String Id_pm) {
		setAttrVal("Id_pm", Id_pm);
	}
	/**
	 * 支付方式编码
	 * @return String
	 */
	public String getCode_pm() {
		return ((String) getAttrVal("Code_pm"));
	}
	/**
	 * 支付方式编码
	 * @param Code_pm
	 */
	public void setCode_pm(String Code_pm) {
		setAttrVal("Code_pm", Code_pm);
	}
	/**
	 * 支付方式名称
	 * @return String
	 */
	public String getName_pm() {
		return ((String) getAttrVal("Name_pm"));
	}
	/**
	 * 支付方式名称
	 * @param Name_pm
	 */
	public void setName_pm(String Name_pm) {
		setAttrVal("Name_pm", Name_pm);
	}
	/**
	 * 结存
	 * @return FBoolean
	 */
	public FBoolean getFg_bal() {
		return ((FBoolean) getAttrVal("Fg_bal"));
	}
	/**
	 * 结存
	 * @param Fg_bal
	 */
	public void setFg_bal(FBoolean Fg_bal) {
		setAttrVal("Fg_bal", Fg_bal);
	}
	/**
	 * 支付凭证
	 * @return String
	 */
	public String getPaycert() {
		return ((String) getAttrVal("Paycert"));
	}
	/**
	 * 支付凭证
	 * @param Paycert
	 */
	public void setPaycert(String Paycert) {
		setAttrVal("Paycert", Paycert);
	}
}