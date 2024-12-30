package iih.sc.sch.s.task;

import iih.sc.sch.s.task.bp.CloseSchChlBP;
import xap.mw.core.data.BizException;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 门诊排班关闭渠道任务
 * 
 * @author yzh
 *
 */
public class CloseSchChlTask implements IBackgroundWorkPlugin {

	/**
	 * 执行任务
	 */
	@Override
	public PreAlertObject executeTask(BgWorkingContext paramBgWorkingContext) throws BizException {
		CloseSchChlBP recycleBP = new CloseSchChlBP();
		recycleBP.exec(paramBgWorkingContext.getKeyMap());

		PreAlertObject obj = new PreAlertObject();
		// obj.setReturnType(PreAlertReturnType.RETURNNOTHING);
		return obj;
	}
}
