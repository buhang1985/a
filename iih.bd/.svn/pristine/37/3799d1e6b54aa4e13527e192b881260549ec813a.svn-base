package iih.bd.mhi.hpstaffinfo.s;

import iih.bd.mhi.hpstaffinfo.d.HpStaffInfoDO;
import iih.bd.mhi.hpstaffinfo.i.IHpstaffinfoExtCudService;
import iih.bd.mhi.hpstaffinfo.i.IHpstaffinfoExtRService;
import iih.bd.mhi.hpstaffinfo.s.bp.FindPagingByQCondAndHpBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保计划医院操作员信息上报扩展服务
 * 
 * @author gaoxn
 *
 */
public class HpstaffinfoExtCrudServiceImpl implements IHpstaffinfoExtRService, IHpstaffinfoExtCudService {

	@Override
	public PagingRtnData<HpStaffInfoDO> findPagingByQCondAndHp(QryRootNodeDTO qryRootNodeDTO, String hpId,
			String orderStr, PaginationInfo pg) throws BizException {
		FindPagingByQCondAndHpBp bp = new FindPagingByQCondAndHpBp();
		PagingRtnData<HpStaffInfoDO> result = bp.exec(qryRootNodeDTO, hpId, orderStr, pg);
		return result;
	}

}
