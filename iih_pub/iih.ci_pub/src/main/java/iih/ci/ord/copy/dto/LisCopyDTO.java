package iih.ci.ord.copy.dto;

import iih.ci.ord.cior.d.OrdApLabDO;
/**
 * 医嘱复制数据对象
 * @author zhangwq
 *
 */
public class LisCopyDTO  extends DrugCopyDTO{

	/**
	 * 检验申请单信息
	 * @return OrdApLabDO
	 */
	public OrdApLabDO getOrdApLabDO() {
		return ((OrdApLabDO) getAttrVal("OrdApLabDO"));
	}
	/**
	 * 检验申请单信息
	 * @param OrdApLabDO
	 */
	public void setOrdApLabDO(OrdApLabDO OrdApLabDO) {
		setAttrVal("OrdApLabDO", OrdApLabDO);
	}

}
