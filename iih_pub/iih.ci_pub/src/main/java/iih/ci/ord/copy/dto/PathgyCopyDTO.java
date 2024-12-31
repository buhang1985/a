package iih.ci.ord.copy.dto;

import iih.ci.ord.cior.d.CiorapppathgyAggDO;
/**
 * 医嘱复制数据对象
 * @author zhangwq
 *
 */
public class PathgyCopyDTO  extends OrderCopyDTO{

	/**
	 * 病理申请单信息
	 * @return CiorapppathgyAggDO
	 */
	public CiorapppathgyAggDO getCiorapppathgyAggDO() {
		return ((CiorapppathgyAggDO) getAttrVal("CiorapppathgyAggDO"));
	}
	/**
	 * 病理申请单信息
	 * @param CiorapppathgyAggDO
	 */
	public void setCiorapppathgyAggDO(CiorapppathgyAggDO CiorapppathgyAggDO) {
		setAttrVal("CiorapppathgyAggDO", CiorapppathgyAggDO);
	}

}
