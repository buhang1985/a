package iih.bl.cg.dto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDouble;

public class BlCgAmtDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 包含价格比例的总金额
	 * @return String
	 */
	public FDouble getAmtsum() {
		return ((FDouble) getAttrVal("Amtsum"));
	}
	public void setAmtsum(FDouble Amtsum) {
		setAttrVal("Amtsum", Amtsum);
	}
	
	/**
	 * 标准总金额
	 * @return FDouble
	 */
	public FDouble getAmt_stdsum() {
		return ((FDouble) getAttrVal("Amt_stdsum"));
	}
	public void setAmt_stdsum(FDouble Amt_stdsum) {
		setAttrVal("Amt_stdsum", Amt_stdsum);
	}
	

}
