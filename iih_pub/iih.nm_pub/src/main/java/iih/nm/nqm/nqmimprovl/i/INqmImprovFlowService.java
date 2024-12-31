package iih.nm.nqm.nqmimprovl.i;

import iih.nm.nqm.nqmimprovl.d.NqmImprovDO;
import iih.nm.nqm.nqmimprovl.d.NqmImprovMendRecDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

public interface INqmImprovFlowService {

	/**
	 * 提交（默认流程开始）
	 *
	 * @param doInst业务DO
	 * @return业务DO
	 * @throws BizException
	 */
	public NqmImprovDO submit(NqmImprovDO improvDO) throws BizException;

	/**
	 * 整改
	 * @param doInst
	 * @return
	 * @throws BizException
	 */
	public void mend(NqmImprovDO improvDO) throws BizException;
	
	
	/**
	 * 通过
	 *
	 * @param doInst业务DO
	 * @throws BizException
	 */
	public void accept(NqmImprovMendRecDO mendRecDO) throws BizException;

	/**
	 * 驳回
	 *
	 * @param doInst业务DO
	 * @throws BizException
	 */
	public void reject(NqmImprovMendRecDO mendRecDO) throws BizException;

}
