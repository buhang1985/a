package iih.mm.pl.stockplan.i.pl;

import xap.mw.core.data.BizException;

/**
 * 采购计划对接第三方平台接口
 * 
 * @author dj.zhang
 *
 */
public interface IStockPlanPLService {

	/**
	 * 推送采购计划
	 * 
	 * @param ids
	 * @throws BizException
	 */
	public abstract String pushStockPlan(String[] ids) throws BizException;
}
