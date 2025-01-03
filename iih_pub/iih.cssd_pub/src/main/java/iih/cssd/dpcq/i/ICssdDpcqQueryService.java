package iih.cssd.dpcq.i;

import iih.cssd.dpp.dfp.d.CssdDfpDO;
import iih.cssd.dpp.dto.stz.d.DfpStzDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface ICssdDpcqQueryService {
	/**
	 * 查询过期消毒包列表
	 * 
	 * @param pg
	 * @param queryNode
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<CssdDfpDO> getList(PaginationInfo pg, QryRootNodeDTO queryNode) throws BizException;

	/**
	 * 获取手术是敷料分类集合
	 * @return
	 * @throws BizException
	 */
	public abstract String[] getOperDress() throws BizException;

	/**
	 * 获取消毒包灭菌列表
	 * 
	 * @param pg
	 * @param queryNode
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<DfpStzDTO> getStzList(PaginationInfo pg, QryRootNodeDTO queryNode) throws BizException;
}
