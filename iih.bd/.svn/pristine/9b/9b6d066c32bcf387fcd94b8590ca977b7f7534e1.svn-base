package iih.bd.mm.task;
import iih.bd.mm.task.bp.AutoreplenishBp;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

public class AutoreplenishTask implements IBackgroundWorkPlugin{

	@Override
	public PreAlertObject executeTask(BgWorkingContext arg0) throws BizException {
		PreAlertObject preAlertObject = new PreAlertObject();
		AutoreplenishBp bp = new AutoreplenishBp();
		bp.exec(arg0);
		return preAlertObject;
	}
}
