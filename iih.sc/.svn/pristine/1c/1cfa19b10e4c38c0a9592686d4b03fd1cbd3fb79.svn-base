package iih.sc.apt.s.task;

import iih.sc.apt.s.task.bp.AutoBreakAptBP;
import xap.mw.core.data.BizException;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.PreAlertReturnType;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 自动爽约任务
 * @author yank
 *
 */
public class AutoBreakAptTask implements IBackgroundWorkPlugin{

	/**
	 * 执行任务
	 */
	@Override
	public PreAlertObject executeTask(BgWorkingContext paramBgWorkingContext) throws BizException {
		AutoBreakAptBP breakAptBP = new AutoBreakAptBP();
		breakAptBP.exec(paramBgWorkingContext.getKeyMap());

		PreAlertObject obj = new PreAlertObject();
//		obj.setReturnType(PreAlertReturnType.RETURNNOTHING);
		return obj;
	}
}
