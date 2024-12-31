package iih.bd.mm.materialnames.s.bp.creater;

import iih.bd.mm.materialnames.d.MaterialNamesDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.data.FArrayList;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

public class PagingRtnDataCreater {
	/**
	 * 创建分页查询返回信息
	 * 
	 * @param medSrvPagingRtnData
	 * @param materialNameDOs
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static PagingRtnData<MaterialNamesDO> CreatePagingRtnData(PagingRtnData<MedSrvDO> medSrvPagingRtnData,
			MaterialNamesDO[] materialNameDOs) {
		PaginationInfo medsrvPageInfo = medSrvPagingRtnData.getPagingInfo();

		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setPageClient(medsrvPageInfo.getPageClient());
		paginationInfo.setPageCount(medsrvPageInfo.getPageCount());
		paginationInfo.setPageIndex(medsrvPageInfo.getPageIndex());
		paginationInfo.setPageInfo(medsrvPageInfo.getPageInfo());
		paginationInfo.setPageSize(medsrvPageInfo.getPageSize());
		paginationInfo.setRecordsCount(medsrvPageInfo.getRecordsCount());

		FArrayList dataList = new FArrayList();
		for (MaterialNamesDO materialNamesDO : materialNameDOs) {
			dataList.add(materialNamesDO);
		}

		PagingRtnData<MaterialNamesDO> materialNamesPagingRtnData = new PagingRtnData<MaterialNamesDO>();
		materialNamesPagingRtnData.setPagingInfo(paginationInfo);
		materialNamesPagingRtnData.setPageData(dataList);
		return materialNamesPagingRtnData;
	}
}
