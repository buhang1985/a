package iih.en.pv.s.task;

import iih.en.pv.s.task.bp.OpEvaluate4SmsBP;
import xap.mw.core.data.BizException;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 门诊评价短信提醒任务
 * @author yank
 *
 */
public class OpEvaluate4SmsTask  implements IBackgroundWorkPlugin{

	/**
	 * 执行任务
	 */
	@Override
	public PreAlertObject executeTask(BgWorkingContext paramBgWorkingContext) throws BizException {
		OpEvaluate4SmsBP evaluate4SmsBP = new OpEvaluate4SmsBP();
		evaluate4SmsBP.exec();
		
		PreAlertObject obj = new PreAlertObject();
//        obj.setReturnType(PreAlertReturnType.RETURNNOTHING);
        return obj;
	}
}
