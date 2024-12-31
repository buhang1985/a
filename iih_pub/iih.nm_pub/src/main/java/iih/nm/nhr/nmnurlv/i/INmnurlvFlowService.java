package iih.nm.nhr.nmnurlv.i;

import iih.nm.nhr.nmnurlv.d.NmNurLvDO;
import iih.nm.nhr.nmpsnshift.d.NmNurTransDO;
import xap.mw.core.data.BizException;

public interface INmnurlvFlowService {
	/**
	 * 提交质量模板
	 */
	public NmNurLvDO[] submitTrans(String[] ids) throws BizException;

	/**
	 * 质量模板审核通过
	 */
	public NmNurLvDO[] acceptTrans(NmNurLvDO[] NmNurLvDOList) throws BizException;

	/**
	 * 质量模板审核驳回
	 */
	public NmNurLvDO[] rejectTrans(NmNurLvDO[] NmNurLvDOList) throws BizException;

	/**
	 * 获取查看进度用URL
	 */
	public String getFlowUrl(String id_task) throws BizException;

	/**
	 * 获取当前用户待办任务
	 */
	public String[] getMyUndoWorkTaskID() throws BizException;
}
