package iih.nm.nhr.nmnhrschedrp.i;

import iih.nm.nhr.nmnhrschedrp.d.NhrSchedRpDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * 护理管理_人员替班流程服务
 * 
 * @author lijm
 * @Time 2019-4-24 19:39
 *
 */
public interface INmnhrschedrpFlowService {// / extends
											// INmFlowQryService<NhrSchedRpDO>,
											// INmFlowCudService<NhrSchedRpDO> {
	/**
	 * 提交（默认流程开始）
	 *
	 * @param doInst业务DO
	 * @return业务DO
	 * @throws BizException
	 */
	public NhrSchedRpDO submit(NhrSchedRpDO doInst) throws BizException;

	/**
	 * 通过
	 *
	 * @param doInst业务DO
	 * @throws BizException
	 */
	public void accept(NhrSchedRpDO doInst) throws BizException;

	/**
	 * 驳回
	 *
	 * @param doInst业务DO
	 * @throws BizException
	 */
	public void reject(NhrSchedRpDO doInst) throws BizException;

	/**
	 * 撤回（取回）
	 *
	 * @param doInst业务DO
	 * @throws BizException
	 */
	public void back(NhrSchedRpDO doInst) throws BizException;

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
	public PagingRtnData<NhrSchedRpDO> getToDoTaskPageInfoByUser(PaginationInfo pg, String userId) throws BizException;

	/**
	 * 获取用户已审批单据
	 * 
	 * @param pg
	 * @param userId
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<NhrSchedRpDO> getDoneTaskPageInfoByUser(PaginationInfo pg, String userId) throws BizException;

	/**
	 * 替班流程结束操作
	 * 
	 * @param schedLvDo
	 * @throws BizException
	 */
	public void NhrSchedRpFlowEndDoAction(NhrSchedRpDO schedRp) throws BizException;
}
