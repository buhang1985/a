
package iih.sc.sch.s.task;

import iih.sc.sch.s.task.bp.DeletePastLockTaskBP;
import xap.mw.core.data.BizException;
import xap.mw.log.logging.Logger;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/***
 * 定时删除历史锁记录
 * @author fanlq
 * @date: 2019年10月22日 下午12:00:20
 */
public class DeletePastLockTask  implements IBackgroundWorkPlugin {
	/**
	 * 执行任务
	 */
	@Override
	public PreAlertObject executeTask(BgWorkingContext bwContext) throws BizException {
		
		Logger.info("开始执行定时删除历史锁记录任务!");
		new DeletePastLockTaskBP().exec(bwContext.getKeyMap());
		Logger.info("结束定时删除历史锁记录任务!");
		
		PreAlertObject obj = new PreAlertObject();
		return obj;
	}

}
