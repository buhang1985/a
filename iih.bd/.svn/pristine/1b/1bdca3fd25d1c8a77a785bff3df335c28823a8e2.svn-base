package iih.bd.pp.anhuiinsur.s;

import iih.bd.pp.anhuiinsur.d.BdHpFwssOrginalDO;
import iih.bd.pp.anhuiinsur.i.IBdHpFwssOrginalExtCudService;
import iih.bd.pp.anhuiinsur.i.IBdHpFwssOrginalExtRService;
import iih.bd.pp.anhuiinsur.s.bp.DeleteAllFwssOrginal;
import iih.bd.pp.anhuiinsur.s.bp.FindFwssPagingByHpIdAndQCondBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 安徽东软医保服务设施目录扩展服务
 * 
 * @author hao_wu
 *
 */
public class BdHpFwssOrginalExtCrudServiceImpl implements IBdHpFwssOrginalExtCudService, IBdHpFwssOrginalExtRService {

	@Override
	public void DeleteAllFwssOrginal() throws BizException {
		DeleteAllFwssOrginal bp = new DeleteAllFwssOrginal();
		bp.exec();
	}

	@Override
	public PagingRtnData<BdHpFwssOrginalDO> findFwssPagingByHpIdAndQCond(String hpId, QryRootNodeDTO qryRootNodeDTO,
			String orderStr, PaginationInfo pg) throws BizException {
		FindFwssPagingByHpIdAndQCondBp bp = new FindFwssPagingByHpIdAndQCondBp();
		PagingRtnData<BdHpFwssOrginalDO> result = bp.exec(hpId, qryRootNodeDTO, orderStr, pg);
		return result;
	}
}
