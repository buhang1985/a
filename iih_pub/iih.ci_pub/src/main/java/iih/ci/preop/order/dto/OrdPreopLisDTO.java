package iih.ci.preop.order.dto;

import iih.ci.tsip.d.CiTsApLabDO;
/**
 * 预住院检验医嘱数据
 * @author F
 *
 */
public class OrdPreopLisDTO extends OrdPreopDTO{
	/**
	 * 治疗方案检验申请
	 * @return CiTsApLabDO
	 */
	public CiTsApLabDO getCiTsApLabDO() {
		return ((CiTsApLabDO) getAttrVal("CiTsApLabDO"));
	}
	/**
	 * 治疗方案检验申请
	 * @param CiTsApLabDO
	 */
	public void setCiTsApLabDO(CiTsApLabDO CiTsApLabDO) {
		setAttrVal("CiTsApLabDO", CiTsApLabDO);
	}
}
