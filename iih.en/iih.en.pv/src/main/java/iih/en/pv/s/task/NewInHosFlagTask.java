package iih.en.pv.s.task;

import iih.en.pv.s.task.bp.ResetNewInHosFlagBP;
import xap.mw.core.data.BizException;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 新入院标识处理任务
 * @author Administrator
 *
 */
public class NewInHosFlagTask implements IBackgroundWorkPlugin{

	/**
	 * 
	 */
	@Override
	public PreAlertObject executeTask(BgWorkingContext paramBgWorkingContext) throws BizException {
		ResetNewInHosFlagBP resetNewInHosBP = new ResetNewInHosFlagBP();
		resetNewInHosBP.exec();
		
        PreAlertObject obj = new PreAlertObject();
//        obj.setReturnType(PreAlertReturnType.RETURNNOTHING);
        return obj;
	}

}
