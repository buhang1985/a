package iih.bd.pp.hp.s;

import iih.bd.pp.hp.d.BdHpUnlimitDrugDO;
import iih.bd.pp.hp.i.IBdHpUnlimitDrugDoExtService;
import iih.bd.pp.hp.s.bp.FindUnLimitDrugByPageInfoBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

public class BdHpUnlimitDrugDoExtServiceImpl implements IBdHpUnlimitDrugDoExtService {

	@Override
	public PagingRtnData<BdHpUnlimitDrugDO> findByPageInfo(PaginationInfo pg, String wherePart, String orderByPart)
			throws BizException {
		FindUnLimitDrugByPageInfoBp findUnLimitDrugByPageInfoBp = new FindUnLimitDrugByPageInfoBp();
		return findUnLimitDrugByPageInfoBp.exec(pg, wherePart, orderByPart);
	}

}
