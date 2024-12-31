package iih.bl.itf.esoe.s;

import iih.bl.itf.esoe.d.BlEsoeSaleDTO;
import iih.bl.itf.esoe.i.IBlEsoeSyncService;
import iih.bl.itf.esoe.s.bp.BlEsoeSyncDataBP;
import xap.mw.core.data.BizException;

/**
 * 
 * 应急系统同步服务
 * @author ly 2019/09/26
 *
 */
public class BlEsoeSyncServiceImpl implements IBlEsoeSyncService{

	/**
	 * 同步应急系统数据
	 * @param saleDtos
	 * @throws BizException
	 * @author ly 2019/09/26
	 */
	@Override
	public void syncData(BlEsoeSaleDTO[] saleDtos) throws BizException {
		BlEsoeSyncDataBP bp = new BlEsoeSyncDataBP();
		bp.exec(saleDtos);
	}
}
