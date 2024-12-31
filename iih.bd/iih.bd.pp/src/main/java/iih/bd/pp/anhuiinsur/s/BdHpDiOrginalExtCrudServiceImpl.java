package iih.bd.pp.anhuiinsur.s;

import iih.bd.pp.anhuiinsur.d.BdHpDiOrginalDO;
import iih.bd.pp.anhuiinsur.i.IBdHpDiOrginalExtCudService;
import iih.bd.pp.anhuiinsur.i.IBdHpDiOrginalExtRService;
import iih.bd.pp.anhuiinsur.s.bp.DeleteAllDiOrginalBp;
import iih.bd.pp.anhuiinsur.s.bp.FindDiPagingByHpIdAndQCondBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 安徽东软医保病种目录扩展服务
 * 
 * @author guoyang
 *
 */
public class BdHpDiOrginalExtCrudServiceImpl implements IBdHpDiOrginalExtCudService, IBdHpDiOrginalExtRService {

	@Override
	public void DeleteAllDiOrginal() throws BizException {
		DeleteAllDiOrginalBp bp = new DeleteAllDiOrginalBp();
		bp.exec();
	}

	@Override
	public PagingRtnData<BdHpDiOrginalDO> findDiPagingByHpIdAndQCond(String hpId, QryRootNodeDTO qryRootNodeDTO,
			String orderStr, PaginationInfo pg) throws BizException {
		FindDiPagingByHpIdAndQCondBp bp = new FindDiPagingByHpIdAndQCondBp();
		PagingRtnData<BdHpDiOrginalDO> result = bp.exec(hpId, qryRootNodeDTO, orderStr, pg);
		return result;
	}

}
