package iih.ci.rcm.nosoinfection.i;

import iih.ci.rcm.infecoutbreakdetailreportdto.d.InfecOutbreakDetailReportDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

public interface IInfecOutbreakDetailReportService {

	public abstract PagingRtnData<InfecOutbreakDetailReportDTO> getInfecOutbreakDetailList(PaginationInfo paginationInfo,String[] ids) throws BizException;
	
}
