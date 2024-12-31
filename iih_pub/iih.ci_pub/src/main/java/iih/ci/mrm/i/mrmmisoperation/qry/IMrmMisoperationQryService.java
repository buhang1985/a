package iih.ci.mrm.i.mrmmisoperation.qry;

import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IMrmMisoperationQryService {

	/**
	 * 病案列表查询
	 * @throws BizException 
	 * */
	PagingRtnData<CiMrmQryListDTO> GetMrmPediatricsDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo) throws BizException;
	
	/**
	 * 修改列表查询
	 */
	 PagingRtnData<CiMrmQryListDTO> GetMrmUpdateDOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo) throws BizException;
  }
