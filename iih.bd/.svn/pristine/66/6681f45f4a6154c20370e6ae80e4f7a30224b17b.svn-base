package iih.bd.pp.srvctrdi.s;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.srvctrdi.d.BdHpSrvCtrDiDO;
import iih.bd.pp.srvctrdi.i.ISrvctrdiExtCudService;
import iih.bd.pp.srvctrdi.i.ISrvctrdiExtRService;
import iih.bd.pp.srvctrdi.s.bp.FindByIdBp;
import iih.bd.pp.srvctrdi.s.bp.FindPagingDataByHpAndQCondBp;
import iih.bd.pp.srvctrdi.s.bp.FindPagingDataByQCondBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保诊断限制扩展服务
 * 
 * @author hao_wu
 *
 */
public class SrvctrdiExtCrudServiceImpl implements ISrvctrdiExtCudService, ISrvctrdiExtRService {

	@Override
	public PagingRtnData<BdHpSrvCtrDiDO> FindPagingDataByQCond(QryRootNodeDTO qryRootNodeDto, PaginationInfo pg)
			throws BizException {
		FindPagingDataByQCondBp bp = new FindPagingDataByQCondBp();
		PagingRtnData<BdHpSrvCtrDiDO> result = bp.exec(qryRootNodeDto, pg);
		return result;
	}

	@Override
	public BdHpSrvCtrDiDO FindById(String id) throws BizException {
		FindByIdBp bp = new FindByIdBp();
		BdHpSrvCtrDiDO result = bp.exec(id);
		return result;
	}

	@Override
	public PagingRtnData<BdHpSrvCtrDiDO> FindPagingDataByHpAndQCond(HPDO hpdo, QryRootNodeDTO qryRootNodeDto,
			PaginationInfo pg) throws BizException {
		FindPagingDataByHpAndQCondBp bp = new FindPagingDataByHpAndQCondBp();
		PagingRtnData<BdHpSrvCtrDiDO> result = bp.exec(hpdo,qryRootNodeDto, pg);
		return result;
	}
	
}
