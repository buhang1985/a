package iih.bl.cg.task;

import iih.bl.cg.i.IBlCgCmdService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.PreAlertReturnType;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 重发退费信息 退费调用第三方接口，如果失败，通过定时任务重新发送
 * 
 * @author yang.lu
 *
 */
public class ResendRefundInfoTask implements IBackgroundWorkPlugin {
	/**
	 * 执行任务
	 * 
	 * @param ctx
	 *            上下文
	 * @author yang.lu
	 */
	@Override
	public PreAlertObject executeTask(BgWorkingContext ctx) throws BizException {

		// 3、调用发送失败数据重新发送第三方忌口
		IBlCgCmdService iBlCgCmdService = ServiceFinder.find(IBlCgCmdService.class);
		iBlCgCmdService.sendRefundMsgAllToFail();

		PreAlertObject obj = new PreAlertObject();
//		obj.setReturnType(PreAlertReturnType.RETURNNOTHING);
		return obj;
	}
}
