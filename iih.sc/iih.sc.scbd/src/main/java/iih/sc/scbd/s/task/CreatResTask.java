package iih.sc.scbd.s.task;

import iih.sc.scbd.s.task.bp.CreatResTaskBP;
import xap.mw.core.data.BizException;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.PreAlertReturnType;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 创建资源。(对所有不存在资源的科室和人员创建资源)
 * 
 * @author libaoliang
 */
public class CreatResTask implements IBackgroundWorkPlugin {
	/**
	 * 执行任务
	 */
	@Override
	public PreAlertObject executeTask(BgWorkingContext paramBgWorkingContext) throws BizException {
		CreatResTaskBP recycleBP = new CreatResTaskBP();
		recycleBP.exec(paramBgWorkingContext.getKeyMap());

		PreAlertObject obj = new PreAlertObject();
//		obj.setReturnType(PreAlertReturnType.RETURNNOTHING);
		return obj;
	}
}
