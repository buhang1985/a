package iih.bl.cg.service.s;

import iih.bl.cg.blcgquery.bp.BlCgIpPricing;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.i.IBLCgIpRePricingService;

import java.util.List;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.jdbc.facade.DAFacade;

@Service(serviceInterfaces = { IBLCgIpRePricingService.class }, binding = Binding.JSONRPC)
public class IBLCgIpRePricingImpl implements IBLCgIpRePricingService{

	@Override
	public BlCgIpDO[] BlCgIpRePricing(BlCgIpDO[] blCgIpDOarr, String id_ent,
			OperatorInfoDTO operatorInfoDTO) throws BizException {
		BlCgIpPricing bp=new BlCgIpPricing();
		bp.BlCgIpRePricing(blCgIpDOarr, id_ent, operatorInfoDTO);		
		return  GetPatBlCgIpWithoutMMByIdent(id_ent);
	}

	@Override
	public BlCgIpDO[] GetPatBlCgIpWithoutMMByIdent(String id_ent)
			throws BizException {
		DAFacade dAFAcade=new DAFacade();
		List<BlCgIpDO> blCgIpDOList=(List<BlCgIpDO>)dAFAcade.findByCond(BlCgIpDO.class, " id_ent='"+id_ent+"' and fg_mm<>'Y'");
		if(blCgIpDOList==null || blCgIpDOList.size()==0)
		{
			throw new BizException("该就诊下的费用明细为空。就诊ID:"+id_ent);
		}
		return blCgIpDOList.toArray(new BlCgIpDO[]{});
	}

}
