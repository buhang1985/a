package iih.bl.cg.service.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDouble;
/**
 * CI领域需要的住院统计费用DTO
 * @author 唐婵懿
 *
 */
public class BlCgIpAmtAndUncgRationDTO  extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 *  预交金金额(账户余额)
	 * @return
	 */
	public FDouble getAmt_bal() {
		return ((FDouble) getAttrVal("Amt_bal"));
	}
	public void setAmt_bal(FDouble Amt_bal) {
		setAttrVal("Amt_bal", Amt_bal);
	}
	/**
	 *  可消费额度
	 * @return
	 */
	public FDouble getAvailable() {
		return ((FDouble) getAttrVal("Available"));
	}
	public void setAvailable(FDouble Available) {
		setAttrVal("Available", Available);
	}
	/**
	 *  已消费总额
	 * @return
	 */
	public FDouble getAmt_uncg() {
		return ((FDouble) getAttrVal("Amt_uncg"));
	}
	public void setAmt_uncg(FDouble Amt_uncg) {
		setAttrVal("Amt_uncg", Amt_uncg);
	}
	
	/**
	 *  特定项目所占百分比
	 * @return
	 */
	public String getRation() {
		return ((String) getAttrVal("Ration"));
	}
	public void setRation(String Ration) {
		setAttrVal("Ration", Ration);
	}

}
