package iih.ci.ord.s.ems.utils.meta;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
/**
 * 病理检查参数
 * @author F
 *
 * @date 2019年12月16日下午3:37:08
 *
 * @classpath iih.ci.ord.s.ems.utils.meta.PathologyContentParam
 */
public class PathologyContentParam extends BaseOrContentParam{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PathologyContentParam(String id_or_old,CiorderAggDO aggDO) {
		this.id_or_oldString=id_or_old;
		this.ciOrderDO=aggDO.getParentDO();
	}
	/**
	 * 旧的医嘱idor
	 */
	private String id_or_oldString;
	/**
	 * 医嘱do
	 */
	private CiOrderDO ciOrderDO;
	public String getId_or_oldString() {
		return id_or_oldString;
	}
	public void setId_or_oldString(String id_or_oldString) {
		this.id_or_oldString = id_or_oldString;
	}
	public CiOrderDO getCiOrderDO() {
		return ciOrderDO;
	}
	public void setCiOrderDO(CiOrderDO ciOrderDO) {
		this.ciOrderDO = ciOrderDO;
	}

}
