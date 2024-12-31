package iih.ci.mrm.i.mrmexport;

import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IMrmExportQueryService {

	public abstract PagingRtnData<CiMrmQryListDTO> getMrmExportList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
}
