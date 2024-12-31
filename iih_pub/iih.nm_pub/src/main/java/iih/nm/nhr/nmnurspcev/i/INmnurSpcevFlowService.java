package iih.nm.nhr.nmnurspcev.i;

import iih.nm.nhr.nmnurspcev.d.NmSpcEvDO;
import xap.mw.core.data.BizException;

public interface INmnurSpcevFlowService {
	/**
	 * 提交质量模板
	 */
	public NmSpcEvDO[] submitTrans(String[] ids) throws BizException;

	/**
	 * 质量模板审核通过
	 */
	public NmSpcEvDO[] acceptTrans(NmSpcEvDO[] NmNurLvDOList) throws BizException;

	/**
	 * 质量模板审核驳回
	 */
	public NmSpcEvDO[] rejectTrans(NmSpcEvDO[] NmNurLvDOList) throws BizException;

	/**
	 * 获取查看进度用URL
	 */
	public String getFlowUrl(String id_task) throws BizException;

	/**
	 * 获取当前用户待办任务
	 */
	public String[] getMyUndoWorkTaskID() throws BizException;
}
