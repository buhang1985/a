package iih.en.pv.s.task;

import iih.en.pv.s.task.bp.DelExpiredEnAuthBP;
import xap.mw.core.data.BizException;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/***
 * 定时清除过期的授权标签
 * @author zhangpp
 *
 */
public class DelExpiredEnAuthTask implements IBackgroundWorkPlugin {

	@Override
	public PreAlertObject executeTask(BgWorkingContext paramBgWorkingContext) throws BizException {
		
		//执行BP
		DelExpiredEnAuthBP del = new DelExpiredEnAuthBP();
		del.exec();

		PreAlertObject obj = new PreAlertObject();
		return obj;
		
	}

}
