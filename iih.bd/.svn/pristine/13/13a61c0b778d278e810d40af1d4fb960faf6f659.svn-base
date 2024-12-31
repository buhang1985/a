package iih.bd.mm.webserviceinvokerec.s;

import iih.bd.mm.webserviceinvokerec.bp.FindByQryBp;
import iih.bd.mm.webserviceinvokerec.d.WebServiceInvokeRecDTO;
import iih.bd.mm.webserviceinvokerec.i.IWebServiceInvokeRecService;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public class WebServiceInvokeRecServiceImpl implements IWebServiceInvokeRecService{

	@Override
	public PagingRtnData<WebServiceInvokeRecDTO> findByQCondAndPageInfo(PaginationInfo pg,
			QryRootNodeDTO qryRootNodeDTO) throws BizException {
		FindByQryBp bp = new FindByQryBp();
		PagingRtnData<WebServiceInvokeRecDTO> result = bp.exec(pg, qryRootNodeDTO);
		return result;
	}

}
