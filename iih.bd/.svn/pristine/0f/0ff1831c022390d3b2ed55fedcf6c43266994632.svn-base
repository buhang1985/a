package iih.bd.pp.service.s.bp;

import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import iih.bd.pp.hpsrvorca.i.IHpsrvorcaRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 根据查询方案查询医保目录对照分页信息
 * 
 * @author hao_wu
 *
 */
public class FindPagingByQCondBp {

	public PagingRtnData<HPSrvorcaDO> exec(QryRootNodeDTO qryRootNodeDTO, String orderStr, PaginationInfo pg)
			throws BizException {
		PagingRtnData<HPSrvorcaDO> result = FindPagingByQCond(qryRootNodeDTO, orderStr, pg);
		SetHisInfo(result);
		return result;
	}

	/**
	 * 
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<HPSrvorcaDO> FindPagingByQCond(QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException {
		IHpsrvorcaRService hpsrvorcaRService = ServiceFinder.find(IHpsrvorcaRService.class);
		PagingRtnData<HPSrvorcaDO> result = hpsrvorcaRService.findByQCondAndPageInfo(qryRootNodeDTO, orderStr, pg);
		return result;
	}

	/**
	 * 设置HIS信息
	 * 
	 * @param result
	 */
	private void SetHisInfo(PagingRtnData<HPSrvorcaDO> result) {
		if (result == null || result.getPageData() == null || result.getPageData().size() <= 0) {
			return;
		}

		FArrayList pageDataList = result.getPageData();
		for (Object object : pageDataList) {
			if (object instanceof HPSrvorcaDO) {
				SetHisInfo((HPSrvorcaDO) object);
			}
		}
	}

	/**
	 * 设置HIS信息
	 * 
	 * @param hpSrvorcaDO
	 */
	private void SetHisInfo(HPSrvorcaDO hpSrvorcaDO) {
		Integer hpSrvTp = hpSrvorcaDO.getEu_hpsrvtp();
		if (HpSrvTpEnum.DRUG.equals(hpSrvTp)) {
			hpSrvorcaDO.setHis_code(hpSrvorcaDO.getMm_code());
			hpSrvorcaDO.setHis_name(hpSrvorcaDO.getSrv_name());
		} else {
			hpSrvorcaDO.setHis_code(hpSrvorcaDO.getSrv_code());
			hpSrvorcaDO.setHis_name(hpSrvorcaDO.getSrv_name());
		}
	}
}
