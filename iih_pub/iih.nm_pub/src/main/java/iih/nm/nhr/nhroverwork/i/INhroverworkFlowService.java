package iih.nm.nhr.nhroverwork.i;

import iih.nm.nhr.nhroverwork.d.NhrOverWorkDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * 护理管理_人员加班流程服务
 * 
 * @author lijm
 * @Time2019-5-8
 */
public interface INhroverworkFlowService {
	/**
	 * 提交（默认流程开始）
	 *
	 * @param doInst业务DO
	 * @return业务DO
	 * @throws BizException
	 */
	public NhrOverWorkDO submit(NhrOverWorkDO doInst) throws BizException;

	/**
	 * 通过
	 *
	 * @param doInst业务DO
	 * @throws BizException
	 */
	public void accept(NhrOverWorkDO doInst) throws BizException;

	/**
	 * 驳回
	 *
	 * @param doInst业务DO
	 * @throws BizException
	 */
	public void reject(NhrOverWorkDO doInst) throws BizException;

	/**
	 * 撤回（取回）
	 *
	 * @param doInst业务DO
	 * @throws BizException
	 */
	public void back(NhrOverWorkDO doInst) throws BizException;

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
	public PagingRtnData<NhrOverWorkDO> getToDoTaskPageInfoByUser(PaginationInfo pg, String userId) throws BizException;

	/**
	 * 获取用户已审批单据
	 * 
	 * @param pg
	 * @param userId
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<NhrOverWorkDO> getDoneTaskPageInfoByUser(PaginationInfo pg, String userId) throws BizException;

}
