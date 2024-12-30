package iih.sc.scp.s.task;

import iih.sc.scp.s.task.bp.ReleaseSchResAccordingToRulesBP;
import xap.mw.core.data.BizException;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 根据号源释放规则释放排班资源定时任务
 * @author yzh
 * @date 2018年8月21日 15:32:11
 */
public class ReleaseSchResAccordingToRulesTask implements IBackgroundWorkPlugin {

	/**
	 * 执行任务
	 */
	@Override
	public PreAlertObject executeTask(BgWorkingContext paramBgWorkingContext) throws BizException {
		ReleaseSchResAccordingToRulesBP taskBP = new ReleaseSchResAccordingToRulesBP();
		taskBP.exec(paramBgWorkingContext.getKeyMap());
		PreAlertObject obj = new PreAlertObject();
		return obj;
	}

}
