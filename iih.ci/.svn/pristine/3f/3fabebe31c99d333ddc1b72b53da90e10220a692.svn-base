package iih.ci.mrqc.mrqccommon.s;

import iih.bd.srv.dto.d.MrCaCtmMrDTO;
import iih.bd.srv.dto.d.MrDTO;
import iih.ci.mrqc.mrqccommon.bp.GetMrqcTreeBp;
import iih.ci.mrqc.mrqccommon.i.IMrQcCommonService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = { IMrQcCommonService.class }, binding = Binding.JSONRPC)
public class MrQcCommonServiceImpl implements IMrQcCommonService{

	@Override
	public MrCaCtmMrDTO[] getMrQcCommonTreeForMrcactm(String id_ent, String code_entp, Integer hasAll, 
			String docornurse,String id_su_mr) throws BizException {
		GetMrqcTreeBp mrqctree = new GetMrqcTreeBp();
		return mrqctree.getMrQcCommonTreeForMrcactm(id_ent, code_entp, hasAll, docornurse, id_su_mr);
	}

	@Override
	public MrDTO[] getMrQcCommonTreeForMrDto(String id_ent, String id_mrcactm, String code_entp, String paramtype, 
			String docornur, String id_su_mr) throws BizException {
		GetMrqcTreeBp mrqctree = new GetMrqcTreeBp();
		return mrqctree.getMrQcCommonTreeForMrDto(id_ent, id_mrcactm, code_entp, paramtype, docornur,id_su_mr);
	}

}
