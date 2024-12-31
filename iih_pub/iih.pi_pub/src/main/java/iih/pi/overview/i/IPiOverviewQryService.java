package iih.pi.overview.i;

import iih.pi.overview.overview.d.OverviewAggDO;
import xap.mw.core.data.BizException;

/**
 * 患者基本信息查询服务
 * @author ly
 *
 */
public interface IPiOverviewQryService {

	/**
	 * 只包含患者过敏史和生理状况信息
	 * @param patid 患者id
	 * @return
	 * @throws BizException
	 */
	public abstract OverviewAggDO findAlAndPhyData(String patid) throws BizException;
}
