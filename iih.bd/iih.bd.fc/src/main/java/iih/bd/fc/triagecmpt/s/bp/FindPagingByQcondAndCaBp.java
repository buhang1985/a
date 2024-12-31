package iih.bd.fc.triagecmpt.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.fc.triageca.d.TriageCaDO;
import iih.bd.fc.triagecmpt.d.TriageCmptDO;
import iih.bd.fc.triagecmpt.d.desc.TriageCmptDODesc;
import iih.bd.fc.triagecmpt.i.ITriagecmptRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 
 * 使用检伤分类和查询方案查询检伤主诉分页数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindPagingByQcondAndCaBp {

	public PagingRtnData<TriageCmptDO> exec(TriageCaDO triageCa, QryRootNodeDTO qryRootNodeDto, String orderPart,
			PaginationInfo pg) throws BizException {
		String wherePart = BuildWherePart(triageCa, qryRootNodeDto);
		PagingRtnData<TriageCmptDO> result = FindPagingByWherePart(wherePart, orderPart, pg);
		return result;
	}

	private String BuildWherePart(TriageCaDO triageCa, QryRootNodeDTO qryRootNodeDto) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		String wherePart;
		if (triageCa != null) {
			wherePart = String.format(" and Id_triageca = '%s'", triageCa.getId_triageca());
			wherePartBuilder.append(wherePart);
		}

		wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDto, TriageCmptDODesc.CLASS_FULLNAME);
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(wherePart);
		}
		return wherePartBuilder.toString();
	}

	/**
	 * 使用条件语句查询分页数据
	 * 
	 * @param wherePart
	 *            条件语句
	 * @param orderPart
	 *            排序语句
	 * @param pg
	 *            分页信息
	 * @return 分页数据
	 * @throws BizException
	 */
	private PagingRtnData<TriageCmptDO> FindPagingByWherePart(String wherePart, String orderPart, PaginationInfo pg)
			throws BizException {
		ITriagecmptRService triagecmptRService = ServiceFinder.find(ITriagecmptRService.class);
		PagingRtnData<TriageCmptDO> result = triagecmptRService.findByPageInfo(pg, wherePart, orderPart);
		return result;
	}

}
