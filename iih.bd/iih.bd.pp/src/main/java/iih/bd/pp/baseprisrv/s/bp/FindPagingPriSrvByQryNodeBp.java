package iih.bd.pp.baseprisrv.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.baseprisrv.d.PriSrvDO;
import iih.bd.pp.baseprisrv.s.bp.qry.FindPriSrvQry;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 根据查询方案查询分页数据
 * 
 * @author hao_wu 2019-8-19
 *
 */
public class FindPagingPriSrvByQryNodeBp {

	public PagingRtnData<PriSrvDO> exec(PaginationInfo pg, QryRootNodeDTO qryRootNodeDto, String wherePart,
			String orderStr) throws BizException {
		String whereStr = getWhereStr(qryRootNodeDto, wherePart);

		FindPriSrvQry qry = new FindPriSrvQry(whereStr, null, orderStr);

		PagingServiceImpl<PriSrvDO> pagingService = new PagingServiceImpl<PriSrvDO>();
		PagingRtnData<PriSrvDO> pagingData = pagingService.findByPageInfo(new PriSrvDO(), pg, qry.getQrySQLStr(), null,
				qry.getQryParameter(null));

		setChargeBasis(pagingData.getPageData());

		return pagingData;
	}

	/**
	 * 设置收费依据
	 * 
	 * @param priSrvDoList
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void setChargeBasis(FArrayList priSrvDoList) throws BizException {
		SetChargeBasisBp bp = new SetChargeBasisBp();
		bp.exec((PriSrvDO[]) priSrvDoList.toArray(new PriSrvDO[0]));
	}

	/**
	 * 构建条件语句
	 * 
	 * @param qryRootNodeDto
	 * @param wherePart
	 * @return
	 * @throws BizException
	 */
	private String getWhereStr(QryRootNodeDTO qryRootNodeDto, String wherePart) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		if (qryRootNodeDto != null) {
			String whereStr = SqlUtils.getWherePartByQCond(qryRootNodeDto);
			if (StringUtils.isNotBlank(whereStr)) {
				wherePartBuilder.append(" AND ");
				wherePartBuilder.append(whereStr);
			}
		}

		if (StringUtils.isNotBlank(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}
		return wherePartBuilder.toString();
	}

}
