package iih.bd.mhi.hpopepermapply.s;

import iih.bd.mhi.hpopepermapply.d.HpOpePermApplyDO;
import iih.bd.mhi.hpopepermapply.i.IHpOpePermApplyExtCudService;
import iih.bd.mhi.hpopepermapply.i.IHpOpePermApplyExtRService;
import iih.bd.mhi.hpopepermapply.s.bp.FindPagingByQCondAndHpBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保产品操作员权限扩展服务
 * 
 * @author gaoxn
 *
 */
public class HpOpePermApplyExtCrudServiceImpl implements IHpOpePermApplyExtRService, IHpOpePermApplyExtCudService {

	@Override
	public PagingRtnData<HpOpePermApplyDO> findPagingByQCondAndHp(QryRootNodeDTO qryRootNodeDTO, String hpId,
			String orderStr, PaginationInfo pg) throws BizException {
		FindPagingByQCondAndHpBp bp = new FindPagingByQCondAndHpBp();
		PagingRtnData<HpOpePermApplyDO> result = bp.exec(qryRootNodeDTO, hpId, orderStr, pg);
		return result;
	}

}
