package iih.bd.mhi.hpentpcomp.s;

import iih.bd.mhi.dto.d.HpEnTpCompDTO;
import iih.bd.mhi.hpentpcomp.i.IHpentpcompExtCudService;
import iih.bd.mhi.hpentpcomp.i.IHpentpcompExtRService;
import iih.bd.mhi.hpentpcomp.s.bp.FindEntpCompPagingByHpIdAndWherePartBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * 医保产品就诊类型对照扩展服务
 * 
 * @author hao_wu
 *
 */
public class HpentpcompExtCrudServiceImpl implements IHpentpcompExtCudService, IHpentpcompExtRService {

	@Override
	public PagingRtnData<HpEnTpCompDTO> findEntpCompPagingByHpIdAndWherePart(String hpId, String wherePart,
			String orderStr, PaginationInfo pg) throws BizException {
		FindEntpCompPagingByHpIdAndWherePartBp bp = new FindEntpCompPagingByHpIdAndWherePartBp();
		PagingRtnData<HpEnTpCompDTO> result = bp.exec(hpId, wherePart, orderStr, pg);
		return result;
	}

}
