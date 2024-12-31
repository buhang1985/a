package iih.bl.inc.s;

import iih.bl.inc.dto.blelecbillcheckdto.d.BlecIncCheckDTO;
import iih.bl.inc.dto.blelecbillcheckdto.d.CheckTotalDataDTO;
import iih.bl.inc.i.IBlEcIncQryService;
import iih.bl.inc.s.bp.CheckElecBillBP;
import iih.bl.inc.s.bp.CheckIihAndPlatInfoBP;
import iih.bl.inc.s.bp.CheckPlatAndIihSumBP;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 电子票据查询服务
 * @author jdk 2020/01/15
 *
 */
public class BlEcIncQryServiceImpl implements IBlEcIncQryService {
	
	/**
	 * 总票数和总金额查询
	 */
	@Override
	public CheckTotalDataDTO checkPlatAndIihSum(QryRootNodeDTO qry) throws BizException {
		CheckPlatAndIihSumBP bp = new CheckPlatAndIihSumBP();
		return bp.exec(qry);
	}

	/**
	 * 正常数据根据查询方案展示
	 * @param qry
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<BlecIncCheckDTO> qryNormalDatas(QryRootNodeDTO qry, PaginationInfo pg) throws BizException {
		CheckIihAndPlatInfoBP bp = new CheckIihAndPlatInfoBP();
		return bp.exec(qry, pg, CheckElecBillBP.SD_NORMAL);
	}

	/**
	 * 异常数据根据查询方案展示
	 * @param qry
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<BlecIncCheckDTO> qryAbnormalDatas(QryRootNodeDTO qry, PaginationInfo pg) throws BizException {
		CheckIihAndPlatInfoBP bp = new CheckIihAndPlatInfoBP();
		return bp.exec(qry, pg, CheckElecBillBP.SD_ABNORMAL);
	}
	
	
	
}
