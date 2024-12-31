package iih.bd.mm.materialnames.s.bp.findbp;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.mm.materialnames.d.MaterialNamesDO;
import iih.bd.mm.materialnames.s.bp.creater.MaterialNamesDOCreater;
import iih.bd.mm.materialnames.s.bp.creater.PagingRtnDataCreater;
import iih.bd.mm.materialnames.s.bp.queryer.MedSrvQueryer;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.d.desc.MedSrvDODesc;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 根据查询方案分页查询药品通用名列表业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindMaterialNamesByQCondAndPageInfoBp {

	public PagingRtnData<MaterialNamesDO> exec(QryRootNodeDTO qryRootNodeDTO, String orderStr, PaginationInfo pg)
			throws BizException {
		PagingRtnData<MedSrvDO> medSrvPagingRtnData = findMedSrvByQCondAndPageInfo(qryRootNodeDTO, orderStr, pg);
		MedSrvDO[] pageData = MedSrvQueryer.getPageData(medSrvPagingRtnData);
		MedSrvDrugDO[] medSrvDrugDOs = MedSrvQueryer.findMedSrvDrugByIds(pageData);
		MaterialNamesDO[] materialNameDOs = MaterialNamesDOCreater.createMaterialNamesDOs(pageData, medSrvDrugDOs);
		PagingRtnData<MaterialNamesDO> pagingRtnData = PagingRtnDataCreater.CreatePagingRtnData(medSrvPagingRtnData,
				materialNameDOs);
		return pagingRtnData;
	}

	/**
	 * 根据查询方案分页查询医疗服务主信息
	 * 
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<MedSrvDO> findMedSrvByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException {
		String wherePart = GetWherePart(qryRootNodeDTO);
		PagingRtnData<MedSrvDO> pagingRtnData = GetPaginRtnData(pg, wherePart, orderStr);
		return pagingRtnData;
	}

	/**
	 * 构建条件语句
	 * 
	 * @param qryRootNodeDTO
	 * @return
	 * @throws BizException
	 */
	private String GetWherePart(QryRootNodeDTO qryRootNodeDTO) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder();

		String wherePart = String.format("id_srvca in (select id_srvca from bd_srvca where sd_srvtp like '%s%%')",
				IBdSrvDictCodeConst.SD_SRVTP_DRUG);
		wherePartBuilder.append(wherePart);

		wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDTO, MedSrvDODesc.CLASS_FULLNAME);
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(wherePart);
		}
		return wherePartBuilder.toString();
	}

	/**
	 * 查询分页数据
	 * 
	 * @param pg
	 * @param wherePart
	 * @param orderStr
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<MedSrvDO> GetPaginRtnData(PaginationInfo pg, String wherePart, String orderStr)
			throws BizException {
		PaginationInfo paginationInfo = (PaginationInfo) pg.clone();
		IMedsrvMDORService medsrvMDORService = ServiceFinder.find(IMedsrvMDORService.class);
		PagingRtnData<MedSrvDO> pagingRtnData = medsrvMDORService.findByPageInfo(paginationInfo, wherePart, orderStr);
		return pagingRtnData;
	}
}
