package iih.sc.sch.s.task;

import iih.sc.comm.ScLogUtil;
import iih.sc.sch.s.task.bp.overduetick.ScOverdueTickHandleTaskBP;
import xap.mw.core.data.BizException;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 预约过期号位处理
 * @author li.wm
 */
public class ScOverdueTickHandleTask  implements IBackgroundWorkPlugin {

	@Override
	public PreAlertObject executeTask(BgWorkingContext ctx) throws BizException {
		ScLogUtil.getInstance().logInfo("开始执行[预约过期号处理]!");
		ScOverdueTickHandleTaskBP bp = new ScOverdueTickHandleTaskBP();
		bp.exec(ctx.getKeyMap());
		ScLogUtil.getInstance().logInfo("执行结束[预约过期号处理]!");
		PreAlertObject obj = new PreAlertObject();
		return obj;
	}

}
