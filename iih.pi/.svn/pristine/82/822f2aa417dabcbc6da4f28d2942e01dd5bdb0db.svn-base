package iih.pi.reg.esoe.s;

import iih.pi.reg.esoe.bp.PiEsoeSyncDataBP;
import iih.pi.reg.esoe.d.PiEsoePatDTO;
import iih.pi.reg.esoe.i.IPiEsoeSyncService;
import xap.mw.core.data.BizException;

/**
 * 应急系统同步服务
 * @author ly 2019/09/30
 *
 */
public class PiEsoeSyncServiceImpl implements IPiEsoeSyncService{

	/**
	 * 同步应急系统数据
	 * @param patDtos
	 * @throws BizException
	 */
	@Override
	public void syncData(PiEsoePatDTO[] patDtos) throws BizException {
		PiEsoeSyncDataBP bp = new PiEsoeSyncDataBP();
		bp.exec(patDtos);
	}
}
