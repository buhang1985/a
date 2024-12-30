package iih.sc.sch.s.task;

import iih.sc.comm.ScLogUtil;
import iih.sc.sch.s.task.bp.overduetick.HandleOpOverdueTickTaskBP;
import xap.mw.core.data.BizException;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 门诊_门诊排班过期号源处理
 * @author yaohl
 */
public class TickTimeChkPastTask  implements IBackgroundWorkPlugin {

	@Override
	public PreAlertObject executeTask(BgWorkingContext ctx) throws BizException {
		ScLogUtil.getInstance().logInfo("开始执行[门诊_门诊排班过期号源处理]!");
		HandleOpOverdueTickTaskBP bp = new HandleOpOverdueTickTaskBP();
		bp.exec(ctx.getKeyMap());
		ScLogUtil.getInstance().logInfo("执行结束[门诊_门诊排班过期号源处理]!");
		PreAlertObject obj = new PreAlertObject();
		return obj;
	}

}
