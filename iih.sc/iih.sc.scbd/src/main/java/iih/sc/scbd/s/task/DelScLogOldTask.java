package iih.sc.scbd.s.task;

import iih.sc.scbd.s.task.bp.DelScLogOldTaskBP;
import xap.mw.core.data.BizException;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 定时删除EN-SC日志记录
 * 
 * @author liubin
 *
 */
public class DelScLogOldTask implements IBackgroundWorkPlugin {

	@Override
	public PreAlertObject executeTask(BgWorkingContext ctx) throws BizException {
		DelScLogOldTaskBP bp = new DelScLogOldTaskBP();
		bp.exec(ctx.getKeyMap());
		PreAlertObject obj = new PreAlertObject();
		return obj;
	}
}
