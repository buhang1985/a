package iih.bd.pp.bdhpspec.s.bp;

import iih.bd.pp.bdhpspec.s.bp.sql.FindMedicalInsurSql;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 使用查询方案查询医保分页信息分页信息</br>
 * 仅用于医保特殊病使用
 * 
 * @author hao_wu
 *
 */
public class FindMedicalInsurPagingDataByQCondBp {

	public PagingRtnData<HPSrvorcaDO> exec(QryRootNodeDTO qryRootNodeDto, PaginationInfo pg) throws BizException {
		String wherePart = GetWherePart(qryRootNodeDto);
		FindMedicalInsurSql sql = new FindMedicalInsurSql(wherePart);
		PagingServiceImpl<HPSrvorcaDO> pagingServiceImpl = new PagingServiceImpl<HPSrvorcaDO>();
		PagingRtnData<HPSrvorcaDO> result = pagingServiceImpl.findByPageInfo(new HPSrvorcaDO(), pg, sql.getQrySQLStr(),
				"CODE", sql.getQryParameter(null));
		return result;
	}

	/**
	 * 使用查询方案生成条件片段
	 * 
	 * @param qryRootNodeDto
	 * @return
	 * @throws BizException
	 */
	private String GetWherePart(QryRootNodeDTO qryRootNodeDto) throws BizException {
		if (qryRootNodeDto == null) {
			return "1 = 1";
		}
		IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
		String wherePart = qrySQLGeneratorService.getQueryStringWithDesc(qryRootNodeDto, new HPSrvorcaDO().getDODesc());
		return wherePart;
	}
}
