package iih.sc.scp.s.task;

import iih.sc.scp.s.task.bp.ReleaseUnFeeAptOpBP;
import xap.mw.core.data.BizException;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 根据预约释放规则释放：门诊
 * @author LTF
 * @date 2019年4月24日 15:32:11
 */
public class ReleaseUnFeeAptOpTask implements IBackgroundWorkPlugin{
	
	/**
	 * 执行任务
	 */
	@Override
	public PreAlertObject executeTask(BgWorkingContext bgworkingcontext) throws BizException {
		ReleaseUnFeeAptOpBP releaseUnFeeAptOpBP = new ReleaseUnFeeAptOpBP();
		releaseUnFeeAptOpBP.exec(bgworkingcontext.getKeyMap());
		PreAlertObject obj = new PreAlertObject();
		return obj;
	}
	
}
