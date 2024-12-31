package iih.nm.nqm.nqmadev.i;

import iih.nm.nqm.nqmadev.d.NqmAdEvDO;
import xap.mw.core.data.BizException;

public interface INqmAdevFlowService {

	/**
	 * 提交不良事件上报申请
	 */
	public NqmAdEvDO[] submitTrans(String[] ids) throws BizException;

	/**
	 * 不良事件上报审核通过
	 */
	public NqmAdEvDO[] acceptTrans(NqmAdEvDO[] TransDOList) throws BizException;

	/**
	 * 不良事件上报审核驳回
	 */
	public NqmAdEvDO[] rejectTrans(NqmAdEvDO[] TransDOList) throws BizException;

	/**
	 * 获取查看进度用URL
	 */
	public String getFlowUrl(String id_task) throws BizException;

	/**
	 * 获取当前用户待办任务
	 */
	public String[] getMyUndoWorkTaskID() throws BizException;
}
