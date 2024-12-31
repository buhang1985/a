package iih.bd.mhi.hpdrugdircomp.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.mhi.hpdrugdircomp.d.HpDrugDirCompDTO;
import iih.bd.mhi.hpdrugdircomp.s.bp.sql.FindHpDrugDirCompSql;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
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
 * @author hexx
 */
public class FindHpDrugDirCompBp {

	/**
	 * 业务执行
	 * 
	 * @param qryRootNodeDto
	 * @param hpId
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<HpDrugDirCompDTO> exec(QryRootNodeDTO qryRootNodeDto, String hpId, PaginationInfo pg)
			throws BizException {
		String wherePart = GetWherePart(qryRootNodeDto);
		String idRef = getIdRef(hpId);
		FindHpDrugDirCompSql sql = new FindHpDrugDirCompSql(idRef, hpId, wherePart);
		PagingServiceImpl<HpDrugDirCompDTO> pagingServiceImpl = new PagingServiceImpl<HpDrugDirCompDTO>();
		PagingRtnData<HpDrugDirCompDTO> pagingRtnData = pagingServiceImpl.findByPageInfo(new HpDrugDirCompDTO(), pg,
				sql.getQrySQLStr(), "EU_STATUS DESC,BD_MM.CODE", sql.getQryParameter(null));
		return pagingRtnData;
	}

	/**
	 * @param hpId
	 * @return
	 * @throws BizException
	 */
	private String getIdRef(String hpId) throws BizException {
		IHpMDORService iHpMDORService = ServiceFinder.find(IHpMDORService.class);
		HPDO hpdo = iHpMDORService.findById(hpId);
		return hpdo.getId_refhp();
	}

	/**
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
