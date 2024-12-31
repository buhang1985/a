package iih.mc.mc.stockperinit.i;

import iih.mm.comm.finance.d.FinancePeriodDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public interface IStockperinitQryService {
	
	/**
	 * 判断仓库是否已经进行了[期初记账]处理
	 * @param whId 仓库ID
	 * @return true 已处理 false 未处理
	 * @throws BizException
	 */
	public FBoolean isWarehouseInited(String id_wh) throws BizException;
	
	/**
	 * 获取仓库期初记账年月
	 * @param whId 仓库ID
	 * @throws BizException
	 */
	public FinancePeriodDTO getWarehouseInitYearmonth(String id_wh) throws BizException;
}
