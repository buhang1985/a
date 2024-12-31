package iih.mi.bd.i;

import iih.mi.bd.miudidoccomp.d.MiUdidocCompDO;
import iih.mi.bd.miudidoclist.d.MiUdidoclistDO;
import xap.mw.core.data.BizException;

/**
 * 医保档案相关查询服务
 * 
 * @author wq.li
 *
 */
public interface IMIBdudidocCudService {

	/**
	 * 维护该医保计划下的档案类型
	 * 
	 * @param hpId
	 * @param udidocArr
	 * @throws BizException
	 */
	public abstract void saveMiUdidoc(String hpId, MiUdidoclistDO[] udidocArr) throws BizException;

	/**
	 * 保存医保档案对照信息
	 * 
	 * @param compArr
	 * @throws BizException
	 */
	public abstract MiUdidocCompDO[] saveMIudidocComp(MiUdidocCompDO[] compArr) throws BizException;
}
