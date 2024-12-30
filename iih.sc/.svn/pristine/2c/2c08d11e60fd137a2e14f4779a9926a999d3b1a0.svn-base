package iih.sc.sch.s.task;

import iih.sc.sch.s.task.bp.ReleaseOverdueLockTaskBP;
import xap.mw.core.data.BizException;
import xap.mw.log.logging.Logger;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/***
 * 定时释放过期锁
 * @author fanlq
 * @date: 2019年10月22日 下午12:00:10
 */
public class ReleaseOverdueLockTask  implements IBackgroundWorkPlugin {
	/**
	 * 执行任务
	 */
	@Override
	public PreAlertObject executeTask(BgWorkingContext bwContext) throws BizException {
		//业务逻辑
		Logger.info("开始执行定时释放过期锁任务!");
		new ReleaseOverdueLockTaskBP().exec(bwContext.getKeyMap());
		Logger.info("结束定时释放过期锁任务!");
		
		PreAlertObject obj = new PreAlertObject();
		return obj;
	}

}
