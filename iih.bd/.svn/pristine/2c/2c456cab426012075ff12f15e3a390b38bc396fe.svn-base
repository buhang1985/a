package iih.bd.pp.incca.s;

import iih.bd.pp.incca.bp.InccaBp;
import iih.bd.pp.incca.d.IncCaItmDO;
import iih.bd.pp.incca.d.IncCaItmRelDO;
import iih.bd.pp.incca.d.UnComparisonedSrvDTO;
import iih.bd.pp.incca.i.IIncCaItmrelService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public class IncCaItmrelServiceImpl implements IIncCaItmrelService {

	@Override
	public int getUnComparisonedSrvCount(String str) throws BizException {
		InccaBp inccaBp = new InccaBp();
		if(str != null && !"".equals(str)){
			return inccaBp.getUnComparisonedSrvCount(str);
		}
		return 0;
	}

	@Override
	public UnComparisonedSrvDTO[] getUnComparisonedSrvDtoByIdincca(String id_incca) throws BizException {
		InccaBp inccaBp = new InccaBp();
		return inccaBp.findUnComparisonedSrvDTOByIdincca(id_incca);
	}

	@Override
	public PagingRtnData<MedSrvDO> getUnComparisonedSrvsList(PaginationInfo pg, QryRootNodeDTO qryRootNodeDTO, String idIncca, String idSrvca) throws BizException {
		InccaBp inccaBp = new InccaBp();
		return inccaBp.findUnComparisonedSrv(pg, qryRootNodeDTO, idIncca, idSrvca);
	}

	@Override
	public PagingRtnData<IncCaItmRelDO> getSrvAndSrvcaList(PaginationInfo pg, QryRootNodeDTO[] qryRootNodeDTOArr, IncCaItmDO incCaItmDO)
			throws BizException {
		InccaBp inccaBp = new InccaBp();
		return inccaBp.findSrvAndSrvcaList(pg, qryRootNodeDTOArr, incCaItmDO);
	}

}
