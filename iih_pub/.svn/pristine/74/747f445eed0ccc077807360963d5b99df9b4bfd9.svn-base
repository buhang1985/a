package iih.ci.preop.order.dto;

import java.util.List;

import iih.ci.tsip.d.CiTsOrDO;
import iih.ci.tsip.d.CiTsOrSrvDO;
import iih.ci.tsip.d.CiTsOrSrvSetDO;
import iih.ci.tsip.d.CitsorderAggDO;
import xap.mw.core.data.BaseDTO;
/**
 * 预住院医嘱数据结合体，医嘱表，服务表，服务套，申请单表
 * @author F
 *
 */
public class OrdPreopDTO extends BaseDTO{
	/**
	 * 治疗方案医嘱
	 * @return CiTsOrDO
	 */
	public CiTsOrDO getCiTsOrDO() {
		return ((CiTsOrDO) getAttrVal("CiTsOrDO"));
	}
	/**
	 * 治疗方案医嘱
	 * @param Id_billform
	 */
	public void setCiTsOrDO(CiTsOrDO CiTsOrDO) {
		setAttrVal("CiTsOrDO", CiTsOrDO);
	}
	/**
	 * 治疗方案医嘱服务项目
	 * @return CiTsOrSrvDO
	 */
	public List<CiTsOrSrvDO> getCiTsOrSrvDO() {
		return ((List<CiTsOrSrvDO>) getAttrVal("CiTsOrSrvDO"));
	}
	/**
	 * 治疗方案医嘱服务项目
	 * @param CiTsOrSrvDO
	 */
	public void setCiTsOrSrvDO(List<CiTsOrSrvDO> CiTsOrSrvDO) {
		setAttrVal("CiTsOrSrvDO", CiTsOrSrvDO);
	}
	/**
	 * 治疗方案医嘱服务项目
	 * @return CiTsOrSrvSetDO
	 */
	public List<CiTsOrSrvSetDO> getCiTsOrSrvSetDO() {
		return ((List<CiTsOrSrvSetDO>) getAttrVal("CiTsOrSrvSetDO"));
	}
	/**
	 * 治疗方案医嘱服务项目
	 * @param CiTsOrSrvSetDO
	 */
	public void setCiTsOrSrvSetDO(List<CiTsOrSrvSetDO> CiTsOrSrvSetDO) {
		setAttrVal("CiTsOrSrvSetDO", CiTsOrSrvSetDO);
	}
	/**
	 * 复制的源对象
	 * @return CitsorderAggDO
	 */
	public CitsorderAggDO getSourceCitsorderAggDO() {
		return ((CitsorderAggDO) getAttrVal("SourceCitsorderAggDO"));
	}
	/**
	 * 复制的源对象
	 * @param CitsorderAggDO
	 */
	public void setSourceCitsorderAggDO(CitsorderAggDO SourceCitsorderAggDO) {
		setAttrVal("SourceCitsorderAggDO", SourceCitsorderAggDO);
	}
}
