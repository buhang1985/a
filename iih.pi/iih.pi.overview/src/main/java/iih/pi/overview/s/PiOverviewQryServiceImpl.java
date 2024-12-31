package iih.pi.overview.s;

import iih.pi.overview.i.IPiOverviewQryService;
import iih.pi.overview.overview.d.OverviewAggDO;
import iih.pi.overview.s.bp.GetAlAndPhyBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 
 * @author ly
 *
 */
@Service(serviceInterfaces={IPiOverviewQryService.class}, binding=Binding.JSONRPC)
public class PiOverviewQryServiceImpl implements IPiOverviewQryService{

	/**
	 * 只包含患者过敏史和生理状况信息
	 * @param patid 患者id
	 * @return
	 * @throws BizException
	 */
	@Override
	public OverviewAggDO findAlAndPhyData(String patid) throws BizException {
		GetAlAndPhyBP bp = new GetAlAndPhyBP();
		return bp.exec(patid);
	}
}
