package iih.bd.pp.baseprisrv.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.baseprisrv.d.PriSrvDO;
import iih.bd.srv.srvcate.d.SrvCateDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 根据服务分类和查询方案查询基础价表服务分页数据
 * 
 * @author hao_wu 2019-8-19
 *
 */
public class FindPagingByCaAndQryNodeBp {

	public PagingRtnData<PriSrvDO> exec(SrvCateDO srvCateDo, QryRootNodeDTO qryRootNodeDto, String whereStr,
			String orderStr, PaginationInfo pg) throws BizException {
		String wherePart = getWherePart(srvCateDo, whereStr);

		FindPagingPriSrvByQryNodeBp bp = new FindPagingPriSrvByQryNodeBp();
		PagingRtnData<PriSrvDO> result = bp.exec(pg, qryRootNodeDto, wherePart, orderStr);
		return result;
	}

	/**
	 * 构建条件语句
	 * 
	 * @param srvCateDo
	 * @param qryRootNodeDto
	 * @param whereStr
	 * @return
	 * @throws BizException
	 */
	private String getWherePart(SrvCateDO srvCateDo, String whereStr) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		if (srvCateDo != null) {
			String wherePart = String.format(
					" and bd_srv.id_srvca in (select id_srvca from bd_srvca where innercode like '%s%%')",
					srvCateDo.getInnercode());
			wherePartBuilder.append(wherePart);
		}

		if (StringUtils.isNotBlank(whereStr)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(whereStr);
		}

		return wherePartBuilder.toString();
	}

}
