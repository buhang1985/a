package iih.bd.pp.srvmpayratio.s;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.srvmpayratio.d.SrvMPayRatioDO;
import iih.bd.pp.srvmpayratio.i.ISrvMPayRatioExtCudService;
import iih.bd.pp.srvmpayratio.i.ISrvMPayRatioExtRService;
import iih.bd.pp.srvmpayratio.s.bp.FindPagingByQCondAndHpBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保项目多支付比例扩展服务
 * 
 * @author hao_wu
 *
 */
public class SrvMPayRatioExtCrudServiceImpl implements ISrvMPayRatioExtCudService, ISrvMPayRatioExtRService {

	@Override
	public PagingRtnData<SrvMPayRatioDO> FindPagingByQCondAndHp(HPDO hpdo, QryRootNodeDTO qryRootNodeDto,
			PaginationInfo pg) throws BizException {
		FindPagingByQCondAndHpBp bp = new FindPagingByQCondAndHpBp();
		PagingRtnData<SrvMPayRatioDO> result = bp.exec(hpdo, qryRootNodeDto, pg);
		return result;
	}

}
