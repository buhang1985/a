package iih.nm.nhr.nmnhrquit.i;

import iih.nm.nhr.nmnhrquit.d.NmNhrQuitDO;
import xap.mw.core.data.BizException;

public interface INmnhrQuitFlowService {

	/**
	 * 提交辞职申请
	 */
	public NmNhrQuitDO[] submitTrans(String[] ids) throws BizException;
	
	/**
	 * 撤销辞职申请
	 */
	public NmNhrQuitDO[] backOutTrans(NmNhrQuitDO[] TransDOList) throws BizException;

	/**
	 * 辞职申请审核通过
	 */
	public NmNhrQuitDO[] acceptTrans(NmNhrQuitDO[] TransDOList) throws BizException;

	/**
	 * 辞职申请审核驳回
	 */
	public NmNhrQuitDO[] rejectTrans(NmNhrQuitDO[] TransDOList) throws BizException;

	/**
	 * 获取查看进度用URL
	 */
	public String getFlowUrl(String id_task) throws BizException;

	/**
	 * 获取当前用户待办任务
	 */
	public String[] getMyUndoWorkTaskID() throws BizException;
}
