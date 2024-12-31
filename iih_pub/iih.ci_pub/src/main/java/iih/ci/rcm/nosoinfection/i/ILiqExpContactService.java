package iih.ci.rcm.nosoinfection.i;

import iih.ci.rcm.liqexpcontactdto.d.LiqExpContactDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface ILiqExpContactService {
	
	public abstract PagingRtnData<LiqExpContactDTO> getLiqExpContactList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;

}
