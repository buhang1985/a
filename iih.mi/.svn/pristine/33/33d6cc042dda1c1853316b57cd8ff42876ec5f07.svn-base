package iih.mi.mibd.treatdircomp.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.mi.mibd.treatdircomp.d.TreatDirCompDTO;
import iih.mi.mibd.treatdircomp.s.bp.sql.FindTreatCompSql;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * @author dj.zhang
 *
 */
public class FindTreatCompBp {

	public PagingRtnData<TreatDirCompDTO> exec(QryRootNodeDTO qryRootNodeDto, String misId, PaginationInfo pg)
			throws BizException {

		String wherePart = GetWherePart(qryRootNodeDto);
		FindTreatCompSql sql = new FindTreatCompSql(misId, wherePart);
		PagingServiceImpl<TreatDirCompDTO> pagingServiceImpl = new PagingServiceImpl<TreatDirCompDTO>();
		PagingRtnData<TreatDirCompDTO> pagingRtnData = pagingServiceImpl.findByPageInfo(new TreatDirCompDTO(), pg,
				sql.getQrySQLStr(), "EU_STATUS DESC,CODE", sql.getQryParameter(null));
		return pagingRtnData;
	}

	/**
	 * 查询方案生成条件语句
	 * 
	 * @param qryRootNodeDto
	 * @return
	 * @throws BizException
	 */
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
