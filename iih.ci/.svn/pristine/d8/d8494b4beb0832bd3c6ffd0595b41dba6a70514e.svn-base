package iih.ci.ord.s;

import iih.ci.ord.bloodbadreaction.d.CiBloodAdverseReactionDO;
import iih.ci.ord.cibloodadversereactioncount.d.CiBloodAdverseReactionCountDTO;
import iih.ci.ord.dto.bloodbadreaction.BloodFetchDTO;
import iih.ci.ord.i.ICiBloodBadReactionService;
import iih.ci.ord.s.ems.op.bloodbadreaction.BloodBadReactionAction;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

@Service(serviceInterfaces = { ICiBloodBadReactionService.class }, binding = Binding.JSONRPC)
public class CiBloodBadReactionServiceImpl implements ICiBloodBadReactionService {
	BloodBadReactionAction bdraction = new BloodBadReactionAction();
	@Override
	public CiBloodAdverseReactionDO create(BloodFetchDTO bfdto) throws BizException {
		// TODO Auto-generated method stub
		return bdraction.create(bfdto);
	}

	@Override
	public CiBloodAdverseReactionDO[] load(CiBloodAdverseReactionDO cbardo) throws BizException {
		// TODO Auto-generated method stub
		return bdraction.load(cbardo);
	}

	@Override
	public CiBloodAdverseReactionDO[] save(CiBloodAdverseReactionDO cbardo) throws BizException {
		// TODO Auto-generated method stub
		return bdraction.save(cbardo);
	}

	@Override
	public PagingRtnData<CiBloodAdverseReactionCountDTO> qryCountData(QryRootNodeDTO qryRootNodeDTO,PaginationInfo pg)
			throws BizException {
		return bdraction.qryCountData(qryRootNodeDTO, "", pg);
	}

	@Override
	public BloodFetchDTO[] getAllBFData8En(String id_en) throws BizException {
		// TODO Auto-generated method stub
		return bdraction.getAllBFData8En(id_en);
	}


	
}
