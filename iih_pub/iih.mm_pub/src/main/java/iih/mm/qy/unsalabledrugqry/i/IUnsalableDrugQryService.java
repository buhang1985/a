package iih.mm.qy.unsalabledrugqry.i;

import iih.mm.qy.lowstoragequerydto.d.LowStorageQueryDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 滞销药品查询（使用低储查询的DTO）
 * @author liuyilin
 *
 */
public interface IUnsalableDrugQryService {

	/**
	 * 滞销药品查询
	 * @param pg
	 * @param orderByPart
	 * @param qryRootNodeDTO
	 * @return
	 * @throws BizException
	 */
	PagingRtnData<LowStorageQueryDTO> getUnsalableDrug(PaginationInfo pg, String orderByPart, QryRootNodeDTO qryRootNodeDTO) throws BizException;
	
}
  
