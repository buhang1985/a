package iih.en.pv.s.task;

import iih.en.pv.s.task.bp.DelExpiredStatus;
import xap.mw.core.data.BizException;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
/**
 * 定时处理就诊状况
 * 
 * @author Sarah
 *
 */
public class DelExpiredStatusTask  implements IBackgroundWorkPlugin{

	/**
	 * 定时处理就诊状况
	 */
	@Override
	public PreAlertObject executeTask(BgWorkingContext paramBgWorkingContext) throws BizException {
		
		DelExpiredStatus delStatus = new DelExpiredStatus();
		delStatus.exec(paramBgWorkingContext.getKeyMap());

		PreAlertObject obj = new PreAlertObject();
		return obj;
	}
}
