package iih.bd.mm.materialnames.s.bp.findbp;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.mm.materialnames.d.MaterialNamesDO;
import iih.bd.mm.materialnames.s.bp.creater.MaterialNamesDOCreater;
import iih.bd.mm.materialnames.s.bp.creater.PagingRtnDataCreater;
import iih.bd.mm.materialnames.s.bp.queryer.MedSrvQueryer;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * 根据数据管控分页查询药品通用名列表业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindMaterialNamesByPageInfoBp {

	public PagingRtnData<MaterialNamesDO> exec(PaginationInfo pg, String whereStr, String orderStr)
			throws BizException {
		PagingRtnData<MedSrvDO> medSrvPagingRtnData = findMedSrvByPageInfo(pg, whereStr, orderStr);
		MedSrvDO[] pageData = MedSrvQueryer.getPageData(medSrvPagingRtnData);
		MedSrvDrugDO[] medSrvDrugDOs = MedSrvQueryer.findMedSrvDrugByIds(pageData);
		MaterialNamesDO[] materialNameDOs = MaterialNamesDOCreater.createMaterialNamesDOs(pageData, medSrvDrugDOs);
		PagingRtnData<MaterialNamesDO> pagingRtnData = PagingRtnDataCreater.CreatePagingRtnData(medSrvPagingRtnData,
				materialNameDOs);
		return pagingRtnData;
	}

	/**
	 * 根据数据管控分页查询医疗服务主信息
	 * 
	 * @param pg
	 * @param whereStr
	 * @param orderStr
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<MedSrvDO> findMedSrvByPageInfo(PaginationInfo pg, String wherePart, String orderStr)
			throws BizException {
		wherePart = String.format("%s AND id_srvca in (select id_srvca from bd_srvca where sd_srvtp like '%s%%')",
				wherePart, IBdSrvDictCodeConst.SD_SRVTP_DRUG);

		PaginationInfo paginationInfo = (PaginationInfo) pg.clone();
		IMedsrvMDORService medsrvMDORService = ServiceFinder.find(IMedsrvMDORService.class);
		PagingRtnData<MedSrvDO> pagingRtnData = medsrvMDORService.findByPageInfo(paginationInfo, wherePart, orderStr);
		return pagingRtnData;
	}
}
