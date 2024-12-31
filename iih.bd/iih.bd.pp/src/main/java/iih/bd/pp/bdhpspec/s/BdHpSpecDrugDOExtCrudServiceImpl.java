package iih.bd.pp.bdhpspec.s;

import iih.bd.pp.bdhpspec.d.BdHpSpecDO;
import iih.bd.pp.bdhpspec.d.BdHpSpecDrugDO;
import iih.bd.pp.bdhpspec.i.IBdHpSpecDrugDOExtCudService;
import iih.bd.pp.bdhpspec.i.IBdHpSpecDrugDOExtRService;
import iih.bd.pp.bdhpspec.s.bp.FindMedicalCareSrvBp;
import iih.bd.pp.bdhpspec.s.bp.FindMedicalInsurPagingDataByQCondBp;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保特殊病可开项目扩展查询服务
 * 
 * @author hao_wu
 *
 */
public class BdHpSpecDrugDOExtCrudServiceImpl implements IBdHpSpecDrugDOExtCudService, IBdHpSpecDrugDOExtRService {

	@Override
	public PagingRtnData<BdHpSpecDrugDO> FindMedicalCareSrv(BdHpSpecDO bdHpSpecDo, QryRootNodeDTO qryRootNodeDto,
			PaginationInfo pg) throws BizException {
		FindMedicalCareSrvBp bp = new FindMedicalCareSrvBp();
		PagingRtnData<BdHpSpecDrugDO> result = bp.exec(bdHpSpecDo, qryRootNodeDto, pg);
		return result;
	}

	@Override
	public PagingRtnData<HPSrvorcaDO> FindMedicalInsurPagingDataByQCond(QryRootNodeDTO qryRootNodeDto,
			PaginationInfo pg) throws BizException {
		FindMedicalInsurPagingDataByQCondBp bp = new FindMedicalInsurPagingDataByQCondBp();
		PagingRtnData<HPSrvorcaDO> result = bp.exec(qryRootNodeDto, pg);
		return result;
	}
}
