package iih.en.que.task;

import iih.en.que.task.bp.EntQueDaysLotMoveBP;
import xap.mw.core.data.BizException;
import xap.mw.log.logging.Logger;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 把上一午别签到未接诊的门诊患者移入下一午别队列
 * 
 * @author liubin
 *
 */
public class EntQueDaysLotMoveTask implements IBackgroundWorkPlugin {

	@Override
	public PreAlertObject executeTask(BgWorkingContext ctx) throws BizException {
		//业务逻辑
		Logger.info("开始执行把上一午别签到未接诊的门诊患者移入下一午别队列!");
		new EntQueDaysLotMoveBP().executeTask(ctx.getKeyMap());
		Logger.info("完成执行把上一午别签到未接诊的门诊患者移入下一午别队列!");
		
        PreAlertObject obj = new PreAlertObject();
//        obj.setReturnType(PreAlertReturnType.RETURNNOTHING);
        return obj;
	}

}
