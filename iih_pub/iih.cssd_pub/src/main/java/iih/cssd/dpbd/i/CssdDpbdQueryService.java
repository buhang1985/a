package iih.cssd.dpbd.i;

import iih.cssd.dpbd.pkg.d.CssdPkgDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface CssdDpbdQueryService {

	/**
	 * 消毒包定义查询
	 * @param pg
	 * @param queryNode
	 * @param id_pkgca
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<CssdPkgDO> getPkgList(PaginationInfo pg, QryRootNodeDTO queryNode, String id_pkgca) throws BizException;
}
