package iih.mm.pl.poplanstrategy.i;

import iih.mm.pl.poplanstrategy.d.PoPlanStrategyDO;
import xap.mw.core.data.BizException;

public interface IPoplanstrategyExtService {

	/**
	 * 将该仓库其余策略都更新为非默认
	 * @param strategy
	 * @throws BizException
	 */
	public abstract void updateFgDefault(PoPlanStrategyDO strategy) throws BizException;
}
