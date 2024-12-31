package iih.pi.acc.s.task;

import iih.pi.acc.s.bp.ResetGuaranteeExpireCredLimitBP;
import xap.mw.core.data.BizException;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 重置担保到期信用额度任务
 * @author yzh
 * @date 2020年4月21日16:53:24
 */
public class ResetGuaranteeExpireCredLimitTask implements IBackgroundWorkPlugin{

	/**
	 * 执行任务
	 */
	@Override
	public PreAlertObject executeTask(BgWorkingContext paramBgWorkingContext) throws BizException {
		ResetGuaranteeExpireCredLimitBP bp = new ResetGuaranteeExpireCredLimitBP();
		bp.exec(paramBgWorkingContext.getKeyMap());
		PreAlertObject obj = new PreAlertObject();
		return obj;
	}

}
