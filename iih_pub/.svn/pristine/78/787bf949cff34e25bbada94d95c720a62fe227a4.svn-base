package iih.nm.com.i.flow;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

public interface INmFlowQryService<T extends BaseDO> {

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
	public PagingRtnData<T> getToDoTaskPageInfoByUser(PaginationInfo pg, String userId) throws BizException;

	/**
	 * 获取用户已审批单据
	 * 
	 * @param pg
	 * @param userId
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<T> getDoneTaskPageInfoByUser(PaginationInfo pg, String userId) throws BizException;

}
