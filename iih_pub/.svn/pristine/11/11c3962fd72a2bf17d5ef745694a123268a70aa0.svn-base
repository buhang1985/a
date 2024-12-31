package iih.ci.mrm.i.mrmprint.qry;

import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IMrmPrintQryService {
	/**
	*  病案打印查询
	*/
	public abstract PagingRtnData<CiMrmQryListDTO> getMrmPrintDTOList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo,String sd_bd_mrm_ot) throws BizException;
}
