package iih.ci.rcm.nosoinfection.i;

import iih.ci.rcm.msinjurydto.d.MsInjuryDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IMsInjuryService {
	
	public abstract PagingRtnData<MsInjuryDTO> getMsInjuryList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
}
