package iih.nm.nit.nitlv.i;

import iih.nm.nit.nitlv.d.NitLvDO;
import xap.mw.core.data.BizException;

public interface INitlvFlowService {
	/**
	 * 提交质量模板
	 */
	public NitLvDO[] submitTrans(String[] ids) throws BizException;

	/**
	 * 质量模板审核通过
	 */
	public NitLvDO[] acceptTrans(NitLvDO[] NitLvDOList) throws BizException;

	/**
	 * 质量模板审核驳回
	 */
	public NitLvDO[] rejectTrans(NitLvDO[] NitLvDOList) throws BizException;

	/**
	 * 获取查看进度用URL
	 */
	public String getFlowUrl(String id_task) throws BizException;

	/**
	 * 获取当前用户待办任务
	 */
	public String[] getMyUndoWorkTaskID() throws BizException;
}
