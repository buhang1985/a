package iih.en.pv.s.bp.op.st;


import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.i.IBLCiOrderToBlCgService;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.prop.blproparoep.d.BlproparoepAggDO;
import iih.bl.prop.blpropoep.d.BlPropOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.PayInfoDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.mi.biz.dto.d.OepSettleRtnValDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 新结算方法
 * 根据前端划价，结算收款
 * @author yank
 * @author wjy
 *
 */
public class SettleNewBP {
	/**
	 * 根据前端划价，结算收款
	 * @param patId 患者id
	 * @param regInfo 挂号信息
	 * @param payInfoDTO 支付信息
	 * @param oprId 操作员id 
	 * @return 记账id
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO[] settle(String patId,RegInfoDTO regInfo,PayInfoDTO payInfoDTO, String oprId) throws BizException {
		//1、获取划价信息
		FArrayList pricedArray = regInfo.getPricedinfo();	
		if(pricedArray==null || pricedArray.size()==0){
			throw new BizException(IEnMsgConst.ERROR_OP_REG_PRICE_NOT_EXIST);
		}
		FMap2 map = (FMap2) pricedArray.get(0);
		BlOrderAppendBillParamDTO[] billParamDTOList = null;
		if(map.get("0") != null)
		{
			FArrayList farr = (FArrayList) map.get("0"); //未分解的费用信息
			billParamDTOList = new BlOrderAppendBillParamDTO[farr.size()];
			for (int i = 0; i < farr.size(); i++) {
				BlOrderAppendBillParamDTO blOrder = (BlOrderAppendBillParamDTO) farr.get(i);
				blOrder.setId_ent(regInfo.getId_ent());
				blOrder.setId_pat(patId);
				blOrder.setDt_or(EnAppUtils.getServerDateTime());
				blOrder.setId_hp(regInfo.getId_hp());
				if(!FBoolean.TRUE.equals(payInfoDTO.getFg_acc())){
					blOrder.setFg_pricinginsertcg(FBoolean.TRUE);
				}
//				blOrder.setSd_hpsrvtp(Sd_hpsrvtp); //
				billParamDTOList[i] = blOrder;
			}
		}
		//BlOrderAppendBillParamDTO[] billParamDTOList = (BlOrderAppendBillParamDTO[]) farr.toArray(new BlOrderAppendBillParamDTO[]{} );//待分解的费用明细
		BlpaypatoepAggDO payOepAggDO = (BlpaypatoepAggDO)map.get("1");//支付明细
		CreatePayOepBP createPayBP = new CreatePayOepBP();
		payOepAggDO = createPayBP.exec(patId, payInfoDTO, regInfo);//支付明细
		
		BlPropOepDO[] propOepDOList = null;
		if(map.get("2") != null)
		{
			FArrayList farr2 = (FArrayList) map.get("2");//医保分摊1
			propOepDOList = new BlPropOepDO[farr2.size()];
			for (int i = 0; i < farr2.size(); i++) {
				BlPropOepDO propOepDO = (BlPropOepDO) farr2.get(i);
				propOepDOList[i] = propOepDO;
			}
		}
		
		BlproparoepAggDO[] proparOepAggDOList = null;
		if(map.get("3") != null)
		{
			FArrayList farr3 = (FArrayList) map.get("3");//医保分摊2
			proparOepAggDOList = new BlproparoepAggDO[farr3.size()];
			for (int i = 0; i < farr3.size(); i++) {
				BlproparoepAggDO proparoepAggDo = (BlproparoepAggDO) farr3.get(i);
				proparOepAggDOList[i] = proparoepAggDo;
			}
		}
		
		
		OperatorInfoDTO operDTO = (OperatorInfoDTO)map.get("4");//操作员信息
		String tradeNo = (String)map.get("5");//医保交易号
		String stCode = (String)map.get("6");//业务结算流水号        
		FBoolean fgPrint = (FBoolean)map.get("7");//是否打印发票号
		FBoolean isTransferPrepay = (FBoolean)map.get("8");//余额是否存储到预交金
		OepSettleRtnValDTO settledto = new OepSettleRtnValDTO();
		if(map.get("OepSettleRtnValDTO") != null){
			FArrayList feeinfo = (FArrayList) map.get("OepSettleRtnValDTO");
			settledto =(OepSettleRtnValDTO)feeinfo.get(0);//医保划价返回DTO
		}
		long b = System.currentTimeMillis();
		
		IBLCiOrderToBlCgService blcgservice=ServiceFinder.find(IBLCiOrderToBlCgService.class);
		BlIncItmVsTypeDTO[] incItms = blcgservice.PriceAndSettlementPaymentInsurance_Register(billParamDTOList,payOepAggDO,propOepDOList,proparOepAggDOList,operDTO,tradeNo,stCode,fgPrint,isTransferPrepay,regInfo.getId_cg(),settledto);
		
		if(EnValidator.isEmpty(incItms)){
			throw new BizException(IEnMsgConst.ERROR_OP_REG_SETTLE_FAILED);
		}
		
		long e = System.currentTimeMillis();
		Logger.info("挂号调用BL结算：" + (e - b));
		
		return incItms;
	}
}
