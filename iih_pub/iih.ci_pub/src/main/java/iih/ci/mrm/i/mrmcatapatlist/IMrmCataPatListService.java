package iih.ci.mrm.i.mrmcatapatlist;

import iih.ci.mrm.mrmcatapatlistdto.d.MrmCataPatListDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IMrmCataPatListService {

	/**
	 * 从编目表获取病案患者信息查询方案
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 */
    PagingRtnData<MrmCataPatListDTO> getCiMrFpPatData(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo,String orgparam)throws BizException;
    
    /**
	 * 病案编目--导出数据查询
	 * @param qryRootNodeDTO
	 * @param orgparam
	 * @return
	 */
    MrmCataPatListDTO[] getAllPageData(QryRootNodeDTO qryRootNodeDTO, String orgparam) throws BizException;
}
