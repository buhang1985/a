package iih.sc.sch.s.task;

import iih.sc.sch.s.task.bp.RecycleTickBP;
import xap.mw.core.data.BizException;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 回收号源
 * 
 * @author yank
 *
 */
public class RecycleTickTask implements IBackgroundWorkPlugin {

	/**
	 * 执行任务
	 */
	@Override
	public PreAlertObject executeTask(BgWorkingContext paramBgWorkingContext) throws BizException {
		RecycleTickBP recycleBP = new RecycleTickBP();
		recycleBP.exec(paramBgWorkingContext.getKeyMap());

		PreAlertObject obj = new PreAlertObject();
		// obj.setReturnType(PreAlertReturnType.RETURNNOTHING);
		return obj;
	}
}
