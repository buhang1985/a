package iih.bd.pp.prilistqry.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.dto.d.PricelistqrySrvDTO;
import iih.bd.pp.prilistqry.s.bp.sql.FindPriListSql;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 根据查询方案查询价表分页数据
 * 
 * @author hao_wu
 *
 */
public class FindPagingByQcondBp {

	public PagingRtnData<PricelistqrySrvDTO> exec(QryRootNodeDTO qryRootNodeDTO, String orderPart, PaginationInfo pg)
			throws BizException {

		String wherePart = GetWherePart(qryRootNodeDTO);
		PagingRtnData<PricelistqrySrvDTO> result = FindPagingByWherePart(wherePart, orderPart, pg);
		return result;
	}

	/**
	 * 获取条件语句
	 * 
	 * @param qryRootNodeDTO
	 * @return
	 * @throws BizException
	 */
	private String GetWherePart(QryRootNodeDTO qryRootNodeDTO) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		String wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDTO);
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(wherePart);
		}
		return wherePartBuilder.toString();
	}

	/**
	 * 根据查询条件和排序条件查询分页数据
	 * 
	 * @param wherePart
	 * @param orderPart
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<PricelistqrySrvDTO> FindPagingByWherePart(String wherePart, String orderPart,
			PaginationInfo pg) throws BizException {

		FindPriListSql sql = new FindPriListSql(wherePart);

		PagingServiceImpl<PricelistqrySrvDTO> pagingServiceImpl = new PagingServiceImpl<PricelistqrySrvDTO>();
		PagingRtnData<PricelistqrySrvDTO> result = pagingServiceImpl.findByPageInfo(new PricelistqrySrvDTO(), pg,
				sql.getQrySQLStr(), orderPart, sql.getQryParameter(null));
		return result;
	}

}
