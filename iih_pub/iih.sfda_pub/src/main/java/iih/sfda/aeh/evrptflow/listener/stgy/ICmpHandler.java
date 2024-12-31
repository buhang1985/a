package iih.sfda.aeh.evrptflow.listener.stgy;

import xap.mw.core.data.BizException;
import xap.wf.af.runtime.TaskInstance;

/**
 * 任务完成后事件处理
 * 
 * @author lijm
 * @Date2019-8-2 17:28:21
 *
 */
public interface ICmpHandler {

	/**
	 * 执行动作
	 * 
	 * @param taskIns任务实例
	 * @throws BizException
	 */
	public void dowork(TaskInstance taskIns) throws BizException;
}
