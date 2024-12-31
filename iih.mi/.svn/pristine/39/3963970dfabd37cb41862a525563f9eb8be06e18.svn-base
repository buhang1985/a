package iih.mi.mibd.drugdircomp.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.mi.mibd.drugdircomp.d.DrugDirCompDTO;
import iih.mi.mibd.drugdircomp.s.bp.sql.FindDrugDirCompSql;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 查询药品对照业务逻辑
 *
 *@author hexx
 */
public class FindDrugDirCompBp {
	
	
	/**业务执行
	 * @param qryRootNodeDto
	 * @param misId
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<DrugDirCompDTO> exec(QryRootNodeDTO qryRootNodeDto, String misId, PaginationInfo pg)
			throws BizException {
		String wherePart = GetWherePart(qryRootNodeDto);
		FindDrugDirCompSql sql = new FindDrugDirCompSql(misId, wherePart);
		PagingServiceImpl<DrugDirCompDTO> pagingServiceImpl = new PagingServiceImpl<DrugDirCompDTO>();
		PagingRtnData<DrugDirCompDTO> pagingRtnData = pagingServiceImpl.findByPageInfo(new DrugDirCompDTO(), pg,
				sql.getQrySQLStr(), "EU_STATUS DESC,BD_MM.CODE", sql.getQryParameter(null));
		return pagingRtnData;
	}
	
	private String GetWherePart(QryRootNodeDTO qryRootNodeDto) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
		String wherePart = qrySQLGeneratorService.getQueryStringWithoutDesc(qryRootNodeDto);
		if (!StringUtils.isEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}
		return wherePartBuilder.toString();
	}
}
