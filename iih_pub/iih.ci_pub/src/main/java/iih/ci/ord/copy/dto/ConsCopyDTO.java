package iih.ci.ord.copy.dto;

import iih.ci.ord.cior.d.CiorappconsultAggDO;
/**
 * 会诊医嘱复制数据对象
 * @author zhangwq
 *
 */
public class ConsCopyDTO  extends OrderCopyDTO{

	/**
	 * 会诊申请单信息
	 * @return OrdApLabDO
	 */
	public CiorappconsultAggDO getCiorappconsultAggDO() {
		return ((CiorappconsultAggDO) getAttrVal("CiorappconsultAggDO"));
	}
	/**
	 * 会诊申请单信息
	 * @param CiorappconsultAggDO
	 */
	public void setCiorappconsultAggDO(CiorappconsultAggDO CiorappconsultAggDO) {
		setAttrVal("CiorappconsultAggDO", CiorappconsultAggDO);
	}

}
