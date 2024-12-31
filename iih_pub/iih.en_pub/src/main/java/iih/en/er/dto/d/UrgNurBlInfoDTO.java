package iih.en.er.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 急诊留观护士站-患者费用信息 DTO数据 
 * 
 */
public class UrgNurBlInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主医保
	 * @return String
	 */
	public String getMain_hp() {
		return ((String) getAttrVal("Main_hp"));
	}
	/**
	 * 主医保
	 * @param Main_hp
	 */
	public void setMain_hp(String Main_hp) {
		setAttrVal("Main_hp", Main_hp);
	}
	/**
	 * 保险类型
	 * @return String
	 */
	public String getInsurancetp() {
		return ((String) getAttrVal("Insurancetp"));
	}
	/**
	 * 保险类型
	 * @param Insurancetp
	 */
	public void setInsurancetp(String Insurancetp) {
		setAttrVal("Insurancetp", Insurancetp);
	}
	/**
	 * 预交金
	 * @return Integer
	 */
	public Integer getPrepay() {
		return ((Integer) getAttrVal("Prepay"));
	}
	/**
	 * 预交金
	 * @param Prepay
	 */
	public void setPrepay(Integer Prepay) {
		setAttrVal("Prepay", Prepay);
	}
	/**
	 * 住院费用
	 * @return Integer
	 */
	public Integer getAmt_use() {
		return ((Integer) getAttrVal("Amt_use"));
	}
	/**
	 * 住院费用
	 * @param Amt_use
	 */
	public void setAmt_use(Integer Amt_use) {
		setAttrVal("Amt_use", Amt_use);
	}
	/**
	 * 余额
	 * @return Integer
	 */
	public Integer getBalance() {
		return ((Integer) getAttrVal("Balance"));
	}
	/**
	 * 余额
	 * @param Balance
	 */
	public void setBalance(Integer Balance) {
		setAttrVal("Balance", Balance);
	}
	/**
	 * 床位价格
	 * @return Integer
	 */
	public Integer getAmt_bed() {
		return ((Integer) getAttrVal("Amt_bed"));
	}
	/**
	 * 床位价格
	 * @param Amt_bed
	 */
	public void setAmt_bed(Integer Amt_bed) {
		setAttrVal("Amt_bed", Amt_bed);
	}
}