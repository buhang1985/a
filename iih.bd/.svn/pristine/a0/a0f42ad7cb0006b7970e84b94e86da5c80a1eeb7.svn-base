package iih.bd.mm.task;

import xap.mw.core.data.BizException;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 更新物品规格后台任务
 * 
 * @author hao_wu 2019-3-7
 *
 */
public class UpdataMaterialSpecTask implements IBackgroundWorkPlugin {

	@Override
	public PreAlertObject executeTask(BgWorkingContext arg0) throws BizException {
		UpdataMaterialSpecBp bp = new UpdataMaterialSpecBp();
		bp.exec();

		return new PreAlertObject();
	}

}
