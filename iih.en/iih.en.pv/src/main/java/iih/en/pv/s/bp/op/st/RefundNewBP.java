package iih.en.pv.s.bp.op.st;

import iih.bl.cg.service.d.BL_Register_RefundDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.i.IBLCancelSettlement;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 退费（含医保退费逻辑）
 * @author WJY
 *
 */
public class RefundNewBP {
	/**
	 * 退费
	 * 可以重收
	 * @param entId 就诊id
	 * @param cgId 记账主键
	 * @param needRecharge 是否重收
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO[] exec(RegInfoDTO regInfo,FBoolean needRecharge, FBoolean isRealPay) throws BizException{
		BL_Register_RefundDTO refundDTO = new BL_Register_RefundDTO();
		refundDTO.setId_ent(regInfo.getId_ent());
		refundDTO.setId_cgoep(regInfo.getId_cg());
		refundDTO.setAllRefundAndAllCharge(needRecharge);
		refundDTO.setSd_pttp(regInfo.getSd_pttp());
		refundDTO.setPrintRedInc(FBoolean.FALSE);//不打印红冲发票
		
		FArrayList pricedArray = regInfo.getPricedinfo();	
		if(!EnValidator.isEmpty(regInfo.getSn_hp())){
			if(pricedArray==null || pricedArray.size()==0)
				throw new BizException(IEnMsgConst.ERROR_OP_CANCREG_NOT_EXIST);
			else{
				FMap2 map = (FMap2) pricedArray.get(0);
				FArrayList2 propoepList = (FArrayList2) map.get("PROPOEP");
				refundDTO.setBlPropOepDO(propoepList);
		        FArrayList2 proparoepList = (FArrayList2) map.get("PROPAROEP");
		        refundDTO.setBlproparoepAggDO(proparoepList);
			}
		}
		
		ConstructOprBP constructBP = new ConstructOprBP();
		OperatorInfoDTO oprDTO = constructBP.exec();
		
		IBLCancelSettlement blCancelService = ServiceFinder.find(IBLCancelSettlement.class);
		return blCancelService.Register_RefundAndSettlement(refundDTO, oprDTO, isRealPay);
	}
}
