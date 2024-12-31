package iih.bl.cg.blcgquery.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bl.cg.blcgipmend.bp.BlCgIpMendBp;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.i.IBLOrderAppendBillService;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.en.pv.pativisit.d.PatiVisitDO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 住院重划价
 * @author tcy
 *
 */
public class BlCgIpPricing {
	/**
	 * 住院重划价：先对原有费用进行红冲（含改就诊账户)，再重新计价（含就诊账户）
	 * @param blcgqueryAggDOarr需要进行重新计价的服务信息
	 * @return
	 */
	public FBoolean BlCgIpRePricing(BlCgIpDO[] blCgIpDOarr,String id_ent,OperatorInfoDTO operatorInfoDTO) throws BizException
	{
		if(blCgIpDOarr==null)
		{
			throw new BizException("没有需要重新计价的数据");
		}
		FBoolean fg_pricing=FBoolean.FALSE;
		BlCgIpMendBp bp=new BlCgIpMendBp();
		IBLOrderAppendBillService iBLOrderAppendBillService=ServiceFinder.find(IBLOrderAppendBillService.class);
		List<BlOrderAppendBillParamDTO> OrginBlOrderAppendBillParamDTOList=new ArrayList<BlOrderAppendBillParamDTO>();
		for(BlCgIpDO blCgIpDO:blCgIpDOarr)
		{
			OrginBlOrderAppendBillParamDTOList.add(bp.getRePricingBlOrderAppendBillParamDTO(blCgIpDO,operatorInfoDTO, FBoolean.FALSE,BookRtnDirectEnum.CHARGE));
		}		
		
		//1.采用红冲方案处理：先退费，再收费
		//红冲对应的数据，且调整账户金额
		iBLOrderAppendBillService.SetOrderRefundBill(OrginBlOrderAppendBillParamDTOList.toArray(new BlOrderAppendBillParamDTO[]{}), false, IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		
		//2.重新划价:生成按价格分类生成新数据，且调整账户
	//	PativisitRServiceImpl pativisitCrudServiceImpl=ServiceFinder.find(PativisitRServiceImpl.)
		PatiVisitDO patiVisitDO=new PatiVisitDO();
		
		String id_pripat=patiVisitDO.getId_pripat();
		//由红冲数据组装待划价的新数据
		for(BlOrderAppendBillParamDTO dto:OrginBlOrderAppendBillParamDTOList)
		{
			//需要重新计价
			dto.setId_pripat(id_pripat);
			dto.setPrice(null);
			dto.setId_par(null);
			dto.setId_cg(null);
		}
		//iBLOrderAppendBillService.SetOrderAppendBill(OrginBlOrderAppendBillParamDTOList.toArray(new BlOrderAppendBillParamDTO[]{}), false);
		//新接口，按明细进行补费
		iBLOrderAppendBillService.SetOrderAppendBill_ByItms(OrginBlOrderAppendBillParamDTOList.toArray(new BlOrderAppendBillParamDTO[]{}), IBdFcDictCodeConst.SD_CODE_ENTP_IP);

		return fg_pricing;
	}

}
