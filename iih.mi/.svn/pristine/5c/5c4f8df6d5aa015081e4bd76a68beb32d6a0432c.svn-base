package iih.mi.inst.bizbase.bp;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.desc.HPSrvorcaDODesc;
import iih.mi.biz.dto.d.MiSrvTp;
import iih.mi.inst.bizbase.bp.sql.FindExportDrugPagingByQCondSql;
import iih.mi.inst.bizbase.bp.sql.FindExportTreatPagingByQCondSql;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * @author dj.zhang
 *
 */
public class FindExportPagingByQCondBp {

	public PagingRtnData<HPSrvorcaDO> execu(String id_hp, QryRootNodeDTO qryRootNodeDto, String orderStr,
			PaginationInfo pg, String miSrvTp) throws BizException {
		PagingRtnData<HPSrvorcaDO> result = findPagingByQCondSign(id_hp, qryRootNodeDto, orderStr, pg, miSrvTp);
		setMiInfo(result);
		return result;
	}

	/**
	 * @param id_hp
	 * @param qryRootNodeDto
	 * @param orderStr
	 * @param pg
	 * @param sign
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<HPSrvorcaDO> findPagingByQCondSign(String id_hp, QryRootNodeDTO qryRootNodeDto,
			String orderStr, PaginationInfo pg, String miSrvTp) throws BizException {
		String wherePart = getWherePartSign(qryRootNodeDto);
		PagingServiceImpl<HPSrvorcaDO> pagingServiceImpl = new PagingServiceImpl<HPSrvorcaDO>();

		if (miSrvTp.equals(String.valueOf(MiSrvTp.DRUG))) {
			FindExportDrugPagingByQCondSql sql = new FindExportDrugPagingByQCondSql(id_hp, miSrvTp, wherePart);
			PagingRtnData<HPSrvorcaDO> pagingRtnData = pagingServiceImpl.findByPageInfo(new HPSrvorcaDO(), pg,
					sql.getQrySQLStr(), "BDSRVORCA." + orderStr, sql.getQryParameter(null));
			return pagingRtnData;
		} else {
			FindExportTreatPagingByQCondSql sql = new FindExportTreatPagingByQCondSql(id_hp, miSrvTp, wherePart);
			PagingRtnData<HPSrvorcaDO> pagingRtnData = pagingServiceImpl.findByPageInfo(new HPSrvorcaDO(), pg,
					sql.getQrySQLStr(), "BDSRVORCA." + orderStr, sql.getQryParameter(null));
			return pagingRtnData;
		}

	}

	/**
	 * @param qryRootNodeDto
	 * @return
	 * @throws BizException
	 */
	private String getWherePartSign(QryRootNodeDTO qryRootNodeDto) throws BizException {
		String wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDto, HPSrvorcaDODesc.CLASS_FULLNAME);
		return wherePart;
	}

	/**
	 * 设置HIS信息
	 * 
	 * @param result
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void setMiInfo(PagingRtnData<HPSrvorcaDO> result) throws BizException {
		SetMiInfoBp bp = new SetMiInfoBp();
		bp.exec((HPSrvorcaDO[]) result.getPageData().toArray(new HPSrvorcaDO[0]));
	}

}
