package iih.ei.std.d.v1.en.paidaptdetail.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;

/**
 * 获取患者预约信息出参 DTO数据 
 * 
 */
public class PaidAptDetailResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 预约详细信息
	 * @return String
	 */
	public FArrayList getPaidaptdetail() {
		return ((FArrayList) getAttrVal("Paidaptdetail"));
	}	
	/**
	 * 预约详细信息
	 * @param Paidaptdetail
	 */
	public void setPaidaptdetail(FArrayList Paidaptdetail) {
		setAttrVal("Paidaptdetail", Paidaptdetail);
	}
}