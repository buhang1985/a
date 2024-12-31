package iih.nm.nqm.qctplmaintenance.i;

import iih.nm.nqm.qctplmaintenance.d.NmQctplDO;
import xap.mw.core.data.BizException;

public interface IQctplFlowService {

	public static final String QCTPL_FLOW_TYPE_PK = "@@@@Z8100000000KBZUP";

	/**
	 * 提交质量模板
	 */
	public NmQctplDO[] submitQctpl(String[] ids) throws BizException;

	/**
	 * 质量模板审核通过
	 */
	public NmQctplDO[] acceptQctpl(NmQctplDO[] QctplDOList) throws BizException;

	/**
	 * 质量模板审核驳回
	 */
	public NmQctplDO[] rejectQctpl(NmQctplDO[] QctplDOList) throws BizException;

	/**
	 * 获取查看进度用URL
	 */
	public String getFlowUrl(String id_task) throws BizException;

	/**
	 * 获取当前用户待办任务
	 */
	public String[] getMyUndoWorkTaskID() throws BizException;
}
