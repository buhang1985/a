package iih.en.que.task;

import iih.en.que.task.bp.DiagEndBP;
import xap.mw.core.data.BizException;
import xap.mw.log.logging.Logger;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 定时诊毕任务
 * @author liubin
 *
 */
public class DiagEndTask implements IBackgroundWorkPlugin {
	/**
	 * 任务插件执行体
	 * @param bgwc 执行环境
	 * @return <tt>PreAlertObject</tt> 
	 * 		      该返回值不允许为null！<p>
	 * 		      若后台任务插件成功执行但不打算发送消息，<p>
	 *        那么请将PreAlertObject的returnType设为PreAlertReturnType.RETURNNOTHING
	 * @throws BusinessException
	 */
	public PreAlertObject executeTask(BgWorkingContext bgwc) throws BizException{
		//业务逻辑
		Logger.info("开始执行把长时间未诊毕病人设置为诊毕!");
		new DiagEndBP().executeTask(bgwc.getKeyMap());
		Logger.info("完成执行把长时间未诊毕病人设置为诊毕!");
        PreAlertObject obj = new PreAlertObject();
//        obj.setReturnType(PreAlertReturnType.RETURNNOTHING);
        return obj;
	}
}
