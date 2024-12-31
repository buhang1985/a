package iih.ei.std.d.v1.bl.opcostbillqrydto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊费用清单查询出参 DTO数据 
 * 
 */
public class OpCostBillQryResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 门诊就诊次数
	 * @return String
	 */
	public String getTimes_op() {
		return ((String) getAttrVal("Times_op"));
	}	
	/**
	 * 门诊就诊次数
	 * @param Times_op
	 */
	public void setTimes_op(String Times_op) {
		setAttrVal("Times_op", Times_op);
	}
	/**
	 * 消费金额
	 * @return String
	 */
	public String getAmt_oepcost() {
		return ((String) getAttrVal("Amt_oepcost"));
	}	
	/**
	 * 消费金额
	 * @param Amt_oepcost
	 */
	public void setAmt_oepcost(String Amt_oepcost) {
		setAttrVal("Amt_oepcost", Amt_oepcost);
	}
	/**
	 * 门诊费用清单账单项信息
	 * @return String
	 */
	public FArrayList getOeptypecostinfo() {
		return ((FArrayList) getAttrVal("Oeptypecostinfo"));
	}	
	/**
	 * 门诊费用清单账单项信息
	 * @param Oeptypecostinfo
	 */
	public void setOeptypecostinfo(FArrayList Oeptypecostinfo) {
		setAttrVal("Oeptypecostinfo", Oeptypecostinfo);
	}
	/**
	 * 费用清单医嘱信息
	 * @return String
	 */
	public FArrayList getOeporderdetailinfo() {
		return ((FArrayList) getAttrVal("Oeporderdetailinfo"));
	}	
	/**
	 * 费用清单医嘱信息
	 * @param Oeporderdetailinfo
	 */
	public void setOeporderdetailinfo(FArrayList Oeporderdetailinfo) {
		setAttrVal("Oeporderdetailinfo", Oeporderdetailinfo);
	}
}