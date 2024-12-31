package iih.en.que.task;

import iih.en.que.task.bp.EnQueEmpMgrBP;
import xap.mw.core.data.BizException;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 自动医生出诊队列管理
 * 
 * @author liubin
 *
 */
public class EnQueEmpMgrTask implements IBackgroundWorkPlugin {

	@Override
	public PreAlertObject executeTask(BgWorkingContext ctx)
			throws BizException {
		new EnQueEmpMgrBP().exec(ctx.getKeyMap());
		PreAlertObject obj = new PreAlertObject();
		return obj;
	}

}
