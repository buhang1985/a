package iih.nm.nhr.nmnhrschedlv.i;

import iih.nm.nhr.nmnhrschedlv.d.NmNhrSchedLvDO;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

public interface INmnhrschedlvFlowService {

	/**
	 * 提交（默认流程开始）
	 *
	 * @param doInst业务DO
	 * @return业务DO
	 * @throws BizException
	 */
	public NmNhrSchedLvDO submit(NmNhrSchedLvDO doInst) throws BizException;

	/**
	 * 通过
	 *
	 * @param doInst业务DO
	 * @throws BizException
	 */
	public void accept(NmNhrSchedLvDO doInst) throws BizException;

	/**
	 * 驳回
	 *
	 * @param doInst业务DO
	 * @throws BizException
	 */
	public void reject(NmNhrSchedLvDO doInst) throws BizException;

	/**
	 * 撤回（取回）
	 *
	 * @param doInst业务DO
	 * @throws BizException
	 */
	public void back(NmNhrSchedLvDO doInst) throws BizException;

	/**
	 * 查看进度
	 * 
	 * @param id_task任务进度
	 * @return进度
	 * @throws BizException
	 */
	public String getFlowUrl(String id_task) throws BizException;

	/**
	 * 获取用户待审批单据
	 * 
	 * @param userId
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<NmNhrSchedLvDO> getToDoTaskPageInfoByUser(PaginationInfo pg, String userId) throws BizException;

	/**
	 * 获取用户已审批单据
	 * 
	 * @param pg
	 * @param userId
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<NmNhrSchedLvDO> getDoneTaskPageInfoByUser(PaginationInfo pg, String userId) throws BizException;

	/**
	 * 请假流程结束操作
	 * 
	 * @param schedLvDo
	 * @throws BizException
	 */
	public void NmnhrschedlvFlowEndDoAction(NmNhrSchedLvDO schedLvDo) throws BizException;
}
