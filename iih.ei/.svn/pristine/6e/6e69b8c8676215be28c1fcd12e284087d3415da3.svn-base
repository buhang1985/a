package iih.ei.itf.eiitfcateitm.s.bp;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.DoUtils;
import iih.bd.base.utils.SqlUtils;
import iih.ei.itf.eiitfcateitm.d.ItfCateItmDO;
import iih.ei.itf.eiitfcateitm.i.IEiitfcateitmRService;
import iih.ei.itf.eiitfdo.d.EiItfDO;
import iih.ei.itf.eiitfdo.d.desc.EiItfDODesc;
import iih.ei.itf.eiitfdo.i.IEiitfdoRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public class FindPagingItfExcludeCateBp {

	public PagingRtnData<EiItfDO> exec(String itfCateId, QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException {
		String wherePart = buildWherePart(itfCateId, qryRootNodeDTO);

		IEiitfdoRService itfRService = ServiceFinder.find(IEiitfdoRService.class);
		PagingRtnData<EiItfDO> result = itfRService.findByPageInfo(pg, wherePart, orderStr);
		return result;
	}

	private String buildWherePart(String itfCateId, QryRootNodeDTO qryRootNodeDTO) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		if (StringUtils.isNotBlank(itfCateId)) {
			IEiitfcateitmRService iEiitfcateitmRService = ServiceFinder.find(IEiitfcateitmRService.class);
			ItfCateItmDO[] itms = iEiitfcateitmRService.findByAttrValString(ItfCateItmDO.ID_ITFCATE, itfCateId);
			if (ArrayUtils.isNotEmpty(itms)) {
				String[] itfIds = DoUtils.getAttrValArr(itms, ItfCateItmDO.ID_ITF, String.class);
				if (ArrayUtils.isNotEmpty(itfIds)) {
					String wherePart = SqlUtils.getNotInSqlByIds(EiItfDO.ID_ITF, itfIds);
					wherePartBuilder.append(" AND ");
					wherePartBuilder.append(wherePart);
				}
			}
		}

		if (qryRootNodeDTO != null) {
			String wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDTO, EiItfDODesc.CLASS_FULLNAME);
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}
		return wherePartBuilder.toString();
	}

}
