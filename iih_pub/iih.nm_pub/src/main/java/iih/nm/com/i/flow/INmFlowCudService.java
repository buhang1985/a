package iih.nm.com.i.flow;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;

/**
 * 护理管理_业务审批流程公共接口
 * 
 * @author lijm
 *
 * @param <T>BaseDO
 */
public interface INmFlowCudService<T extends BaseDO> {

	/**
	 * 提交（默认流程开始）
	 *
	 * @param doInst业务DO
	 * @return业务DO
	 * @throws BizException
	 */
	public T submit(T doInst) throws BizException;

	/**
	 * 通过
	 *
	 * @param doInst业务DO
	 * @throws BizException
	 */
	public void accept(T doInst) throws BizException;

	/**
	 * 驳回
	 *
	 * @param doInst业务DO
	 * @throws BizException
	 */
	public void reject(T doInst) throws BizException;

	/**
	 * 撤回（取回）
	 *
	 * @param doInst业务DO
	 * @throws BizException
	 */
	public void back(T doInst) throws BizException;
}
