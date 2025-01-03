package iih.ci.ord.copy.dto;

import iih.ci.ord.cior.d.OrdApObsDO;
/**
 * 医嘱复制数据对象
 * @author zhangwq
 *
 */
public class RisCopyDTO  extends DrugCopyDTO{

	/**
	 * 检查申请单信息
	 * @return OrdApObsDO
	 */
	public OrdApObsDO getOrdApLabDO() {
		return ((OrdApObsDO) getAttrVal("OrdApObsDO"));
	}
	/**
	 * 检查申请单信息
	 * @param OrdApObsDO
	 */
	public void setOrdApObsDO(OrdApObsDO OrdApObsDO) {
		setAttrVal("OrdApObsDO", OrdApObsDO);
	}

}
