package iih.ci.mrm.i.mrmbind.qry;

import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IMrmBindQryService {

	/**
	*  病案装订查询
	*/
	public abstract PagingRtnData<CiMrmQryListDTO> getMrmBindDTOList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
}
