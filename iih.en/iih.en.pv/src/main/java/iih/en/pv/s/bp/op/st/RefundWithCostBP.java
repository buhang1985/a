package iih.en.pv.s.bp.op.st;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bd.pp.pripm.i.IPripmRService;
import iih.bl.cg.service.d.BL_Register_RefundDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.i.IBLCancelSettlement;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.pay.dto.d.BlPayPmDTO;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlPayPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.d.PayDirectEnum;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.PayInfoDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.sc.sch.reg.dto.d.RegResDTO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 退费（含医保退费逻辑）
 * 包含退费明细
 * @author yank
 *
 */
public class RefundWithCostBP {
	/**
	 * 退费
	 * 可以重收
	 * @param regInfo 挂号信息
	 * @param cgId 记账主键
	 * @param needRecharge 是否重收
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO[] exec(RegInfoDTO regInfo,PayInfoDTO payInfoDTO) throws BizException{
		//1、设置退费DTO
		BL_Register_RefundDTO refundDTO = new BL_Register_RefundDTO();
		refundDTO.setId_ent(regInfo.getId_ent());
		refundDTO.setId_cgoep(regInfo.getId_cg());
//		if(FBoolean.TRUE.equals(payInfoDTO.getFg_originstyle())){
//			refundDTO.setAllRefundAndAllCharge(FBoolean.FALSE);//是否重收
//		}else
//			refundDTO.setAllRefundAndAllCharge(FBoolean.TRUE);//是否重收
		refundDTO.setAllRefundAndAllCharge(FBoolean.FALSE);
		refundDTO.setSd_pttp(regInfo.getSd_pttp());
		FBoolean isPrintRedInc = isPrintRedInc(regInfo.getId_ent());//是否打印红冲发票
		refundDTO.setPrintRedInc(isPrintRedInc);
		
		FArrayList pricedArray = regInfo.getPricedinfo();
		
		
		if(pricedArray != null && pricedArray.size() >0){
			FMap2 map = (FMap2) pricedArray.get(0);
			if(map != null && map.get("PROPOEP") != null){
				FArrayList2 propoepList = (FArrayList2) map.get("PROPOEP");
				refundDTO.setBlPropOepDO(propoepList);
				FArrayList2 proparoepList = (FArrayList2) map.get("PROPAROEP");
		        refundDTO.setBlproparoepAggDO(proparoepList);
			}
		}
//		if(!EnValidator.isEmpty(regInfo.getSn_hp())){
//			if(pricedArray==null || pricedArray.size()==0)
//				throw new BizException(IEnMsgConst.ERROR_OP_CANCREG_NOT_EXIST);
//			else{
//				FMap2 map = (FMap2) pricedArray.get(0);
//				FArrayList2 propoepList = (FArrayList2) map.get("PROPOEP");
//				refundDTO.setBlPropOepDO(propoepList);
//				FArrayList2 proparoepList = (FArrayList2) map.get("PROPAROEP");
//		        refundDTO.setBlproparoepAggDO(proparoepList);
//			}
//		}
		
		//2、构造操作员信息
		ConstructOprBP constructBP = new ConstructOprBP();
		OperatorInfoDTO oprDTO = constructBP.exec();
		
		if(Context.get().getAttribute("ReFundTp") != null)
			oprDTO.setEu_enrefundtp((String)(Context.get().getAttribute("ReFundTp")));
		
		//3、构造支付明细
		BlpaypatoepAggDO payAggDO = this.constructPayAgg(regInfo, payInfoDTO);
		
		IBLCancelSettlement blCancelService = ServiceFinder.find(IBLCancelSettlement.class);
		return blCancelService.Register_RefundAndSettlement_new(refundDTO, oprDTO, payAggDO);
	}
	/**
	 * 是否打印红冲发票
	 * @param entId 就诊ID
	 * @return
	 */
	private FBoolean isPrintRedInc(String entId) throws BizException{
		//1、计算机是否打印发票
		boolean isPrint = EnParamUtils.isPrintInvoice();
		
		//2、判定医保计划，是否需要打印红冲发票
		IBLCancelSettlement blService = ServiceFinder.find(IBLCancelSettlement.class);
		FBoolean isPrintRedInc = blService.getFPrintRedInc(entId);
		
		boolean result = (isPrint && FBoolean.TRUE.equals(isPrintRedInc));
		return new FBoolean(result);
	}
	/**
	 * 构造支付明细
	 * @param payInfoDTO
	 * @return
	 * @throws BizException 
	 */
	private BlpaypatoepAggDO constructPayAgg(RegInfoDTO regInfo, PayInfoDTO payInfoDTO) throws BizException{
		if(FBoolean.TRUE.equals(payInfoDTO.getFg_originstyle())){
			return null;
		}
		BlpaypatoepAggDO blpaypatoepAggDO = new BlpaypatoepAggDO();
        BlPayPatOepDO blPayPatOepDO = new BlPayPatOepDO();
		blPayPatOepDO.setId_grp(EnContextUtils.getGrpId());// 集团
		blPayPatOepDO.setId_org(EnContextUtils.getOrgId());// 组织
        //就诊类型
		blPayPatOepDO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);// 就诊类型id
		blPayPatOepDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);// 就诊类型
		blPayPatOepDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_ST);// 支付类型--结算
		blPayPatOepDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_ST);// 支付类型--结算编码
		
		
        blPayPatOepDO.setId_pat(regInfo.getId_pat());
        blPayPatOepDO.setEu_direct((int)PayDirectEnum.CHANGE);
        //费用来源
        blPayPatOepDO.setSd_pttp(IBlDictCodeConst.SD_PTTP_WINDOW);
        //实际的收付款数肯定应该是要收入的金额
        blPayPatOepDO.setAmt(payInfoDTO.getAmt());

		blPayPatOepDO.setId_org_pay(EnContextUtils.getOrgId());// 支付组织
		blPayPatOepDO.setId_dep_pay(EnContextUtils.getDeptId());// 支付部门
		blPayPatOepDO.setId_emp_pay(EnContextUtils.getPsnId());// 操作员
		blPayPatOepDO.setFg_cc(FBoolean.FALSE);
		blPayPatOepDO.setStatus(DOStatus.NEW);
		
        blpaypatoepAggDO.setParentDO(blPayPatOepDO);
        
        List<BlPayItmPatOepDO> payItmList = new ArrayList<BlPayItmPatOepDO>();
        
        //添加原来的支付明细
        this.addOrigPayItmList(regInfo, payItmList);
        
		if(payInfoDTO.getAmt_pat() == null)
			payInfoDTO.setAmt_pat(FDouble.ZERO_DBL);
		if(payInfoDTO.getAmt_pat().compareTo(FDouble.ZERO_DBL) >= 0){
			String pmId = null;
			if(!EnValidator.isEmpty(payInfoDTO.getId_patstyle()))
				pmId = payInfoDTO.getId_patstyle();
			else
				pmId = this.getPmId(payInfoDTO.getPaystyle());
			BlPayItmPatOepDO bldto = this.createPayItmDO(pmId, payInfoDTO.getPaystyle(), payInfoDTO.getAmt_pat(),String.valueOf(PayDirectEnum.CHANGE),
					payInfoDTO.getId_bank(), payInfoDTO.getNo_bank(), payInfoDTO.getId_cust(), payInfoDTO.getPaycred(), FBoolean.TRUE);
			payItmList.add(bldto);
		}
		blpaypatoepAggDO.setBlPayItmPatOepDO(payItmList.toArray(new BlPayItmPatOepDO[0]));
		return blpaypatoepAggDO;
	}
	
	/**
	 * 获取支付方式ID
	 * 
	 * @param pmCode 支付方式编码
	 * @return
	 * @throws BizException 
	 */
	private String getPmId(String pmCode) throws BizException {
		if(!EnValidator.isEmpty(pmCode)){
			IPripmRService serv = ServiceFinder.find(IPripmRService.class);
			PriPmDO[] prido = serv.findByAttrValString(PriPmDO.CODE, pmCode);
			if(!EnValidator.isEmpty(prido))
				return prido[0].getId_pm();
		}
		throw new BizException("支付方式未定义！") ;
	}
	/**
	 * 创建付款明细DO
	 * 
	 * @param pmId 付款方式ID
	 * @param pmCode 付款方式编码
	 * @param amt 金额
	 * @param direct 支付方向
	 * @param bankId 银行ID
	 * @param bankNo 银行账号
	 * @param custId 支付客户
	 * @param payRemark 支付凭证
	 * @return
	 */
	private BlPayItmPatOepDO createPayItmDO(String pmId, String pmCode, FDouble amt, String direct, String bankId,
			String bankNo, String custId, String payRemark, FBoolean isRealPay) {
		BlPayItmPatOepDO payItmDO = new BlPayItmPatOepDO();
		payItmDO.setEu_direct(Integer.parseInt(direct));
		payItmDO.setAmt(amt == null ? FDouble.ZERO_DBL : amt);
		payItmDO.setSd_pm(pmCode);// 支付方式编码
		payItmDO.setId_pm(pmId);// 支付方式ID
		payItmDO.setId_bank(bankId);// 银行
		payItmDO.setBankno(bankNo);// 账号，含微信、支付宝
		payItmDO.setId_cust(custId);// 支付客户
		payItmDO.setPaymodenode(payRemark);// 支付凭证，付款方备注，订单号
		payItmDO.setFg_realpay(isRealPay);
		payItmDO.setId_grp(EnContextUtils.getGrpId());
		payItmDO.setId_org(EnContextUtils.getOrgId());
		payItmDO.setStatus(DOStatus.NEW);
		return payItmDO;
	}
	/**
	 * 添加原来的支付明细
	 * 
	 * @param regInfoDTO 挂号信息
	 * @param payItmList 支付明细集合
	 * @throws BizException
	 */
	private void addOrigPayItmList(RegInfoDTO regInfoDTO,
			List<BlPayItmPatOepDO> payItmList) throws BizException {
		RegResDTO resDTO = (RegResDTO) regInfoDTO.getRegresarray().get(0);
		FArrayList payDetails = resDTO.getDetails_pay();
		int size = payDetails == null ? 0 : payDetails.size();
		for (int i = 0; i < size; i++) {
			BlPayPmDTO papDetailDTO = (BlPayPmDTO) payDetails.get(i);
			if (IBdPripmCodeConst.CODE_PRI_PM_INSUR.equals(papDetailDTO.getSd_pm())
					|| IBdPripmCodeConst.CODE_PRI_PM_INSURPERSONALACCOUNT.equals(papDetailDTO.getSd_pm())
					|| IBdPripmCodeConst.CODE_PRI_PM_BUSINESS.equals(papDetailDTO.getSd_pm())) {
				BlPayItmPatOepDO payItmDO = this.createPayItmDO(papDetailDTO.getId_pm(), papDetailDTO.getSd_pm(), 
						papDetailDTO.getAmt(), String.valueOf(PayDirectEnum.CHANGE),
						papDetailDTO.getId_bank(), papDetailDTO.getBankno(),
						papDetailDTO.getId_cust(), papDetailDTO.getPaymodenode(), FBoolean.TRUE);
				payItmList.add(payItmDO);
			}
		}
	}
}
