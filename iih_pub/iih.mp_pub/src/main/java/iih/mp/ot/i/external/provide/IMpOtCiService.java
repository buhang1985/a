package iih.mp.ot.i.external.provide;

import xap.mw.core.data.BizException;

/**
 * 医技执行域提供给临床域服务接口
 * 
 * @author hao_wu 2018-8-8
 *
 */
public interface IMpOtCiService {

	/**
	 * 医技执行确认</br>
	 * 医技工作站签署时调用，完成医嘱拆分、记账、医技确认、生成医技药单、发送医技药单流程
	 * 
	 * @throws BizException
	 */
	public abstract void otExecConfirm(String[] ordIds) throws BizException;

	/**
	 * 医技执行取消</br>
	 * 医技工作站作废时调用</br>
	 * 如果已经发药，则完成生成医技退药单、发送医技退药单、取消确认流程 </br>
	 * 如果未发药，则完成请领单作废、取消确认、取消记账流程
	 * 
	 * @throws BizException
	 */
	public abstract void otExecCancel(String[] ordIds) throws BizException;
}
