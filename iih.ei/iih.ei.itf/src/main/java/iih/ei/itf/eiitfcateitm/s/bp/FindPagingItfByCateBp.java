package iih.ei.itf.eiitfcateitm.s.bp;

import iih.bd.base.utils.SqlUtils;
import iih.ei.itf.eiitfcateitm.d.ItfCateItmDTO;
import iih.ei.itf.eiitfcateitm.s.bp.qry.FindItfCateItmQry;
import iih.ei.itf.eiitfdo.d.desc.EiItfDODesc;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 根据分类查询接口分页数据
 * 
 * @author hao_wu 2019-10-23
 *
 */
public class FindPagingItfByCateBp {

	public PagingRtnData<ItfCateItmDTO> exec(String itfCateId, QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException {

		String wherePart = buildWherePart(qryRootNodeDTO);

		FindItfCateItmQry qry = new FindItfCateItmQry(itfCateId, wherePart, orderStr);

		PagingServiceImpl<ItfCateItmDTO> pagingService = new PagingServiceImpl<>();
		PagingRtnData<ItfCateItmDTO> result = pagingService.findByPageInfo(new ItfCateItmDTO(), pg, qry.getQrySQLStr(),
				null, qry.getQryParameter(null));
		return result;
	}

	private String buildWherePart(QryRootNodeDTO qryRootNodeDTO) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		if (qryRootNodeDTO != null) {
			String wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDTO);
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}
		return wherePartBuilder.toString();
	}
}
