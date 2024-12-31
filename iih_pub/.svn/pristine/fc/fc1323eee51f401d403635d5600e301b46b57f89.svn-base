package iih.nm.nhr.nmpsnshift.i;

import iih.nm.nhr.nmpsnshift.d.NmNurTransDO;
import xap.mw.core.data.BizException;

public interface INmpsnshiftFlowService {

	/**
	 * 提交质量模板
	 */
	public NmNurTransDO[] submitTrans(String[] ids) throws BizException;

	/**
	 * 质量模板审核通过
	 */
	public NmNurTransDO[] acceptTrans(NmNurTransDO[] TransDOList) throws BizException;

	/**
	 * 质量模板审核驳回
	 */
	public NmNurTransDO[] rejectTrans(NmNurTransDO[] TransDOList) throws BizException;

	/**
	 * 获取查看进度用URL
	 */
	public String getFlowUrl(String id_task) throws BizException;

	/**
	 * 获取当前用户待办任务
	 */
	public String[] getMyUndoWorkTaskID() throws BizException;
}
