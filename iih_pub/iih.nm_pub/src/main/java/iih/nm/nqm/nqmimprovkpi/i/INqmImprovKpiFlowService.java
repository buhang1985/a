package iih.nm.nqm.nqmimprovkpi.i;

import iih.nm.nqm.nqmimprovkpi.d.NqmImprovKpiDO;
import xap.mw.core.data.BizException;

public interface INqmImprovKpiFlowService {

	/**
	 * 提交质量模板
	 */
	public NqmImprovKpiDO[] submitTrans(String[] ids) throws BizException;

	/**
	 * 质量模板审核通过
	 */
	public NqmImprovKpiDO[] acceptTrans(NqmImprovKpiDO[] TransDOList) throws BizException;

	/**
	 * 质量模板审核驳回
	 */
	public NqmImprovKpiDO[] rejectTrans(NqmImprovKpiDO[] TransDOList) throws BizException;

	/**
	 * 获取查看进度用URL
	 */
	public String getFlowUrl(String id_task) throws BizException;

	/**
	 * 获取当前用户待办任务
	 */
	public String[] getMyUndoWorkTaskID() throws BizException;
}
