package iih.nm.nom.nommeet.i;

import iih.nm.nom.nommeet.d.NomMeetDO;
import xap.mw.core.data.BizException;

public interface INommeetFlowService {

	/**
	 * 提交质量模板
	 */
	public NomMeetDO[] submitTrans(String[] ids) throws BizException;

	/**
	 * 质量模板审核通过
	 */
	public NomMeetDO[] acceptTrans(NomMeetDO[] TransDOList) throws BizException;

	/**
	 * 质量模板审核驳回
	 */
	public NomMeetDO[] rejectTrans(NomMeetDO[] TransDOList) throws BizException;

	/**
	 * 获取查看进度用URL
	 */
	public String getFlowUrl(String id_task) throws BizException;

	/**
	 * 获取当前用户待办任务
	 */
	public String[] getMyUndoWorkTaskID() throws BizException;
}
