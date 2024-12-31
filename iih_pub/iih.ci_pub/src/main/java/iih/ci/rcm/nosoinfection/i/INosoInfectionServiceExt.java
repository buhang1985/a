package iih.ci.rcm.nosoinfection.i;

import iih.ci.rcm.infectionpre.d.InfectionpreDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;


public interface INosoInfectionServiceExt{

	public abstract PagingRtnData<InfectionpreDTO> getInfectionRateList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
}
