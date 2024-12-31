package iih.en.que.task;

import iih.en.que.task.bp.DelEntQueBP;
import xap.mw.core.data.BizException;
import xap.mw.log.logging.Logger;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 定时删除就诊队列任务
 * 
 * @author liubin
 *
 */
public class DelEntQueTask implements IBackgroundWorkPlugin {
	
	@Override
	public PreAlertObject executeTask(BgWorkingContext ctx) throws BizException {
		//业务逻辑
		Logger.info("开始执行删除过期就诊队列!");
		new DelEntQueBP().executeTask();
		Logger.info("完成执行删除过期就诊队列!");
		
        PreAlertObject obj = new PreAlertObject();
//        obj.setReturnType(PreAlertReturnType.RETURNNOTHING);
        return obj;
	}

}
