package iih.nm.nqm.nmnqmqcmt.i;

import iih.nm.nqm.nmnqmqcmt.d.NmNqmQcmtDO;
import xap.mw.core.data.BizException;

public interface INmnqmqcmtFlowService {
	/**
	 * 提交质量模板
	 */
	public NmNqmQcmtDO[] submitTrans(String[] ids) throws BizException;

	/**
	 * 质量模板审核通过
	 */
	public NmNqmQcmtDO[] acceptTrans(NmNqmQcmtDO[] NmNqmQcmtDO) throws BizException;

	/**
	 * 质量模板审核驳回
	 */
	public NmNqmQcmtDO[] rejectTrans(NmNqmQcmtDO[] NmNqmQcmtDO) throws BizException;

	/**
	 * 获取查看进度用URL
	 */
	public String getFlowUrl(String id_task) throws BizException;

	/**
	 * 获取当前用户待办任务
	 */
	public String[] getMyUndoWorkTaskID() throws BizException;
}
