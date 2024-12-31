package iih.bd.pp.anhuisrvorca.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.anhuisrvorca.d.FwssCompDTO;
import iih.bd.pp.anhuisrvorca.s.bp.sql.FindFwssCompSql;
import iih.bd.pp.hp.d.HPDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 服务设施对照信息查询业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindFwssCompBp {

	public PagingRtnData<FwssCompDTO> exec(QryRootNodeDTO qryRootNodeDto, String hpCode, PaginationInfo pg)
			throws BizException {
		String hpId = GetHpId(hpCode);

		String wherePart = GetWherePart(qryRootNodeDto);

		FindFwssCompSql sql = new FindFwssCompSql(hpId, wherePart);

		PagingServiceImpl<FwssCompDTO> pagingServiceImpl = new PagingServiceImpl<FwssCompDTO>();
		PagingRtnData<FwssCompDTO> pagingRtnData = pagingServiceImpl.findByPageInfo(new FwssCompDTO(), pg,
				sql.getQrySQLStr(), "SRV.CODE", sql.getQryParameter(null));

		return pagingRtnData;
	}

	/**
	 * 获取医保计划主键
	 * 
	 * @param hpCode
	 * @return
	 * @throws BizException
	 */
	private String GetHpId(String hpCode) throws BizException {
		FindHpDoByCodeBp bp = new FindHpDoByCodeBp();
		HPDO hpdo = bp.exec(hpCode);
		return hpdo.getId_hp();
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
