package iih.bl.itf.esoe.i;

import iih.bl.itf.esoe.d.BlEsoeSaleDTO;
import xap.mw.core.data.BizException;

/**
 * 
 * 应急系统同步服务
 * @author ly 2019/09/26
 *
 */
public interface IBlEsoeSyncService {

	/**
	 * 同步应急系统数据
	 * @param saleDtos
	 * @throws BizException
	 * @author ly 2019/09/26
	 */
	public abstract void syncData(BlEsoeSaleDTO[] saleDtos) throws BizException;
	
}
