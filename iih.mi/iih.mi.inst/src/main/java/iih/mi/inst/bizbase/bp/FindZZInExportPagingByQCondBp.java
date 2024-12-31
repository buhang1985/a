package iih.mi.inst.bizbase.bp;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.exportdrugsrvdto.d.ExportDrugSrvDTO;
import iih.bd.pp.hpsrvorca.d.desc.HPSrvorcaDODesc;
import iih.mi.biz.dto.d.MiSrvTp;
import iih.mi.inst.bizbase.bp.sql.FindZZInExportDrugPagingByQCondSql;
import iih.mi.inst.bizbase.bp.sql.FindZZInExportTreatPagingByQCondSql;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * @author dj.zhang
 *
 */
public class FindZZInExportPagingByQCondBp {

	/**
	 * 业务执行
	 * 
	 * @param hpId
	 * @param qryRootNodeDto
	 * @param orderStr
	 * @param pg
	 * @param miSrvTp
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<ExportDrugSrvDTO> exec(String hpId, QryRootNodeDTO qryRootNodeDto, String orderStr,
			PaginationInfo pg, String miSrvTp) throws BizException {
		PagingRtnData<ExportDrugSrvDTO> result = findPagingByQCond(hpId, qryRootNodeDto, orderStr, pg, miSrvTp);
		return result;
	}

	/**
	 * 根据类型调用不同服务
	 * 
	 * @param hpId
	 * @param qryRootNodeDto
	 * @param orderStr
	 * @param pg
	 * @param sign
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<ExportDrugSrvDTO> findPagingByQCond(String hpId, QryRootNodeDTO qryRootNodeDto,
			String orderStr, PaginationInfo pg, String miSrvTp) throws BizException {
		String wherePart = getWherePart(qryRootNodeDto);
		PagingServiceImpl<ExportDrugSrvDTO> pagingServiceImpl = new PagingServiceImpl<ExportDrugSrvDTO>();

		if (miSrvTp.equals(String.valueOf(MiSrvTp.DRUG))) {
			FindZZInExportDrugPagingByQCondSql sql = new FindZZInExportDrugPagingByQCondSql(hpId, miSrvTp, wherePart);
			PagingRtnData<ExportDrugSrvDTO> pagingRtnData = pagingServiceImpl.findByPageInfo(new ExportDrugSrvDTO(), pg,
					sql.getQrySQLStr(), "BDMM." + orderStr, sql.getQryParameter(null));
			return pagingRtnData;
		} else {
			FindZZInExportTreatPagingByQCondSql sql = new FindZZInExportTreatPagingByQCondSql(hpId, miSrvTp,
					wherePart);
			PagingRtnData<ExportDrugSrvDTO> pagingRtnData = pagingServiceImpl.findByPageInfo(new ExportDrugSrvDTO(), pg,
					sql.getQrySQLStr(), "BDSRV." + orderStr, sql.getQryParameter(null));
			return pagingRtnData;
		}

	}

	/**
	 * 条件语句
	 * 
	 * @param qryRootNodeDto
	 * @return
	 * @throws BizException
	 */
	private String getWherePart(QryRootNodeDTO qryRootNodeDto) throws BizException {
		String wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDto, HPSrvorcaDODesc.CLASS_FULLNAME);
		return wherePart;
	}

}
