package iih.bd.pp.hp.s;

import iih.bd.pp.hp.d.BdHpPatcaDO;
import iih.bd.pp.hp.i.IBdHpPatcaDOExtCudService;
import iih.bd.pp.hp.i.IBdHpPatcaDOExtRService;
import iih.bd.pp.hp.s.bp.FindPagingByHpAndQCondBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保患者身份扩展服务
 * 
 * @author hao_wu
 *
 */
public class BdHpPatcaDOExtCrudServiceImpl implements IBdHpPatcaDOExtCudService, IBdHpPatcaDOExtRService {

	@Override
	public PagingRtnData<BdHpPatcaDO> findPagingByHpAndQCond(String hpId, QryRootNodeDTO qryRootNodeDTO,
			String orderStr, PaginationInfo pg) throws BizException {
		FindPagingByHpAndQCondBp bp = new FindPagingByHpAndQCondBp();
		PagingRtnData<BdHpPatcaDO> result = bp.exec(hpId, qryRootNodeDTO, orderStr, pg);
		return result;
	}
}
