package iih.ci.mrm.i.mrmsignoff.qry;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;

public interface IMrmSignoffService {

	/**
	*  病案待签收查询
	*/
	public abstract PagingRtnData<CiMrmQryListDTO> getMrmNeedSignOffDTOList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	/**
	*  病案已签收查询
	*/
	public abstract PagingRtnData<CiMrmQryListDTO> getMrmHasSignOffDTOList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	/**
	*  病案已扫描查询
	*/
	public abstract PagingRtnData<CiMrmQryListDTO> getMrmHasScanningDTOList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	
}
