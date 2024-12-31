package iih.bd.mm.webserviceinvokerec.i;

import iih.bd.mm.webserviceinvokerec.d.WebServiceInvokeRecDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IWebServiceInvokeRecService {

	/**
	 * 根据查询模板查询数据
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<WebServiceInvokeRecDTO> findByQCondAndPageInfo(PaginationInfo pg, QryRootNodeDTO qryRootNodeDTO) throws BizException;
}
