package iih.mi.bd.s;

import iih.mi.bd.i.IMBdudidocQryService;
import iih.mi.bd.i.IMIBdudidocCudService;
import iih.mi.bd.miudidoccomp.d.MiUdidocCompDO;
import iih.mi.bd.miudidoclist.d.MiUdidoclistDO;
import iih.mi.bd.miudidocuse.d.MiUdidoclistUseDO;
import iih.mi.bd.s.bp.GetMiUdidiclistInHpIdBP;
import iih.mi.bd.s.bp.GetMiUdidiclistNotInHpIdBP;
import iih.mi.bd.s.bp.GetMiUdidocCompInfoBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 医保档案相关查询服务
 * 
 * @author wq.li
 *
 */

@Service(serviceInterfaces = { IMBdudidocQryService.class }, binding = Binding.JSONRPC)

public class IMBdudidocQryServiceImpl implements IMBdudidocQryService {
	/**
	 * 查询该医保计划下已维护的档案类型
	 * 
	 * @param hpId
	 * @return
	 */
	@Override
	public MiUdidoclistDO[] getMiUdidiclistInHpId(String hpId) throws BizException {
		GetMiUdidiclistInHpIdBP bp=new GetMiUdidiclistInHpIdBP();
		return bp.exec(hpId);
	}

	/**
	 * 查询该医保计划下未维护的医保档案类型
	 * 
	 * @param hpId
	 * @return
	 */
	@Override
	public MiUdidoclistDO[] getMiUdidiclistNotInHpId(String hpId) throws BizException {
		GetMiUdidiclistNotInHpIdBP bp=new GetMiUdidiclistNotInHpIdBP();
		return bp.exec(hpId);
	}
	/**
	 * 查询对照信息
	 * 
	 * @param useDo
	 * @return
	 * @throws BizException
	 */
	@Override
	public MiUdidocCompDO[] getMiUdidocCompInfo(MiUdidoclistUseDO useDo) throws BizException {
		GetMiUdidocCompInfoBP bp=new GetMiUdidocCompInfoBP();
		return bp.exec(useDo);
	}

}
