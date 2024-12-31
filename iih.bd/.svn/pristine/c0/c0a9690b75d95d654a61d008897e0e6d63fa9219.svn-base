package iih.bd.pp.anhuiinsur.s;

import iih.bd.pp.anhuiinsur.d.BdHpZlOrginalDO;
import iih.bd.pp.anhuiinsur.i.IBdHpZlOrginalExtCudService;
import iih.bd.pp.anhuiinsur.i.IBdHpZlOrginalExtRService;
import iih.bd.pp.anhuiinsur.s.bp.DeleteAllZlOrginalBp;
import iih.bd.pp.anhuiinsur.s.bp.FindTreatPagingByHpIdAndQCondBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 安徽东软医保诊疗目录扩展服务
 * 
 * @author hao_wu
 *
 */
public class BdHpZlOrginalExtCrudServiceImpl implements IBdHpZlOrginalExtCudService, IBdHpZlOrginalExtRService {

	@Override
	public void DeleteAllZlOrginal() throws BizException {
		DeleteAllZlOrginalBp bp = new DeleteAllZlOrginalBp();
		bp.exec();
	}

	@Override
	public PagingRtnData<BdHpZlOrginalDO> findPagingByHpIdAndQCond(String hpId, QryRootNodeDTO qryRootNodeDTO,
			String orderStr, PaginationInfo pg) throws BizException {
		FindTreatPagingByHpIdAndQCondBp bp = new FindTreatPagingByHpIdAndQCondBp();
		PagingRtnData<BdHpZlOrginalDO> result = bp.exec(hpId, qryRootNodeDTO, orderStr, pg);
		return result;
	}
}
