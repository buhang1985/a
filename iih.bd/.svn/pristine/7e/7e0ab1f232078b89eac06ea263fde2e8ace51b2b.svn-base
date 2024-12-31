package iih.bd.pp.hpsrvorcadto.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.hpsrvorcadto.d.HpsrvorcaDTO;
import iih.bd.pp.hpsrvorcadto.s.bp.sql.FindsrvorcaDtoSql;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public class FindAuditedFwssPagingDataBp {
	public PagingRtnData<HpsrvorcaDTO> exec(QryRootNodeDTO qryRootNodeDto, PaginationInfo pg) throws BizException {
		String wherePart = GetWherePart(qryRootNodeDto);
		FindsrvorcaDtoSql sql = new FindsrvorcaDtoSql(wherePart);
		PagingServiceImpl<HpsrvorcaDTO> pagingServiceImpl = new PagingServiceImpl<HpsrvorcaDTO>();
		PagingRtnData<HpsrvorcaDTO> result = pagingServiceImpl.findByPageInfo(new HpsrvorcaDTO(), pg,
				sql.getQrySQLStr(), "SRVORCA.HIS_CODE", sql.getQryParameter(null));
		return result;
	}

	/**
	 * 查询方案生成条件语句
	 * 
	 * @param qryRootNodeDto
	 * @return
	 * @throws BizException
	 */
	private String GetWherePart(QryRootNodeDTO qryRootNodeDto) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder();
		wherePartBuilder.append("SRVORCA.EU_HPSRVTP = '3'");
		IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
		String wherePart = qrySQLGeneratorService.getQueryStringWithoutDesc(qryRootNodeDto);
		if (!StringUtils.isEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}
		return wherePartBuilder.toString();
	}
}
