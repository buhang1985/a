package iih.bd.mhi.hptreatdircomp.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.mhi.hptreatdircomp.d.HpTreatDirCompDTO;
import iih.bd.mhi.hptreatdircomp.s.bp.sql.FindHpTreatCompSql;
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
 * @author dj.zhang
 *
 */
public class FindHpTreatCompBp {

	/**
	 * @param qryRootNodeDto
	 * @param hpId
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<HpTreatDirCompDTO> exec(QryRootNodeDTO qryRootNodeDto, String hpId, PaginationInfo pg) throws BizException {
		String wherePart = getWherePart(qryRootNodeDto);
		String idRef = getIdRef(hpId);
		FindHpTreatCompSql sql = new FindHpTreatCompSql(idRef, hpId, wherePart);
		PagingServiceImpl<HpTreatDirCompDTO> pagingServiceImpl = new PagingServiceImpl<HpTreatDirCompDTO>();
		PagingRtnData<HpTreatDirCompDTO> pagingRtnData = pagingServiceImpl.findByPageInfo(new HpTreatDirCompDTO(), pg,
				sql.getQrySQLStr(), "EU_STATUS DESC,CODE", sql.getQryParameter(null));
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
	private String getWherePart(QryRootNodeDTO qryRootNodeDto) throws BizException {
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
