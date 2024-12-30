package iih.sc.scp.s.task;

import iih.sc.scp.s.task.bp.CalcOpPlanAveSrvlotTaskBP;
import xap.mw.core.data.BizException;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 计算门诊排班计划平均就诊时长定时任务
 * 
 * @author zhengcm
 * @date 2017-12-19 14:55:08
 *
 */
public class CalcOpPlanAveSrvlotTask implements IBackgroundWorkPlugin {

	/**
	 * 执行任务
	 */
	@Override
	public PreAlertObject executeTask(BgWorkingContext paramBgWorkingContext) throws BizException {
		CalcOpPlanAveSrvlotTaskBP taskBP = new CalcOpPlanAveSrvlotTaskBP();
		taskBP.exec(paramBgWorkingContext.getKeyMap());
		PreAlertObject obj = new PreAlertObject();
		return obj;
	}

}
