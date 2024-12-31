package iih.ci.ord.copy.dto;

import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
/**
 * 医嘱复制数据对象
 * @author zhangwq
 *
 */
public class OpSugCopyDTO  extends OrderCopyDTO{

	/**
	 * 手术申请单信息
	 * @return CiorappsurgeryAggDO
	 */
	public CiorappsurgeryAggDO getCiorappsurgeryAggDO() {
		return ((CiorappsurgeryAggDO) getAttrVal("CiorappsurgeryAggDO"));
	}
	/**
	 * 手术申请单信息
	 * @param CiorappsurgeryAggDO
	 */
	public void setCiorappsurgeryAggDO(CiorappsurgeryAggDO CiorappsurgeryAggDO) {
		setAttrVal("CiorappsurgeryAggDO", CiorappsurgeryAggDO);
	}

}
