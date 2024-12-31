package iih.mi.bd.i;

import iih.mi.bd.miudidoccomp.d.MiUdidocCompDO;
import iih.mi.bd.miudidoclist.d.MiUdidoclistDO;
import iih.mi.bd.miudidocuse.d.MiUdidoclistUseDO;
import xap.mw.core.data.BizException;

/**
 * 医保档案相关查询服务
 * 
 * @author wq.li
 *
 */
public interface IMBdudidocQryService {
	/**
	 * 查询该医保计划下已维护的档案类型
	 * 
	 * @param hpId
	 * @return
	 */
	public abstract MiUdidoclistDO[] getMiUdidiclistInHpId(String hpId) throws BizException;

	/**
	 * 查询该医保计划下未维护的医保档案类型
	 * 
	 * @param hpId
	 * @return
	 */
	public abstract MiUdidoclistDO[] getMiUdidiclistNotInHpId(String hpId) throws BizException;

	/**
	 * 查询对照信息
	 * 
	 * @param useDo
	 * @return
	 * @throws BizException
	 */
	public abstract MiUdidocCompDO[] getMiUdidocCompInfo(MiUdidoclistUseDO useDo) throws BizException;
}
