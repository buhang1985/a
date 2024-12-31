package iih.bd.pp.task;

import iih.bd.pp.task.bp.ModifyPriceTaskBP;
import xap.mw.core.data.BizException;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 调价计划定时调价任务
 * 
 * @author hao_wu
 */
public class ModifyPricePlanTask implements IBackgroundWorkPlugin {
	/**
	 * 执行任务
	 */
	@Override
	public PreAlertObject executeTask(BgWorkingContext bgwc) throws BizException {
		ModifyPriceTaskBP bp = new ModifyPriceTaskBP();
		bp.exec(bgwc);
		PreAlertObject preAlertObject = new PreAlertObject();
		return preAlertObject;
	}
}
