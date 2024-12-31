package iih.bd.pp.anhuisrvorca.s.bp;

import iih.bd.pp.anhuisrvorca.s.bp.sql.FindAnhuiInsurSrvOrCaByQCondAndPageInfoBpSql;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 使用查询方案分页查询安徽医保目录对照业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindAnhuiInsurSrvOrCaByQCondAndPageInfoBp {

	public PagingRtnData<HPSrvorcaDO> exec(QryRootNodeDTO qryRootNodeDTO, String hpCode, PaginationInfo pg)
			throws BizException {
		String wherePart = GetWherePart(qryRootNodeDTO);
		PagingRtnData<HPSrvorcaDO> pRtnData = GetPagingRtnData(pg, hpCode, wherePart);
		return pRtnData;
	}

	/**
	 * 查询分页数据
	 * 
	 * @param pg
	 * @param wherePart
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<HPSrvorcaDO> GetPagingRtnData(PaginationInfo pg, String hpCode, String wherePart)
			throws BizException {
		String hpId = GetHpId(hpCode);
		FindAnhuiInsurSrvOrCaByQCondAndPageInfoBpSql sql = new FindAnhuiInsurSrvOrCaByQCondAndPageInfoBpSql(hpId,
				wherePart);
		PagingServiceImpl<HPSrvorcaDO> pagingServiceImpl = new PagingServiceImpl<HPSrvorcaDO>();
		PagingRtnData<HPSrvorcaDO> pRtnData = pagingServiceImpl.findByPageInfo(new HPSrvorcaDO(), pg,
				sql.getQrySQLStr(), null, sql.getQryParameter(null));
		// PagingRtnData<HPSrvorcaDO> pRtnData =
		// pagingServiceImpl.findByWhereAndPageInfo(new HPSrvorcaDO(), pg,
		// sql.getQrySQLStr(), null);
		return pRtnData;
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
	 * 获取条件语句
	 * 
	 * @param qryRootNodeDTO
	 * @return
	 * @throws BizException
	 */
	private String GetWherePart(QryRootNodeDTO qryRootNodeDTO) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		if (qryRootNodeDTO != null) {
			IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
			String wherePart = qrySQLGeneratorService.getQueryStringWithDesc(qryRootNodeDTO,
					new HPSrvorcaDO().getDODesc());
			wherePartBuilder.append(String.format(" AND %s", wherePart));
		}
		return wherePartBuilder.toString();
	}

}
