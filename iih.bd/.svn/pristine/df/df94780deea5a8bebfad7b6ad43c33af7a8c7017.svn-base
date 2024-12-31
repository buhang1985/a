package iih.bd.mm.webserviceinvokerec.bp;

import iih.bd.base.utils.SqlUtils;
import iih.bd.mm.webserviceinvokerec.bp.sql.FindByQrySql;
import iih.bd.mm.webserviceinvokerec.d.WebServiceInvokeRecDTO;
import org.apache.commons.lang.StringUtils;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public class FindByQryBp {

	public PagingRtnData<WebServiceInvokeRecDTO> exec(PaginationInfo pg, QryRootNodeDTO qryRootNodeDTO) throws BizException {
		
		String qryDTO = getQryDTO(qryRootNodeDTO);
		FindByQrySql sql = new FindByQrySql(qryDTO);
		PagingServiceImpl<WebServiceInvokeRecDTO> pagingServiceImpl = new PagingServiceImpl<WebServiceInvokeRecDTO>();
		PagingRtnData<WebServiceInvokeRecDTO> result = pagingServiceImpl.findByPageInfo(new WebServiceInvokeRecDTO(), pg, sql.getSql(), "", null);
		return result;
	}

	public String getQryDTO(QryRootNodeDTO qryRootNodeDTO) throws BizException {

		StringBuffer qrywhere = new StringBuffer(" 1 = 1 ");
		
		String qryDTO = SqlUtils.getWherePartByQCond(qryRootNodeDTO);
		if(StringUtils.isNotEmpty(qryDTO)){
			qrywhere.append(" and ");
			qrywhere.append(qryDTO);
		}
		return qrywhere.toString();
	}
}
