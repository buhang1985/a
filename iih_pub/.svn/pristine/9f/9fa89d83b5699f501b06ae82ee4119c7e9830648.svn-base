package iih.ci.mrm.i.mrmmailquery.qry;

import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IMrmMailQryQueryService {
	
	/**
	 * 病案邮寄查询节点-查询
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<CiMrmQryListDTO> getMrmMailDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo) throws BizException;
	
}
