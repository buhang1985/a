package iih.ci.mrm.i.cimrmqrylist;

import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface ICimrmqrylistCrudService {

	/**
	 * 散页登记列表
	 * @throws BizException 
	 * */
	public abstract PagingRtnData<CiMrmQryListDTO> GetRegisterQryList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)throws BizException;
	
	/**
	 * 散页详细登记列表
	 * @throws BizException 
	 * */
	
	public abstract PagingRtnData<CiMrmQryListDTO> GetRegisterDetailQryList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)throws BizException;
	
	/**
	 * 病案补充登记列表查询
	 * 
	 * **/
	public abstract PagingRtnData<CiMrmQryListDTO> GetRegisterSuppQryList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)throws BizException;
	
}
