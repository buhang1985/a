package iih.en.pv.s;

import iih.en.pv.dto.d.ObservationDTO;
import iih.en.pv.i.IEnEmQryService;
import iih.en.pv.s.bp.ObsRegistBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 急诊查询服务
 * @author yankan
 * @date 2015-10-20
 *
 */
@Service(serviceInterfaces={IEnEmQryService.class}, binding=Binding.JSONRPC)
public class EnEmQryServiceImpl implements IEnEmQryService {
	/**
	 * 获取急诊留观许可证
	 * @param patId 患者id
	 * @return
	 * @throws BizException
	 */
	@Override
	public ObservationDTO[] getObsPermit(String patId) throws BizException{
		ObsRegistBP obsRegistBP = new ObsRegistBP();
		return obsRegistBP.getPermit(patId);
	}
	/**
	 * 获取留观许可
	 * @param entId 就诊id
	 * @return
	 */
	@Override
	public ObservationDTO getObsPermitByEntId(String entId) throws BizException{
		ObsRegistBP obsRegistBP = new ObsRegistBP();
		return obsRegistBP.getPermitByEntId(entId);
	}
}
