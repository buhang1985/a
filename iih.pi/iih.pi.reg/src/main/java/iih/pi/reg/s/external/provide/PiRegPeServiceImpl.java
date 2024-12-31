package iih.pi.reg.s.external.provide;

import iih.pi.reg.dto.d.PiPatPeDTO;
import iih.pi.reg.i.external.provide.IPiRegPeService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.s.external.provide.bp.AbutExamPatBP;
import iih.pi.reg.s.external.provide.bp.FindPePatInfoBP;
import iih.pi.reg.s.external.provide.bp.UpdatePePatBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 患者对体检提供服务
 * 
 * @author houll 2018/11/19
 *
 */
@Service(serviceInterfaces = { IPiRegPeService.class }, binding = Binding.JSONRPC)
public class PiRegPeServiceImpl implements IPiRegPeService {

	/**
	 * 新增体检患者信息
	 * 
	 * @param aggDos
	 *            体检患者基本信息
	 * @return 患者信息
	 * @throws BizException
	 */
	@Override
	public PatiAggDO[] createPats(PiPatPeDTO[] aggDos) throws BizException {
		AbutExamPatBP bp = new AbutExamPatBP();
		return bp.exec(aggDos);
	}

	/**
	 * 更新体检患者信息
	 * 
	 * @param addDos
	 * @throws BizException
	 * 
	 */
	@Override
	public PatiAggDO[] updatePats(PiPatPeDTO[] aggDos) throws BizException {
		UpdatePePatBP updatePePatBP = new UpdatePePatBP();
		return updatePePatBP.exec(aggDos);
	}

	/**
	 * 查询是否存在体检患者
	 */
	@Override
	public PatDO[] find(PiPatPeDTO[] piPatPeDTOs) throws BizException {
		FindPePatInfoBP FindPePatInfoBP = new FindPePatInfoBP();
		return FindPePatInfoBP.exec(piPatPeDTOs);
	}
}
