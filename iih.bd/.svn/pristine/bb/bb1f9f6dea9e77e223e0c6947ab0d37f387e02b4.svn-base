package iih.bd.pp.anhuiinsur.s;

import iih.bd.pp.anhuiinsur.d.BdHpDrugOrginalDO;
import iih.bd.pp.anhuiinsur.i.IBdHpDrugOrginalExtCudService;
import iih.bd.pp.anhuiinsur.i.IBdHpDrugOrginalExtRService;
import iih.bd.pp.anhuiinsur.s.bp.DeleteAllDrugOrginal;
import iih.bd.pp.anhuiinsur.s.bp.FindDrugPagingByHpIdAndQCondBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 安徽东软医保药品目录扩展服务
 * 
 * @author hao_wu
 *
 */
public class BdHpDrugOrginalExtCrudServiceImpl implements IBdHpDrugOrginalExtCudService, IBdHpDrugOrginalExtRService {

	@Override
	public void DeleteAllDrugOrginal() throws BizException {
		DeleteAllDrugOrginal bp = new DeleteAllDrugOrginal();
		bp.exec();
	}

	@Override
	public PagingRtnData<BdHpDrugOrginalDO> findPagingByHpIdAndQCond(String hpId, QryRootNodeDTO qryRootNodeDTO,
			String orderStr, PaginationInfo pg) throws BizException {
		FindDrugPagingByHpIdAndQCondBp bp = new FindDrugPagingByHpIdAndQCondBp();
		PagingRtnData<BdHpDrugOrginalDO> result = bp.exec(hpId, qryRootNodeDTO, orderStr, pg);
		return result;
	}

}
