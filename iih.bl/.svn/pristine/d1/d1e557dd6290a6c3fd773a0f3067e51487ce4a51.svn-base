package iih.bl.cg.service.s;

import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.i.IBLPricingAndSettlementBackGroundService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

/**
 *  后台程序：用于患者离院未结算的情况下自动结算。
 *  
 * @author tcy
 * @since 2017-5-24
 *
 */
@Service(serviceInterfaces = { IBLPricingAndSettlementBackGroundService.class }, binding = Binding.JSONRPC)
public class IBLPricingAndSettlementBackGroundServiceImpl implements IBLPricingAndSettlementBackGroundService {
	
	/**
	 * 用于患者离院未结算的情况下自动结算。
	 *	目前仅支持商保记账结算。 
	 *@param days 结算距今天的头几个自然日的费用信息
	 * @throws BizException
	 */
	public FBoolean PriceAndSettlementPayment_hpcg_background()  throws BizException
	{	
		OperatorInfoDTO operatorInfoDTO=new OperatorInfoDTO();
//		operatorInfoDTO.setId_dep(Context.get().getOrgId());
//		operatorInfoDTO.setId_emp(Id_emp);
//		operatorInfoDTO.setId_grp(Id_grp);
//		operatorInfoDTO.setId_org(Id_emp);
//		operatorInfoDTO.setId_org_emp(Id_org_emp);
		int days=1;
		IBLCiOrderToBlCgServiceImpl iBLCiOrderToBlCgServiceImpl=new IBLCiOrderToBlCgServiceImpl();
		return iBLCiOrderToBlCgServiceImpl.PriceAndSettlementPayment_hpcg_background(days, operatorInfoDTO);	
	}
}
