package iih.ci.rcm.nosoinfection.i;

import iih.ci.rcm.infectioncasedto.d.InfectionCaseDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IInfectionCaseService {
	
	public abstract PagingRtnData<InfectionCaseDTO> getInfectionCaseList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	
}
