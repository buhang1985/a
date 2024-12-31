package iih.bd.bs.ctmitfrel.s;

import iih.bd.bs.ctmitfrel.d.CtmItfRelDO;
import iih.bd.bs.ctmitfrel.i.ICtmItfImplRelExtCudService;
import iih.bd.bs.ctmitfrel.i.ICtmItfImplRelExtRService;
import iih.bd.bs.ctmitfrel.s.bp.FindRelPagingByQCondBp;
import iih.bd.bs.ctmitfrel.s.bp.SaveCtmItfImplRelBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 客开接口与实现类关系扩展服务
 * 
 * @author hao_wu 2019-6-14
 *
 */
public class CtmItfImplRelExtCrudServiceImpl implements ICtmItfImplRelExtCudService, ICtmItfImplRelExtRService {

	@Override
	public PagingRtnData<CtmItfRelDO> findRelPagingByQCond(QryRootNodeDTO qryRootNodeDto, String orderPart,
			String wherePart, PaginationInfo pg) throws BizException {
		FindRelPagingByQCondBp bp = new FindRelPagingByQCondBp();
		PagingRtnData<CtmItfRelDO> pagingData = bp.exec(qryRootNodeDto, orderPart, wherePart, pg);
		return pagingData;
	}

	@Override
	public CtmItfRelDO[] saveCtmItfImplRel(CtmItfRelDO[] ctmItfRelDOs) throws BizException {
		SaveCtmItfImplRelBp bp = new SaveCtmItfImplRelBp();
		CtmItfRelDO[] result = bp.exec(ctmItfRelDOs);
		return result;
	}
}
