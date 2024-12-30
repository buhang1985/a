package iih.sc.scp.s.task;

import iih.sc.scp.s.task.bp.MtAptNoticeTimerBP;
import xap.mw.core.data.BizException;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 医技提前一天通知就诊短信
 * @author yzh
 * @date 2018年10月30日 19:24:14
 */
public class MtAptNoticeTimerTask implements IBackgroundWorkPlugin {

	/**
	 * 执行任务
	 */
	@Override
	public PreAlertObject executeTask(BgWorkingContext paramBgWorkingContext) throws BizException {
		MtAptNoticeTimerBP taskBP = new MtAptNoticeTimerBP();
		taskBP.exec(paramBgWorkingContext.getKeyMap());
		PreAlertObject obj = new PreAlertObject();
		return obj;
	}

}
