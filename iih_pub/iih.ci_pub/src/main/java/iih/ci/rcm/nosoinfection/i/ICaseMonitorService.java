package iih.ci.rcm.nosoinfection.i;

import iih.ci.rcm.casesurvedto.d.CaseSurveDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface ICaseMonitorService {

	public abstract PagingRtnData<CaseSurveDTO> getCaseSurveList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	
}
